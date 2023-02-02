## 리팩터링

리팩터링(소프트 코딩)을 하던 도중 아래와 같이 Constant를 immutable화 함으로써 안정성을 확보하였다.

```js
const END_POINT = Object.freeze({
  HELLO: '/api/hello',
});

const ERROR = Object.freeze({
  ENONT: 'ENOENT',
  ENONT_MESSAGE: 'Unusable API EndPoint',
  PROTOCOL_MESSAGE: 'Protocol Error',
});

const API = Object.freeze({
  END_POINT: END_POINT,
  ERROR: ERROR,
});
```

물론, 아래와 같은 코드가 익숙할 수 있다.

```js
const API = Object.freeze({
  END_POINT: {
    HELLO: '/api/hello',
  },
  ERROR: {
    ENONT: 'ENOENT',
    ENONT_MESSAGE: 'Unusable API EndPoint',
    PROTOCOL_MESSAGE: 'Protocol Error',
  },
});
```

---

위처럼 객체가 중첩된 상태에서 Object.freeze()를 사용하면 `depth가 1`인 값(데이터 영역)들에 대해서만 `불변성이 확정`되며 `depth가 2이상`의 참조값은 값이 `여전히 가변적`이다.

따라서 각 Layer별로 object를 freeze하고 상위 객체에서 이를 참조한 뒤, 다시 freeze를 하는 방식으로 구현한 것이다.

문제는 nested Object의 depth가 깊어질수록 위의 과정이 복잡해져 이를 해결하는 재귀함수를 작성해야 한다는 의미이다.

---

## 궁금증 발생

**왜 `Object.freeze()는 depth가 1까지만 적용`될까?**
문득 생각해보면, `참조 데이터(Object, Array)`에 적용되는 메서드들은 대부분 `depth가 1`이다. spread 연산자를 통한 deepCopy 또한 1만큼만 복사가 되고, 하위 depth는 참조값을 그대로 유지한다.

**왜 이런 문제가 발생할까?**

**JS의 `메모리 구조`**를 살펴보자.

![](https://velog.velcdn.com/images/pengoose_dev/post/8e141ee0-e05e-40f4-9d75-c5dadaa25cf3/image.png)

메모리는 `변수 영역`과 `데이터 영역`으로 구분된다.

불변값(string, number, boolean, Symbol, undefined, null)을 저장하는 경우 변수영역은 `식별자`와 `불변값이 담겨있는 메모리의 주소`를 저장한다. 따라서 해당 메모리 주소로 가면 값을 참조할 수 있게 된다.

```js
const myObject = {
  score: 100,
};
```

한 편, object의 경우 식별자의 메모리 주소(변수 영역)에 담겨있는 object의 데이터 주소를 따라가보자.
@5002번(데이터 영역)에는 값이 아닌 또 `다른 변수영역들`이 담겨있다.

![](https://velog.velcdn.com/images/pengoose_dev/post/86abfc4a-f823-4d7a-a6d2-4c16af07ee28/image.png)

`const` 키워드는 식별자의 `변수영역의 재할당을 막는 처리`였다면, `Object.freeze()`는 `데이터 영역의 변경을 막는 처리`를 진행하는 것으로 추론할 수 있다.

```js
const obj = Object.freeze({ 1: 2 });

a[1] = 3;
console.log(a); //{1: 2}

a[2] = 3;
console.log(a); //{1: 2}
```

---

## 결론(뇌피셜)

요컨대 해당 질문은 아래와 같이 간단하게 요약할 수 있다.
**Object.freeze와 Array(참조 데이터)의 스프레드 연산자는 "변수 영역이 아닌 데이터 영역 단위"로 적용되는가?"**

참조 데이터(객체)의 변수 영역은 데이터 영역의 주소가, 해당 데이터 영역의 주소에는 각 key와 value의 쌍으로 이루어진 변수 영역의 메모리 주소들이 담긴다.
참조 데이터를 freeze하더라도 해당 식별자(변수 영역에 저장되어있는 데이터 영역의 메모리 주소)의 데이터 영역만을 freeze하기 때문에 key에 대한 value값이 다시 변수영역인 참조 데이터의 경우 (nested Object나 value값이 Array인 경우), 해당 변수 영역에 대한 데이터 영역의 불변성을 보장할 수 없다. 따라서, Object.freeze()는 depth가 1을 초과하는 참조 데이터에 대한 값의 불변성을 보장하지 못하게 되는 것이다. (spread연산자도 동일한 논리)
