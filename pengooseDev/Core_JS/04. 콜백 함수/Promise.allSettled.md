## 비동기 함수의 병렬적 실행

1. 버튼을 누르면 두 개의 URL(MY_URL)로 **동시에 요청**을 보냅니다.
2. **각 요청의 결과**를 콘솔로 출력합니다.
3. 에러가 발생할 경우, 에러를 콘솔로 출력합니다.

---

## Promise.all()을 이용한 구현

```js
/* CONSTANT */
const MY_URL = Object.freeze({
  CAT: 'https://api.thecatapi.com/v1/images/search',
  DOG: 'https://api.thedogapi.com/v1/images/search',
});

const getCatAndDog = async () => {
  const res = await Promise.all(
    Object.values(MY_URL).map((url) => {
      return new Promise(async (resolve, reject) => {
        try {
          const data = await fetch(url);
          resolve(data.json());
        } catch (error) {
          reject(error);
        }
      });
    })
  );

  console.log(res);
};
```

---

## Promise.all()의 문제점

두 개의 요청 중 **`하나만 실패하더라도, 결과물을 받을 수 없게 된다.`**
Cat과 Dog의 URL에 fetch를 보냈을 때 아래의 경우를 생각해보자.

```js
//pseudo-code
const responseState = {
  Cat: <fulfilled>,
  Dog: <rejected>,
}
```

Cat의 URL에 대한 요청은 정상적으로 이행이 되었고,
Dog의 URL에 대한 요청은 이행되지 않았다.

이러한 경우, Promise.all()은 최종적으로 reject되었다는 에러만 뱉어낸다.
병렬 요청의 수가 많아질수록 정상적으로 동작하지 않을 확률이 기하급수적으로 올라간다는 의미이다.

---

## Promise.allSettled()을 이용한 구현

코드는 동일하지만 Promise의 메서드만 변경해주면 된다.

```js
/* CONSTANT */
const MY_URL = Object.freeze({
  CAT: 'https://api.thecatapi.com/v1/images/search',
  DOG: 'https://api.thedogapi.com/v1/images/search',
});

const getCatAndDog = async () => {
  const res = await Promise.allSettled(
    Object.values(MY_URL).map((url) => {
      return new Promise(async (resolve, reject) => {
        try {
          const data = await fetch(url);
          resolve(data.json());
        } catch (error) {
          reject(error);
        }
      });
    })
  );

  console.log(res);
  return res;
};
```

---

## 결과

Promise.allSettled()는 각 요청에 대한 결과를 Object 타입의 결과값이 들어있는 1차원 배열을 return한다. 중요한 점은 rejected된 항목과 fulfilled된 `각각의 결과값을 각각 Object에 담아 1차원 배열로 return`한다는 것이다.

```js
//pseudo-code
const res = [
  { status: 'fulfilled', value: Array(1) },
  { status: 'rejected', value: Array(1) },
];
```
