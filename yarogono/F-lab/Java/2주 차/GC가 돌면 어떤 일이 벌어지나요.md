# 🔗 참고자료

---

- Naver D2 - Java Reference와 GC ⇒ [**링크**](https://d2.naver.com/helloworld/329631)
- Nave D2 - Java Garbage Collection ⇒ [**링크**](https://d2.naver.com/helloworld/1329)
- 오라클 공식문서 ⇒ [**링크**](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html)
- 오라클에서 제공하는 PDF ⇒ [**링크**](https://www.oracle.com/technetwork/java/javase/memorymanagement-whitepaper-150215.pdf)
- Garbage Collection(가비지 컬렉션)의 개념 및 동작 원리 ⇒ [**링크**](https://mangkyu.tistory.com/118)
- 가비지 컬렉션 동작 원리 & GC 종류 총정리 ⇒ [**링크**](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%EC%85%98GC-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC)
- [JVM] Garbage Collection Algorithms ⇒ [**링크**](https://medium.com/@joongwon/jvm-garbage-collection-algorithms-3869b7b0aa6f)
- 가비지 컬렉션 GC(Garbage Collection)의 동작원리와 동작하는 시점 **⇒ [링크](https://itkjspo56.tistory.com/285)**

# ✏공부 내용 정리

---

## 1. GC가 돌면 벌어지는 일(한 줄 정리)

- JVM의 Heap 메모리를 점검하여 스택에서 참조되지 않는 객체를 메모리에서 해제한다.

## 2. 왜 GC를 공부해야 할까?

GC에 의존적이면, 메모리가 언제 해제되는지 알 수가 없게 됩니다.

GC의 특성과 한계를 모르면 메모리 문제로부터 보다 자유로운 소프트웨어를 만들기 어렵습니다.

- [TMI]회사를 다닐 때 GC의 특성을 모르고 코딩을 하다가 문제가 발생한 썰

  StringBuilder 객체에 엄청나게 긴 문자열을 append한 걸 파일로 만드는 업무였습니다.

  위 방법은 결국 OOM(Out Of Memory)이 발생하고 해결하는데 상당한 시간이 걸렸었습니다.


GC를 공부해야 하는 것은 이제 알았으니

그렇다면 GC란 무엇일까?

## 3. Garbage Collection란?

JVM의 Heap 영역에서 동적으로 할당했던 메모리 중 필요 없게 된 메모리 객체(Garbage)를 모아

주기적으로 제거하는 프로세스를 말한다.

GC는 Heap 영역에서 주로 동작을 하는 것 같아.

GC가 주로 동작하는 무대인 Heap에 대해 더 알아봐야 할 것 같다.

그러면 Heap의 구조는 어떻게 되어있을까?

## 4. 객체를 저장하는 힙(Heap)의 구조는?

![images_recordsbeat_post_682408fc-f29e-42e9-b980-3d6f1d6c4989_image.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/880b00ca-73df-4372-9851-c406a9c6919e/images_recordsbeat_post_682408fc-f29e-42e9-b980-3d6f1d6c4989_image.png)

객체의 생존 기간에 따라 물리적인 Heap 영역을 나눠져 있다.

Young, Old, Perm 영역 총 3가지 영역이 있었지만, Perm 영역은 Java8부터 제거되었다.

![Young 영역.JPG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/87449c2d-e9b2-4fe4-8def-96cd16a128f1/Young_%EC%98%81%EC%97%AD.jpg)

### Young 영역(Young Generation)

- 새롭게 생성된 객체가 할당(Allocation)되는 영역
- Young 영역에 대한 가비지 컬렉션(Garbage Collection)을 Minor GC라고 부른다.
- 대부분의 객체가 금방 접근 불가 상태(unreachable)가 되기 때문에 많은 객체가 Young 영역에 생성되었다가 사라진다.
- Young 영역은 Eden, Survivor 2개의 영역으로 나뉘어진다.
    - **Eden 영역**
        - 객체를 new 연산자로 생성해 메모리가 할당되면 Eden 영역에 생성된다.
        - Eden 영역이 객체들로 차면, Minor GC가 작동하고 남은 모든 survivor 객체들은 survivor 영역으로 옮겨진다.

    - **Survivor 영역**
        - Eden 영역에서 java GC가 작동하고 남은 객체들이 저장되는 pool이다.
        - Survivor(From)이 가득 차면 Survivor(To)로 보내고 Survivor(From)은 비웁니다.
        - 마지막까지 살아남은 객체는 Old 영역으로 갑니다.

### Old 영역(Old Generation)

- Young 역보다 크게 할당되며, 영역의 크기가 큰 만큼 Young 영역보다 GC는 적게 발생한다.
- Old 영역에 대한 가비지 컬렉션(Garbage Collection)을 Major GC 또는 Full GC라고 부른다.
- Old 영역은 객체들이 가득 차면 Major GC가 실행됩니다.
    - GC의 알고리즘에 따라서 Major GC(Full GC)의 절차가 달라진다.
      ⇒ Serial GC, Parallel GC, Concurrent Mark & Sweep GC (CMS), G1(Garbage First) GC

## 5. 궁금한 내용 정리

### ❓Minor GC와 Major GC란?

- **Minor GC**
    - Young 영역에서 객체가 사라질 때 Minor GC가 발생한다고 말한다.
- **Major GC(Full GC)**
    - Old 영역에서 객체가 사라질 때 Major GC(Full GC)가 발생한다고 말한다.


### ❓Major GC(Full GC)의 알고리즘의 종류는?

- Serial GC

  Mark-Sweep-Conpact 알고리즘을 사용합니다.

    - Old 영역에서 Reachable한 객체를 식별(Mark)합니다.
    - 살아있는 객체만 남기고 Unreachable한 객체는 제거(Sweep)합니다.
    - 객체들을 앞부터 채워나가서 객체가 존재하는 부분과 존재하지 않는 부분을 나눕니다.
- Parallel GC
    - 기본적인 알고리즘은 Serial GC와 같지만, 여러 스레드를 병렬적(Parallel)으로 이용하여 GC를 진행합니다.
- Concurrent Mark & Sweep GC (CMS)
    - 응답시간이 처리량보다 중요한 경우 적합하다.
    - API서버처럼 약 1초 보다 짧은 pause 시간을 계속해 유지해야 한다면 해당 GC 사용을 권장한다.
- G1(Garbage First) GC
    - 64비트 컴퓨터 최적화된 GC로 4GB  이상의 Heap size에 적합한 GC다.

### ❓Reachable, Unreachable 객체란?

가비지 컬렉션(Garbage Collection)은 특정 객체가 가비지인지 아닌지 판단하기 위해서

도달성, 도달능력(Reachability) 이라는 개념을 적용한다.

객체에 유효한 레퍼런스가 없다면 **Unreachable**로 구분해버리고 수거해버린다.

레퍼런스가 있다면 **Reachable**로 구분된다.

# 공부하면서 느낀 점

---

- 공부를 했지만 아직 모르는게 너무 많고 이해가 안되는 부분이 산더미이다.
- GC 튜닝을 통한 성능 최적화
    - 아직 GC에 대해 모르는게 많고 우선 코드의 성능 최적화에 집중이 필요하다고 느꼈다.
- GC에 대한 개념이 아니라 JVM의 메모리와 연결되는 것들을 찾고 공부해야겠다.
- 공부를 하면서 찾아본 레퍼런스 자료들을 잘 정리해서 보관하자.
    - 지금은 이해가 안되더라도 나중에 꼭 다시 봐야 할 내용이다.
    - 나중에 다시 봤을 때 미흡하거나 잘못된 내용을 수정
- 여러 블로그를 찾아보는 것도 좋지만 시간이 많이 든다.
    - 번역하고 이해하는데 시간이 좀 들더라도 공식 문서를 찾아 보자.
      (공식 문서는 참고 자료 링크에)