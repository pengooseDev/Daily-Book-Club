# 🔗 참고자료

---

- javatpoint - Volatile Keyword in Java ⇒ [**링크**](https://www.javatpoint.com/volatile-keyword-in-java)
- Java volatile이란? ⇒ [**링크**](https://nesoy.github.io/articles/2018-06/Java-volatile)
- 책 <자바의신> 1009페이지 - volatile
- 기계인간 종립님 블로그 - Java volatile ⇒ [**링크**](https://johngrib.github.io/wiki/java/volatile/)
- Baeldung - Volatile Variables and Thread Safety ⇒ [**링크**](https://www.baeldung.com/java-volatile-variables-thread-safety)

# ✏공부 내용 정리

---

## ❓Java에서 volatile이란?

- Java 변수를 Main Memory에 저장하겠다고 명시하는 것이다.
    - 변수 선언 시 사용한다.
- **매번 변수의 값을 Read 할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 읽는 것**
- 또한 변수의 값을 Write 할 때마다 Main Memory에 까지 작성하는 것

<자바의 신> 책을 안보고 바로 구글에 검색해서 블로그에서 개념을 봤다.

역시 이해가 안된다.

블로그에 나오는 키워드는 Main Memory, CPU cache 이다.

우선 왜 이렇게 블로그에 정리 되었는지 알기 위해 <자바의 신> 책 내용을 봐보자.

## 예제 코드

```java
package test;

public class VolatileThread extends  Thread{
    private double instanceVariable = 0;

    void setDouble(double value) {
        this.instanceVariable = value;
    }

    public void run() {
        while (instanceVariable == 0);
        System.out.println(instanceVariable);
    }
}

class RunVolatile {
    public static void main(String[] args) {
        RunVolatile runVolatile = new RunVolatile();
        runVolatile.runVolatileSample();
    }

    public void runVolatileSample() {
        VolatileThread volatileThread = new VolatileThread();
        volatileThread.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Sleep ended !!!");
        volatileThread.setDouble(-1);
        System.out.println("Set value is completed !!!");
    }
}
```

- VolatileThread 클래스와 VolatileThread를 실행 시킬 RunVolatile 클래스를 만든 예제 코드이다.
- VolatileThread 클래스
    - instanceVariable 이라는 double 자료형 변수가 있고, 초기 값은 0이다.
    - setDouble 메소드를 통해 instanceVariable 변수의 값을 할당 할 수 있다.
    - 오버라이딩 run() 메소드에 instanceVariable이 0이면 while문이 반복하는 코드를 작성한다.
      ⇒ run 메소드의 마지막 라인에 instanceVariable을 출력하는 코드를 작성한다.
- RunVolatile 클래스
    - volatileThread를 start() 메소드를 통해 실행 시킨다.
    - 실행 시킨 스레드를 1000ms sleep을 하게 만든다.
    - sleep 이 끝나면 setDouble 메소드에 인자를 -1로 해서 호출한다.

![볼라타일1.JPG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0ae2f9b2-f2ea-412c-8bd8-1ece4e3f6a53/%EB%B3%BC%EB%9D%BC%ED%83%80%EC%9D%BC1.jpg)

위의 코드대로면 -1이 instanceVariable에 할당 되어서 종료 되어야 하는게 맞다.

하지만 종료가 되지 않는다.

왜 그럴까?

## ❓종료가 안되는 이유는 뭘까?

문제의 원인은 “CPU 캐시(CPU cache) 때문이라고 한다.

- “메인 메모리(Main Memory)” 에 저장되지 않고 “CPU 캐시”에 저장되고 참조된다.
- run() 메소드의 while 문에서는 “CPU 캐시”에 저장되어 있는 instanceVariable만 보기 때문이다.
  ⇒ 결국에는 CPU cache 의 값은 “0” 이기 때문에 while문은 종료 되지 않는다.

Main Memory와 CPU cache가 정확히 뭔지는 모르겠지만,
결국 CPU 캐시에 있는 값이 바뀌어야 한다.

그렇다면 어떻게 하면 될까?

## 해결방법

```java
private volatile double instanceVariable = 0;
```

- 인스턴스 변수에 volatile 키워드를 달아주면 된다.

해결 방법은 정말 간단했다.

![volatile.JPG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4188aff2-e999-4a1e-bdcb-15db6f2b0df9/volatile.jpg)

키워드 하나 달았다고 어떻게 이렇게 쉽게 해결 될까?

**위와 같은 문제를 예방하기 위해 volatile 키워드를 남발하면 성능 저하 발생이 된다.**

> 위와 같은 문제가 발생한 이유는 JIT 컴파일러가 최적화 작업을 수행하기 때문이다.
>

그래서 instanceVariable을 캐시에 두고 최적화가 되어서 이러한 일이 발생한 거다.

## 정리해보기

volatile로 선언된 필드는, 자바 메모리 모델은 모든 스레드가 변수에 대해 일관된 값을 볼 수 있도록 한다. CPU cache가 아니라 Main memory를 바라보게 만들기 때문이다.

결국에 volatile 키워드의 변수는 cache하지 않는다.

## Synchronized와 volatile의 차이점

| Volatile | Synchronization |
| --- | --- |
| volatile 키워드를 
필드에만 달 수 있다. | synchronized 키워드는 코드 블록과
메서드에 달 수 있다. |
| volatile이 된 케이스는 스레드를
block 하거나 기다리지 않게 한다. | synchronized가 된 케이스는 스레드를 block 한다. |
| 스레드 성능을 저하시키지 않는다. | 동기화된 메서드는 스레드 성능을 저하시킨다. |
|  volatile 필드는 컴파일러의 최적화를 하지 않는다. | synchronized는 컴파일 최적화를 진행한다. |

## 모르는 키워드

![1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c4bdaec0-8cb8-4294-bf73-cc5d77f09b03/1.png)

### CPU cache

- CPU 구조에 메모리로 사용하도록 구성된 하드웨어 캐시다.
- 메인 메모리에서 가장 자주 사용되는 위치의 데이터를 갖고 있는, 크기는 작지만 빠른 메모리

### Main Memory

- 컴퓨터 시스템의 기본 저장 장치이다.
- 주기억장치는 컴퓨터에서 수치.명령.자료 등을 기억하는 컴퓨터 하드웨어 장치를 가리킨다.
- 1차 기억 장치와 동의어이다.

# 공부하면서 느낀 점

---

블로그의 내용을 계속 읽어도 이해가 안되는 경우가 많다.

우선적으로 내용이 딱딱한 블로그는 더욱 안 읽힌다.

공부해야 할 개념이 나오면 책을 우선적으로 보자

그 이유는

- 책은 우선적으로 검증이 된 내용이다.
- 구글 검색은 시간 대비 효율이 적다.
  ⇒ 스택 오버플로우, 유명 외국 사이트는 괜찮다.
- 결론적으로 시간 대비 가장 좋은 효율을 뽑아내야 한다.
  그렇다고 대충 보는 게 아니다.

**예시 코드는 무조건 직접 작성해보고 조금이라도 변형해서 실행해보자.**