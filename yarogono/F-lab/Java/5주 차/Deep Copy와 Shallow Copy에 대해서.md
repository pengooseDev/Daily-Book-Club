# 🔗 참고자료

---

- Java프로젝트하면서 String의 특성으로 인한 깊은 복사 설명하기 ⇒ ****[링크](https://injae7034.github.io/java/ninth/)****
- [Java] Shallow copy(얕은 복사) vs Deep copy(깊은 복사) ⇒ [**링크**](https://jackjeong.tistory.com/100)
- Java 깊은 복사(Deep Copy)와 얕은 복사(Shallow Copy) ⇒ ****[링크](https://zzang9ha.tistory.com/372)****
- 기계인간 John Grib - java.lang.Object.clone 메소드 ⇒ **[링크](https://johngrib.github.io/wiki/java/object-clone/)**
- 이펙티브 자바 아이템13 - clone 재정의는 주의해서 진행하라(77p)

# ✏공부 내용 정리

---

## ❓Deep Copy란?

새로운 객체 참조를 가진 객체를 생성하고, 그 객체에 복사할 객체의 값을 복사해 넣는 것.

- 기존의 객체와 참조 값이 달라 아예 새로운 객체여서, 서로 영향을 받지 않는다.

### 생성자에 직접 값을 넣기

```java
public class DeepCopyAndShallowCopy {
    public static void main(String[] args) {
        DeepCopyUser deepCopyUser = new DeepCopyUser("딥카피", 50);
        DeepCopyUser copiedDeepCopyUser = new DeepCopyUser(deepCopyUser.getName(), 
																														deepCopyUser.getAge());
        System.out.println(copiedDeepCopyUser.getAge() + " " + copiedDeepCopyUser.getName());
        System.out.println(deepCopyUser.hashCode() + "\n" + copiedDeepCopyUser.hashCode());
    }
}

class DeepCopyUser {
    private String name;
    private int age;

    public DeepCopyUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e4dc4dba-9b39-476d-9882-5bea5d2a30a8/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230213%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230213T233557Z&X-Amz-Expires=86400&X-Amz-Signature=74f6e4ca7b3a88f1008e53db002e85c13e07f7d2b5f7ed6571132a773320ebfb&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- 위와 같이 deepCopyUser 객체의 값을 copiedDeepCopyUser의 생성자에 넣었습니다.
- new 연산자를 통해 새롭게 생성되는 객체이기 때문에 기존의 객체(deepCopyUser)와는 hashCode가 다릅니다.

## ❓Shallow Copy란?

새로운 객체를 만들 때, 복사할 객체의 참조 값을 똑같이 넣어서 만드는 것.

- 참조 값을 복사했기 때문에 어느 하나의 객체가 수정되면 복사한 객체에도 영향을 준다.

### 직접 코드를 작성해보자

```java
package org.example.week5;

public class DeepCopyAndShallowCopy {
    public static void main(String[] args) {
        ShallowCopyUser shallowCopyUser = new ShallowCopyUser("쉘카피", 34);
        ShallowCopyUser copiedShallowCopyUser = shallowCopyUser;
        System.out.println(copiedShallowCopyUser.getAge() + " " + copiedShallowCopyUser.getName());
        System.out.println(shallowCopyUser.hashCode() + "\n" + copiedShallowCopyUser.hashCode());
    }
}

class ShallowCopyUser {
    private String name;
    private int age;

    public ShallowCopyUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c8c968ae-ba41-4ede-a3d8-0972a2d22e5e/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230213%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230213T233610Z&X-Amz-Expires=86400&X-Amz-Signature=fdd08e248cb9b64d0da6cc80a4c93992b7d9aedef21a2d86e6c58b54b9721a1c&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- new 연산자를 사용하지 않고, 기존의 객체(shallowCopyUser)의 참조 값을 새로운 객체(copiedShallowCopyUser)에 할당해줬습니다.
- 둘 다 동일한 주소를 포인팅 하고 있기 때문에 값이 같습니다.
- 어느 하나가 수정이 되면 같은 참조를 가진 나머지 객체에도 영향을 줍니다.

## 궁금한 점

- Cloneable 인터페이스는 왜 아무것도 없는 빈 인터페이스일까?

  ![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/be0d5ca5-3d7c-42f6-aee9-200ba7ecd9b1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230213%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230213T233624Z&X-Amz-Expires=86400&X-Amz-Signature=9f0bc6487d433bf9aba7ad36a36c06768a6482ec95499048369e835a0888a1f3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

    - Cloneable는 마커 인터페이스라고 한다.
        - 자체 추상 메서드와 같은 동작이 하나도 존재하지 않는다.