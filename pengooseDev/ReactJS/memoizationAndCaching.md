## 궁금증 발생

ReactJS에서의 **메모이제이션**은 순수함수에 들어가는 매개변수의 값이 같을 경우 객체를 새로 생성하는 것이 아니라, 이전에 참조하던 객체의 주소를 그대로 사용한다. 이 데이터는 **`힙 메모리`**에 저장된다.

반면, **캐싱** 작업은 명시적으로 데이터를 **`캐시 메모리`에 저장**함으로써 이루어진다.

메모이제이션은 메모리 캐시, 디스크 캐시, 브라우저 캐시, 분산 캐시, 그 어디에도 소속되지 않는다. 그렇다면 **`메모이제이션을 과연 캐싱이라고 부를 수 있는가?`** 그저 캐싱과 비슷하게 구현한 것이 아닌가?

---

## 결론

보편적으로 관점으로는 `캐싱이 맞다`. 하지만, 기술적으로 `엄밀히 따진다면 캐싱이 아니라고 생각`한다.

---

## 알아야 할 것

### 캐싱이란?

> **`캐싱`**은 시간이 오래 걸리는 연산 결과나 **데이터를 저장**해두고, 이를 **재사용**함으로써 **처리시간을 줄이는 것**을 뜻한다.

즉, 위에서 언급한 캐시 메모리처럼 캐싱 방법에 따른 **특정 저장소를 이용하지 않아도 된다**는 것이다.
예를들어, 연산이 오래걸리는 함수의 결과값을 로컬스토리지나 글로벌 스코프의 변수에 저장한 뒤 이를 재사용 하는 것도 캐싱이라는 것이다.

### 메모이제이션이란?

메모이제이션은 **`순수 함수`**에 사용할 수 있다.

**`순수 함수`**란 입력값이 같을 때, 결과 값도 동일한 함수를 뜻한다. 즉, 하나의 순수 함수에 대해 동일한 매개변수를 입력한다면, 그에 대한 결과물도 동일하다는 뜻이다.

즉, **메모이제이션**은 순수함수에 **동일한 매개변수**를 집어넣을 경우 다시 JS의 콜스택에 올리는 것이 아니라, **이전에 저장해둔 결과값을 참조**한다는 뜻이다.

### re-rendering은 언제 발생하는가

- state가 변경될 때
- 내려받은 props가 변경될 때
- 상위 컴포넌트가 re-render되었을 경우.

---

## ReactJS에서의 메모이제이션

### **React.memo()**

> **함수형 컴포넌트**를 메모이징 한다.

props와 state가 변하지 않는다면 함수형 컴포넌트가 return하는 컴포넌트(객체)의 값은 동일하다. 다만, 객체는 참조 데이터 타입이기 때문에 이전과 데이터 영역의 값이 같더라도 **메모리 주소가 새로 할당**된다. 따라서, 부모 컴포넌트가 re-render되면 자식 컴포넌트들의 **값이 변경되지 않았더라도 re-rendering**되는 것이다.

React.memo는 해당 컴포넌트의 데이터 영역 값이 이전과 같다면 새로운 컴포넌트 객체를 return하는 것이 아니라, **이전에 사용하던 객체의 메모리 주소를 그대로 참조**하도록 한다. 즉, **값이 변하지 않았다면** 부모 컴포넌트가 re-rendering되더라도 **해당 컴포넌트는 다시 렌더링되지 않는다**. 이로써 불필요한 렌더링을 최소화시켜 최적화의 효과를 얻을 수 있다.

물론, 메모이징을 한다는 것 자체가 메모리 힙에 데이터를 저장한다는 것이기 때문에 무분별한 메모이징은 삼가토록 한다.

### **useCallback()**

> **콜백함수**를 메모이징한다.

함수형 컴포넌트가 실행되면, 해당 스코프의 함수도 다시 선언된다.
함수는 일급 객체. 즉, 참조 타입 데이터이다.
즉, 이전과 같이 함수의 **메모리 주소가 변한다**는 뜻이다.

하위 컴포넌트에 props로 콜백함수를 넘길 경우, 상위 컴포넌트가 re-rendering 될 때 하위 컴포넌트에 React.memo를 통한 메모이징을 했더라도 props가 바뀐 것으로 판단한다. 따라서 re-rendering의 대상이 된다.

useCallback()은 이러한 상황을 방지한다.

```tsx
// ./src/App.tsx
export default function App() {
  const [data, setData] = useState(0);

  const clickHandler = useCallback(() => {
    setData((prev) => (prev += 1));
  }, []);

  return <Child data={data} handler={clickHandler} />;
}
```

```tsx
// ./src/Child.tsx
import React from 'react';
const Child = ({ data, handler }) => {
  return <div onClick={handler}>Child</div>;
};

export default React.memo(Child);
```

App의 state가 바뀌는 코드가 없어서 re-rendering이 되진 않는다. 다만, App가 re-rendering이 되는 경우 clickHandler에 useCallback을 걸어놓았기 때문에 메모이제이션이 되어서 Child컴포넌트가 re-render되지 않는다.

즉, Child 컴포넌트 함수를 전달하는 경우, React.memo를 통해 컴포넌트를 메모이징하고, useCallback을 사용하여 props로 전달되는 함수(객체)를 메모이징하는 것이다.

### **useMemo()**

> **함수의 연산 결과**를 메모이징 한다.

연산이 오래걸리는 함수의 경우, 결과값을 메모이징할 수 있다.
사실 **React.memo와 같은 논리**이다. 다만, React.memo는 컴포넌트 외부에서 컴포넌트를 return하는 함수에 적용하는 것이고, useMemo는 컴포넌트 내부의 함수에 적용하는 것이다.

---

### 회고

"캐싱"에 대한 개념이 명확하지 않았기 때문에 발생한 문제이다.

"캐싱"이란 엄밀히 따졌을 때, 반드시 브라우저 캐시, 메모리 캐시, 디스크 캐시, 분산 캐시 중 하나에 해당되어야 한다고 생각했다. 보편적인 관점에선 엄밀히 따지지 않아, 특정 메모리를 사용하거나 위의 사례에 해당되지 않아도 캐싱으로 인정하는 분위기였다.

다만, 기술적인 측면에서 엄밀히 따졌을 때, `메모이제이션은 캐싱이 아니다`라고 보는 것이 타당하지 않나라는 생각을 갖게 되었다.

이와 같은 관점에서, 메모이제이션은 하나의 함수에 동일한 매개변수가 들어갔을 경우, 새로운 결과값을 연산하는 것이 아니라, 이전의 결과값을 참조하여 사용하는 것이다. 즉, 힙 메모리 영역을 벗어나지 않기 때문에, 메모이제이션은 캐싱의 개념을 차용한 것이지 캐싱이 아니라고 판단했다.

CS적 지식이 항상 중요한 것 같다.

---

#### +a 캐싱관련 보면 좋을 자료

##### [> Ref 웹뷰의 cache](https://d2.naver.com/helloworld/1059747)
