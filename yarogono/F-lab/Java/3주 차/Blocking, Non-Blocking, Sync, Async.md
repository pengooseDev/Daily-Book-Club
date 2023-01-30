# 🔗 참고자료

---

- IBM - Boost application performance using asynchronous I/O ⇒ [**링크**](https://developer.ibm.com/articles/l-async/)
- Blocking, Non-blocking, Sync, Async의 차이 ⇒ [**링크**](https://jh-7.tistory.com/25)
- 비동기(Aynchronous) 논블로킹(Non-Blocking) 처리 방식 ⇒ [**링크**](https://junhyunny.github.io/information/java/asynchronous-and-non-blocking-process/)
- 기술노트with알렉 - 동기식 비동기식 딱 설명드릴께요 ⇒ [**링크**](https://www.youtube.com/watch?v=U42qWURR6Gw&ab_channel=%EA%B8%B0%EC%88%A0%EB%85%B8%ED%8A%B8with%EC%95%8C%EB%A0%89)
- [10분 테코톡] 멍토의 Blocking vs Non-Blocking, Sync vs Async ⇒ [**링크**](https://www.youtube.com/watch?v=oEIoqGd-Sns&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC)

# ✏공부 내용 정리

---

## 블로킹(Blocking)

---

![asynchronous-and-non-blocking-process-1.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ac6d7ed7-85ba-4fde-a906-a17615e4440c/asynchronous-and-non-blocking-process-1.gif)

자신의 작업을 진행하다가 다른 주체의 작업이 시작되면,

다른 작업이 끝날 때까지 기다렸다가 자신의 작업을 시작하는 것

- 전통적인 서버 요청 방식이나 일반적인 함수 호출을 예로 들 수 있습니다.

## 논블로킹(Non-Blocking)

---

![asynchronous-and-non-blocking-process-2.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/55e9c05e-4cb0-4bc1-b506-8fa402536383/asynchronous-and-non-blocking-process-2.gif)

- 논블로킹 방식은 말그대로 막히지 않는 것
- 누군가에게 일을 요청한 후 결과를 기다리지 않고, 자신의 일을 계속 수행해 나가는 방식

블로킹과 논블로킹은

> 다른 주체가 작업할 때 자신의 제어권이 있다 없다로 볼 수 있다.
> 

## 동기(Synchronous)

---

- 작업을 동시에 수행하거나, 동시에 끝나거나, **끝나는 동시에 시작함**을 의미
    - 함수를 호출하고 리턴 값이 올 때까지 기다린다.

## 비동기(Asynchronous)

---

- 종료가 일치하지 않으며, **끝나는 동시에 시작을 하지 않음**을 의미
    - 함수를 호출 한다고 하면 리턴 값이 오던 안도던 상관 없이 다른 로직 진행

동기와 비동기는

> 결과를 돌려주었을 때 순서와 결과에 관심이 있는지 없는지에 따라 판단 할 수 있다.
> 

## 내용 정리

---

**Blocking vs Non-Blocking : 제어의 관점**

**Sync vs Async : 순서와 결과(차리)의 관점**

# 공부하면서 느낀 점

---

- 블로킹과 논블로킹 차이를 예시로 생각해서 공부를 해보자.
- 개념을 이해하는데 너무 오랜 시간을 쏟지 말자.
    - 1시간 이상 해당 내용을 보고 있어도 이해가 안되면 넘어가기
    - 넘어가고 나서 나중에 또 해당 내용 보기
    - 오래 본다고 해서 해결 되지는  않는다.
    - 타이머를 적절히 사용하자.