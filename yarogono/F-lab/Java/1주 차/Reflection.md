# 🔗 참고자료

- 이펙티브 자바 아이템 65
- 블로그 <느리더라도 꾸준하게> Reflection 개념 및 사용 방법 ⇒ [**링크**](https://steady-coding.tistory.com/609)
- Tecoble ⇒ [**링크**](https://tecoble.techcourse.co.kr/post/2020-07-16-reflection-api/)
- 블로그 <느리더라도 꾸준하게> JVM의 클래스 로더란? ⇒ [**링크**](https://steady-coding.tistory.com/593)
- 블로그 <YD> Java Reflection의 이해 ⇒ [**링크**](https://ydydydyc.github.io/java/what-is-reflection/)
- Oracle <Java Docs> The Reflection API ⇒ [**링크**](https://docs.oracle.com/javase/tutorial/reflect/index.html)
- 자바 리플렉션에 대한 오해와 진실 ⇒ [**링크**](https://kmongcom.wordpress.com/2014/03/15/%EC%9E%90%EB%B0%94-%EB%A6%AC%ED%94%8C%EB%A0%89%EC%85%98%EC%97%90-%EB%8C%80%ED%95%9C-%EC%98%A4%ED%95%B4%EC%99%80-%EC%A7%84%EC%8B%A4/)

# ****✍**** 공부하게 된 계기

이펙티브 자바를 읽으면서 Reflection에 대한 단어를 봤습니다.

하지만 알고있는 개념이 하나도 없어서 공부를 해야겠다고 생각했습니다.

때 마침 멘토님이 주제를 선정해주시고 공부를 하게 되었네요.

# 내용

### ❓ 리플렉션(Reflection)이란?

- **구체적인 클래스 타입을 알지 못해도** 그 클래스의 정보(메서드, 타입, 변수 등등)에 접근할 수 있게 해주는 자바 API
- 힙 영역에 로드된 Class 타입의 객체를 통해, 원하는 클래스의 인스턴스를 생성할 수 있도록 지원하고, 인스턴스의 필드와 메소드를 접근 제어자와 상관 없이 사용할 수 있도록 지원하는 API이다.

❓ **로드된 클래스란?**

- JVM의 클래스 로더에서 클래스 파일에 대한 로딩을 완료한 후, 해당 클래스의 정보를 담은 Class 타입의 객체를 생성하여 메모리의 힙 영역에 저장해 둔 것을 의미한다.
- new 키워드를 통해 만드는 객체와는 다르다.
- Class 타입의 객체 ⇒ java.lang.class 객체의 JDK 문서를 참고 ⇒ [**링크**](https://docs.oracle.com/javase/10/docs/api/index.html?overview-summary.html)

**❓ 클래스 로더란?**

- 자바는 동적 로드, 즉 컴파일 타임이 아니라 런타임(바이트 코드를 실행할 때)에 클래스 로드하고 링크하는 특징이 있다. 이 동적 로드를 담당하는 부분이 JVM의 클래스 로더이다. 정리하자면, 클래스 로더는 런타임 중에 JVM의 메소드 영역에 동적으로 Java 클래스를 로드하는 역할을 한다. 클래스 로더에는 로딩, 링크, 초기화 단계로 나뉘어져 있다.

**❓ 어떻게 제약을 무시하고 클래스의 정보를 가져올 수 있을까?**

- 자바에서는 JVM이 실행되면 사용자가 작성한 자바 코드가 컴파일러를 거쳐 바이트 코드로 변횐되어 static 영역에 저장된다. Reflection API는 이 정보를 활용한다. 그래서 클래스 이름만 알고 있다면 언제든 static 영역을 뒤져서 정보를 가져올 수 있는 것이다.

### ❓ 왜 사용하는 걸까?

- 런타임 중 클래스 정보에 접근하여 클래스를 원하는 대로 조작할 수 있다.
- private 접근 제어자로 선언한 필드나 메소드까지 조작이 가능하다.
  - 객체 지향 설계에서 중요한 캡슐화가 깨지게 된다.
- Spring의 Bean Factory를 보면 @Controller, @Service, @Repository 등의 어노테이션만 붙이면 Bean Factory에서
  알아서 해당 어노테이션이 붙은 클래스를 생성하고 관리해 주는 것을 알 수 있다. 개발자는 Bean Factory에 해당 클래스를 알려준 적이 없는데, 이것이 가능한 이유는 리플렉션 덕분이다.
  - 런타임에 해당 어노테이션이 붙은 클래스를 탐색하고 발견한다면, 리플렉션을 통해 해당 클래스의 인스턴스를 생성하고 필요한 필드를 주입하여 Bean Factory에 저장하는 식으로 사용이 된다.

### ❓ 리플렉션 사용시 주의할 점은?

- 지나친 사용은 성능 이슈를 야기할 수 있다. 반드시 필요한 경우에만 사용할 것
- 컴파일 타임에 확인 되지 않고 런타임 시에만 발생하는 문제를 만들 가능성이 있다.
- 접근 지시자를 무시할 수 있다.

### ❓ 리플렉션의 장단점은?

**장점**

- 런타임 시점에서 클래스의 인스턴스를 생성하고, 접근 제어자와 관계 없이 필드와 메소드에 접근하여 필요한 작업을 수행할 수 있는 유연성을 가지고 있다.

**단점**

- 컴파일타임 검사가 주는 이점을 하나도 누릴 수 없다.
- 리플렉션을 이용하면 코드가 지저분하고 장황해진다.
- 단순히 필드 및 메소드를 접근할 때보다 리플렉션을 사용하여 접근할 때 성능이 느리다.  
  (모든 상황에서 성능이 느리지는 않다.)

## 공부하면서 느낀 점

공부를 하기 전에는 편협한 생각을 가지고 있었습니다.  
Reflection은 객체 지향 원칙인 캡슐화도 지키기 힘들게 만들어서 사용하거나 공부 할 필요가 없다고 생각했습니다.  
그런데 이것은 정말 단순한 생각이었습니다.  
Reflection을 공부하면서 JVM의 클래스 로더(Class Loader)의 기능을 알게 되고,  
스프링에서도 리플렉션을 사용한다는 것을 알게 되었습니다.