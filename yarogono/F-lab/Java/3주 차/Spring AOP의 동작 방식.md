# 🔗 참고자료

---

- Spring Transaction 관리에 대한 메모 ⇒ [**링크**](https://sigridjin.medium.com/spring-transaction-%EA%B4%80%EB%A6%AC%EC%97%90-%EB%8C%80%ED%95%9C-%EB%A9%94%EB%AA%A8-f391fd2885b4)
- [10분 테코톡] 제이의 Spring AOP ⇒ [**링크**](https://www.youtube.com/watch?v=Hm0w_9ngDpM&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC)
- [10분 테코톡] 봄의 AOP와 SPRING AOP ⇒ [링크](https://www.youtube.com/watch?v=hjDSKhyYK14&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC)
- Baeldung - Comparing Spring AOP and AspectJ ⇒ [**링크**](https://www.baeldung.com/spring-aop-vs-aspectj)
- [r](http://refectoring.guru)efectoring guru - 프록시 패턴 ⇒ [링크](https://refactoring.guru/ko/design-patterns/proxy)

# ✏공부 내용 정리

---

## ❓AOP란?

- Aspect Oriented Programming의 약자로 관점 지향 프로그래밍이다.
- 횡단 관심사(Cross-Cutting Concern)의 분리를 허용함으로써 모듈성을 증가시키는 것이 목적인 프로그래밍 패러다임이다.
- 여러 객체에 공통으로 적용할 수 있는 기능을 분리해서 개발자는 반복 작업을 줄이고 핵심 기능 개발에만 집중할 수 있다.

## ❓프록시란?

- 자신이 클라이언트가 사용하려고 하는 실제 대상인 것처럼 위장해서 클라이언트의 요청을 받아주느 것(대리인, 대리자)
- 클라이언트가 타깃(RealSubject)에 접근하는 방법을 제어하기 위해 ⇒ 프록시 패턴
- 타깃에 부가적인 기능을 부여해준다.  ⇒ 데코레이터 패턴

![live-example.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a9fe8194-4f73-4b7b-9555-1eaf32b40480/live-example.png)

- 예를 들면 위 사진처럼 신용 카드(Credit Card)는 은행 계좌의 프록시이다.
- Payment 인터페이스를 구현하며 결제에 사용 될 수 있다.

## ❓Spring AOP란?

![xafk877crjt6kflq9yt1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/577843fe-d11d-41d2-bc45-1de3ee44c6a9/xafk877crjt6kflq9yt1.png)

어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 그 관점을 기준으로 각각 모듈화 하겠다는 것이다.

여기서 모듈화란 어떤 공통된 로직이나 기능을 하나의 단위로 묶는 것을 말한다.

사용자는 공통된 기능이 담긴 기능을 가져다 사용하기만 하면 된다.

그러므로 핵심 기능에 집중하고 공통 기능의 로직이 핵심 기능 사이에 올 필요가 없어진다.

## ❓AOP의 단점은?

- 공통된 기능이 담긴 로직이 추상화되어 있어 중요도가 낮아 지게 된다.
    - 추상화가 되어 있기 때문에 핵심 로직에 비해서 등한 시 하게 된다.
      예를 들면 log4j로 인한 보안 이슈 사고([**링크**](https://m.boannews.com/html/detail.html?idx=103426))를 들 수 있다.

## AOP 용어 정리

- Target Object : 부가 기능을 부여할 대상
- Aspect : AOP의 기본 모듈. 그 자체로 애플리케이션의 핵심 기능을 담고있진 않지만,
  애플리케이션을 구성하는 중요한 한 가지 요소. 부가될 기능을 정의한 Advice와 어드바이스를 어디에 적용할지 결정하는 Pointcut을 함께 가짐
- Advice : 타겟에게 제공할 부가 기능을 담은 모듈. 타깃이 필요없는 순수한 부가 기능.
  애스팩트가 무엇을 언제 할지를 정의하고 있음
- Join Point : 프로그램의 실행 내부에서 Advice가 적용될 수 있는 위치
- Pointcut : Advice에 적용할  JoinPoint를 식별하는 작업 또는 그 기능을 정의한 모듈

## AOP를 구현하는 방법

- 컴파일 시점에 코드에 공통 기능 삽입
- 클래스 로딩 시점에 바이트 코드에 공통 기능 삽입
- 런타임 시점에 프록시 객체를 생성하여 공통 기능 삽입(스프링에서 사용하는 방법)
    - 컴파일러나 클래스 로더 조작기를 설정하지 않아도 된다.
    - 프록시는 메서드 오버라이딩 개념으로 동작하기 때문에. 스프링 AOP는 메서드 실행 시점에만 AOP를 적용 할 수 있다.
    - 스프링 AOP는 스프링 컨테이너가 관리할 수 있는 빈(Bean)에만 AOP를 적용 할 수 있다.
    - AspectJ를 직접 사용하는 것이 아니라, AspectJ의 문법을 차용하고 프록시 방식의 AOP 적용

# 공부하면서 느낀 점

---

Spring AOP가 단순히 Spring에만 극한 된 것 인줄 알았다.

찾아보니 Proxy는 하나의 패턴이였다.

추상화 되어있는 기능을 하나씩 뜯어보면 다양한 패턴이 사용되고,

해당 패턴을 통해 많은 것들을 공부할 수 있다.

쉽게 사용하고 편하다고 그냥 넘어가지 말고 어떻게 구현되어 있는지 고민하고 들여다 보자.