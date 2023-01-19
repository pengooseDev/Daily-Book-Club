# 🔗 참고자료

- Naver D2 - Java Reference와 GC ⇒ [**링크**](https://d2.naver.com/helloworld/329631)
- 도대체 GC는 언제 발생할까? ⇒ [**링크**](https://colinch4.github.io/2020-07-30/t-17/)
- Stack과 Heap.. 그리고 Garbage Collection ⇒ [**링크**](https://thisisprogrammingworld.tistory.com/178)
- 가비지 컬렉션 동작 원리 & GC 종류 총정리 ⇒ [**링크**](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%EC%85%98GC-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC)
- Garbage Collection(가비지 컬렉션)의 개념 및 동작 원리 ⇒ [**링크**](https://mangkyu.tistory.com/118)
- Nave D2 - Java Garbage Collection ⇒ [**링크**](https://d2.naver.com/helloworld/1329)

# 내용

### GC가 돌면 벌어지는 일(GC의 동작 과정)

### ❓ 왜 GC를 공부해야 할까?

C언어에서는 직접 메모리를 할당하고 해제합니다. 자바는 GC가 대신 그 역할을 합니다.

이런 이유에서 메모리에 대한 것들을 GC에 의존하는 경우가 많습니다.

**하지만** 메모리가 언제 해제되는지 정확하게 할 수 없어 제어하기 힘듭니다.

그래서 GC의 특성과 한계를 알아야 메모리 문제로부터 보다 자유로운 소프트웨어를 만들 수 있습니다.

### ❓ Garbage Collection란?

- JVM의 Heap 영역에서 동적으로 할당했던 메모리 중 필요 없게 된 메모리 객체(Garbage)를 모아 주기적으로 제거하는 프로세스를 말한다.

### ❓ 객체를 저장하는 힙(Heap)의 구조는?

![java13_1.jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9c4d2178-8c9e-47ae-8a56-025a79fc3392/java13_1.jpg)

객체의 생존 기간에 따라 물리적인 Heap 영역을 나눠져 있다.

Young, Old, Perm 영역 총 3가지 영역이 있었지만, Perm 영역은 Java8부터 제거되었다.

![Young 영역.JPG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/87449c2d-e9b2-4fe4-8def-96cd16a128f1/Young_%EC%98%81%EC%97%AD.jpg)

### Young 영역(Young Generation)

- 새롭게 생성된 객체가 할당(Allocation)되는 영역
- Young 영역에 대한 가비지 컬렉션(Garbage Collection)을 Minor GC라고 부른다.
- Young 영역은 Eden, Survivor 2개의 영역으로 나뉘어진다.
    - **Eden 영역**
        - 객체를 new 연산자로 생성해 메모리가 할당되면 Eden 영역에 생성된다.
        - Eden 영역이 객체들로 차면, Minor GC가 작동하고 남은 모든 survivor 객체들은 survivor 영역으로 옮겨진다.
    - **Survivor 영역**
        - Eden 영역에서 java GC가 작동하고 남은 객체들이 저장되는 pool이다.
        - Survivor(From)이 가득 차면 Survivor(To)로 보내고 Survivor(From)은 비웁니다.
        - 마지막까지 살아남은 객체는 Old 영역으로 갑니다.

### Old 영역(Old Generation)

- Young 영역보다 크게 할당되며, 영역의 크기가 큰 만큼 가비지는 적게 발생한다.
- Old 영역에 대한 가비지 컬렉션(Garbage Collection)을 Major GC 또는 Full GC라고 부른다.
- Old 영역은 객체들이 가득 차면 Major GC가 실행됩니다.
    - GC의 알고리즘에 따라서 Major GC(Full GC)의 절차가 달라진다.
      ⇒ Serial GC, Parallel GC, Concurrent Mark & Sweep GC (CMS), G1(Garbage First) GC

### ❓ Minor GC와 Major GC란?

### Minor GC

- Young 영역에 GC가 발생할 경우 이를 Minor GC라고 한다.

### Major GC(Full GC)

- Old 영역에서 발생하는 GC를 Full GC라고 한다.

### ❓ Major GC(Full GC)의 알고리즘의 종류와 차이는?

- Serial GC : 적은 메모리와 CPU 코어 개수가 적을 때 적합한 방식
- Parallel GC : Serial GC와 동일한 알고리즘이지만 멀티 스레드로 좀 더 빠릅니다.
- Concurrent Mark & Sweep GC (CMS) : 메모리가 크고 2개 이상의 프로세서를 사용할 때 적합합니다.
- G1(Garbage First) GC : 메모리가 크고 멀티 코어 프로세서를 사용할 때 적합합니다.

### ❓ Reachable, Unreachable 객체란?

### ❓ 가비지 컬렉션과 가비지 컬렉터의 차이는?

- 가비지 컬렉션은  Minor GC, Full GC 같이 메모리를 비워주는 동작(프로세스)을 말합니다.
- 가비지 컬렉터는 가비지 컬렉션을 동작하는 알고리즘 입니다.
  자바를 실행하기 전에 옵션을 지정해 줄 수 있습니다.

## 공부하면서 느낀 점