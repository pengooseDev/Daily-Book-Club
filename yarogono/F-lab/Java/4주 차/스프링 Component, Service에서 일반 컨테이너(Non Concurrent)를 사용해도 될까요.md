# 🔗 참고자료

---

- Spring Singleton vs Singleton Pattern ⇒ ****[링크](https://www.javadevjournal.com/spring/spring-singleton-vs-singleton-pattern/)****
- Spring Bean Scopes ⇒ [링크](https://www.javadevjournal.com/spring/spring-bean-scopes/)

# ✏공부 내용 정리

---

## ❓스프링 Component란?

- 개발자가 직접 작성한 Class를 Bean으로 만드는 것이다.
- @Component 어노테이션을 사용하면 싱글톤 클래스 빈을 생성하고 스프링 IOC 컨테이너에서 관리한다.
    - 해당 어노테이션이 붙은 클래스는 컴포넌트 스택(Component Scan 대상이 된다.)

우선적으로 @Component, @Service 어노테이션이 달려있지 않는 일반 컨테이너는 Spring IOC 컨테이너에서 관리하지 않게 된다.

이 말은 관리되지 않은 컨테이너는 유저가 API 콜을 보낼 때마다 객체가 생성될 위험이 있다.

그렇다면 Java 싱글톤 방식으로 해당 컨테이너를 처리하면 되지 않을까?

![images_seculoper235_post_deb60c0f-81cf-4766-8f57-557495842381_context 구조.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/58fa4e09-26e9-4e91-9967-13490c87dfe2/images_seculoper235_post_deb60c0f-81cf-4766-8f57-557495842381_context_%EA%B5%AC%EC%A1%B0.png)

## 스프링 싱글톤 vs 자바 싱글톤

결론적으로 스프링의 싱글톤 범위는 자바 싱글톤과 동일하지 않다.

- 자바 싱글톤은 JVM 클래스 로더당 특정 클래스의 인스턴스 하나를 보장한다.
- Spring 싱글톤은 “per Container per Bean” 입니다.
    - 컨텍스트 내에서 사용 할 수 있다.

## 결론

- 같이 사용해도 되지만, 서로의 범위가 다르다.
- Component, Service에서 일반 컨테이너(Non Concurrent)를 사용한다면,
  두 개의 영역을 동시에 사용하는 것이다.
