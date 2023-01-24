# 🔗 참고자료

---

- Blocking/Non-Blocking I/O && I/O 이벤트 통지 모델 ⇒ [**링크**](https://velog.io/@octo__/BlockingNon-Blocking-IO-IO-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%ED%86%B5%EC%A7%80-%EB%AA%A8%EB%8D%B8)
- Blocking, non-blocking io, 동기, 비동기 개념 정리 ⇒ [**링크**](https://limdongjin.github.io/concepts/blocking-non-blocking-io.html#ibm-%E1%84%8B%E1%85%A1%E1%84%90%E1%85%B5%E1%84%8F%E1%85%B3%E1%86%AF)
- IBM Boost application performance using asynchronous I/O ⇒ [**링크**](https://developer.ibm.com/articles/l-async/)
- 비동기(Asynchronous) 논블로킹(Non-Blocking) 처리 방식 ⇒ [**링크**](https://junhyunny.github.io/information/java/asynchronous-and-non-blocking-process/)
- 블럭, 논블럭, 동기, 비동기 이야기 ⇒ [**링크**](https://hamait.tistory.com/930)
- 동기/비동기와 블로킹/논블로킹 ⇒ [**링크**](https://deveric.tistory.com/99)
- Evan님 블로그 - 동기(Synchronous)는 정확히 무엇을 의미하는걸까? ⇒ [**링크**](https://evan-moon.github.io/2019/09/19/sync-async-blocking-non-blocking/)

# ✏공부 내용 정리

---

- IO는 user-space aplication 에서 직접 수행 될 수 없다
- IO를 수행하기 위해서는 결국 커널에 한번 이상 시스템 콜을 보내야 한다.
- 시스템 콜을 보내게되면 그 순간에 커널(kernel)로 제어권이 넘어가고(context-switch), 응용 프로그램은 제어권이 다시 돌아 오기 까지 block이 된다.
  ⇒ 쉽게 말하자면 block 이 되어 있는 동안 응용 프로그램은 다른 작업을 하지 못하게 된다.

![sync-blocking.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/36694baf-dff5-4184-8b17-57f12696fe1a/sync-blocking.png)

## sync Blocking I/O

- 시스템 콜이 들어오면, 커널은 IO 작업이 완료되기전에는 응답을 하지 않는다.
- IO 작업이 완료되기전에는 제어권을 커널이 갖고 있는다.
- 시스템 콜을 보낸 후에, 어플리케이션은 응답을 받기 전에는 block이 되어, 커널의 I/O 작업이 끝나 Response를 받기 전까지 기다린다.

![sync-non-blocking.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a4cdb802-63d4-49ed-b194-6e2093460903/sync-non-blocking.png)

## sync Non-Blocking I/O

- 시스템 콜이 들어오면, 커널은 작업의 완료 여부와는 무관하게 제어권을 어플리케이션에게 넘겨준다.
- 어플리케이션은 I/O 작업이 끝나지 않았어도 다른 작업을 진행한다.
- 어플리케이션은 다른 작업들을 수행하다가 수시로 시스템 콜을 보내서 IO가 완료되었는지 커널에게 물어보게 된다.

## 정리

Blocking I/O와 Non-Blocking I/O의 차이는 결국 제어권에 있다.

어플리케이션이 시스템 콜을 보내 제어권이 I/O에 넘어갔을 때

- I/O 작업이 끝날 때 까지 제어권이 커널에게 있다 ⇒ Blociking I/O
- I/O 작업이 끝나지 않아도 제어권이 어플리케이션에게 넘어간다.
  ⇒ I/O 작업이 끝나지 않아도 어플리케이션은 다른 작업을 하게 된다.

중요한건 **Blocking과 Non-Blocking의 개념과 차이를 이해하는 것**이라고 생각했다.

## 모르는 단어

### 커널

- 컴퓨터 과학에서 커널은 컴퓨터 운영 체제의 핵심이 되는 컴퓨터 프로그램이다.
- 시스템의 모든 것을 와전히 통제한다.
- 운영 체제의 다른 부분 및 응용 프로그램 수행에 필요한 여러 가지 서비스를 제공한다.

### ❓커널과 I/O의 관계는?

- 커널은 입출력과 관련된 많은 서비스를 제공한다.
- 입/출력 스케쥴링, 버퍼링, 캐싱, 스풀링, 장치 예약 및 에러 처리 등의 서비스를 제공한다.
  ⇒ 하드웨어 및 장치 드라이버 인프라에 구축된 커널의 I/O 하위 시스템에서 제공한다.

### 시스템 콜

- 간단히 시스콜은 운영 체제의 커널이 제공하는 서비스에 대해, 응용 프로그램의 요청에 따라 커널에 접근하기 위한 인터페이스이다.
- 운영체제에게 있어서는 매우 중요한 요소이다.
- 사용자 모드에 있는 프로그램이 시스템 함수를 직접 호출 할 수 없으므로 따로 프로그램이 커널 호출을 요청하는 시스템을 만들어서, 커널이 처리해야 할 일을 프로그램으로부터 받아서 처리하는 것이다.

### 컨텍스트 스위치(context-switch)

- 번역 하면 문맥 교환이다.
- 하나의 프로세스가 cPU를 사용 중인 상태에서 다른 프로세스가 CPU를 사용하도록 하기 위해,
  이전의 프로세스의 상태를 보관하고 새로운 프로세스의 상태를 적재하는 작업을 말한다.
- 한 프로세스의 상태를 적재하는 작업을 말한다.
- 한 프로세스의 문맥은 그 프로세스의 프로세스 제어 블록에 기록되어 있다.

# 공부하면서 느낀 점

---

- 공부 할 때 이해가 안되는 부분은 꼭 다른 곳에 적어놓고 다시 봐보자.
  ⇒ 모르는 내용을 계속 잡고 있는게 아니라 모아놓고 나중에 한번에 처리