# 🔗 참고자료

---

- Java 의 Call by Value, Call by Reference ⇒ [**링크**](https://bcp0109.tistory.com/360)
- hashCode는 정말 메모리주소와 관련이 있을까? ⇒ ****[링크](https://velog.io/@cieroyou/hashCode%EB%8A%94-%EC%A0%95%EB%A7%90-%EB%A9%94%EB%AA%A8%EB%A6%AC%EC%A3%BC%EC%86%8C%EC%99%80-%EA%B4%80%EB%A0%A8%EC%9D%B4-%EC%9E%88%EC%9D%84%EA%B9%8C)**
- C/C++ pointer vs C++ reference vs Java reference ⇒ [**링크**](https://levelup.gitconnected.com/c-c-pointer-vs-c-reference-vs-java-reference-facc037eb2a5)

# ✏공부 내용 정리

---

## Call by Reference와 Call by Value의 차이

이름 그대로 Call by Reference는 참조(주소)를 전달하고, Call by Value는 값을 전달한다.

- Call by Reference는 참조를 직접 넘기기 때문에 호출자의 변수와 수신자의 파라미터는 동일한 주소의 변수이다.
- Call by Value는 값만 직접 넘기기 때문에 호출자의 변수와 수신자의 파라미터는 주소는 다르고 값만 같은 변수이다.

## ❓자바에서 진짜 Call by Reference는 주소 값을 전달할까?

결론부터 보면 아니다.

자바에서는 포인터라는 개념을 사용하지 않고 참조라는 개념을 사용한다.

```java
Object obj = new Object();
int address = System.identityHashCode(obj);
System.out.println("Memory address of object: " + address);
```

위와 같은 방법으로 객체의 메모리 참조 값을 알 수는 있지만,

주소 값을 알 수는 없다.

C++에도 참조가 있다.

> Reference(참조)는  C++ 프로그래밍 언어에서 C에서 상속된 포인터 유형보다 덜 강력하지만
안전한 단순 참조 데이터 유형입니다.
>

그렇다면 차이가 무엇일까?

## 자바의 참조와 C++ 참조의 차이

자바의 참조는 객체만 가능하다.

하지만 C++은 제약이 없이 포인터가 가능하다.

---

더 자세한 내용은 ‘자바에 포인터가 없는 이유’ 에서 다룰 에정이다. ⇒ [링크](https://www.notion.so/25080b9abe52439c9e45d1e4e469cc7c)
