# ๐ ์ฐธ๊ณ ์๋ฃ

---

- Javaํ๋ก์ ํธํ๋ฉด์ String์ ํน์ฑ์ผ๋ก ์ธํ ๊น์ ๋ณต์ฌ ์ค๋ชํ๊ธฐ โ ****[๋งํฌ](https://injae7034.github.io/java/ninth/)****
- [Java] Shallow copy(์์ ๋ณต์ฌ) vs Deep copy(๊น์ ๋ณต์ฌ) โ [**๋งํฌ**](https://jackjeong.tistory.com/100)
- Java ๊น์ ๋ณต์ฌ(Deep Copy)์ ์์ ๋ณต์ฌ(Shallow Copy) โ ****[๋งํฌ](https://zzang9ha.tistory.com/372)****
- ๊ธฐ๊ณ์ธ๊ฐ John Grib - java.lang.Object.clone ๋ฉ์๋ โ **[๋งํฌ](https://johngrib.github.io/wiki/java/object-clone/)**
- ์ดํํฐ๋ธ ์๋ฐ ์์ดํ13 - clone ์ฌ์ ์๋ ์ฃผ์ํด์ ์งํํ๋ผ(77p)

# โ๊ณต๋ถ ๋ด์ฉ ์ ๋ฆฌ

---

## โDeep Copy๋?

์๋ก์ด ๊ฐ์ฒด ์ฐธ์กฐ๋ฅผ ๊ฐ์ง ๊ฐ์ฒด๋ฅผ ์์ฑํ๊ณ , ๊ทธ ๊ฐ์ฒด์ ๋ณต์ฌํ  ๊ฐ์ฒด์ ๊ฐ์ ๋ณต์ฌํด ๋ฃ๋ ๊ฒ.

- ๊ธฐ์กด์ ๊ฐ์ฒด์ ์ฐธ์กฐ ๊ฐ์ด ๋ฌ๋ผ ์์ ์๋ก์ด ๊ฐ์ฒด์ฌ์, ์๋ก ์ํฅ์ ๋ฐ์ง ์๋๋ค.

### ์์ฑ์์ ์ง์  ๊ฐ์ ๋ฃ๊ธฐ

```java
public class DeepCopyAndShallowCopy {
    public static void main(String[] args) {
        DeepCopyUser deepCopyUser = new DeepCopyUser("๋ฅ์นดํผ", 50);
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

- ์์ ๊ฐ์ด deepCopyUser ๊ฐ์ฒด์ ๊ฐ์ copiedDeepCopyUser์ ์์ฑ์์ ๋ฃ์์ต๋๋ค.
- new ์ฐ์ฐ์๋ฅผ ํตํด ์๋กญ๊ฒ ์์ฑ๋๋ ๊ฐ์ฒด์ด๊ธฐ ๋๋ฌธ์ ๊ธฐ์กด์ ๊ฐ์ฒด(deepCopyUser)์๋ hashCode๊ฐ ๋ค๋ฆ๋๋ค.

## โShallow Copy๋?

์๋ก์ด ๊ฐ์ฒด๋ฅผ ๋ง๋ค ๋, ๋ณต์ฌํ  ๊ฐ์ฒด์ ์ฐธ์กฐ ๊ฐ์ ๋๊ฐ์ด ๋ฃ์ด์ ๋ง๋๋ ๊ฒ.

- ์ฐธ์กฐ ๊ฐ์ ๋ณต์ฌํ๊ธฐ ๋๋ฌธ์ ์ด๋ ํ๋์ ๊ฐ์ฒด๊ฐ ์์ ๋๋ฉด ๋ณต์ฌํ ๊ฐ์ฒด์๋ ์ํฅ์ ์ค๋ค.

### ์ง์  ์ฝ๋๋ฅผ ์์ฑํด๋ณด์

```java
package org.example.week5;

public class DeepCopyAndShallowCopy {
    public static void main(String[] args) {
        ShallowCopyUser shallowCopyUser = new ShallowCopyUser("์์นดํผ", 34);
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

- new ์ฐ์ฐ์๋ฅผ ์ฌ์ฉํ์ง ์๊ณ , ๊ธฐ์กด์ ๊ฐ์ฒด(shallowCopyUser)์ ์ฐธ์กฐ ๊ฐ์ ์๋ก์ด ๊ฐ์ฒด(copiedShallowCopyUser)์ ํ ๋นํด์คฌ์ต๋๋ค.
- ๋ ๋ค ๋์ผํ ์ฃผ์๋ฅผ ํฌ์ธํ ํ๊ณ  ์๊ธฐ ๋๋ฌธ์ ๊ฐ์ด ๊ฐ์ต๋๋ค.
- ์ด๋ ํ๋๊ฐ ์์ ์ด ๋๋ฉด ๊ฐ์ ์ฐธ์กฐ๋ฅผ ๊ฐ์ง ๋๋จธ์ง ๊ฐ์ฒด์๋ ์ํฅ์ ์ค๋๋ค.

## ๊ถ๊ธํ ์ 

- Cloneable ์ธํฐํ์ด์ค๋ ์ ์๋ฌด๊ฒ๋ ์๋ ๋น ์ธํฐํ์ด์ค์ผ๊น?

  ![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/be0d5ca5-3d7c-42f6-aee9-200ba7ecd9b1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230213%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230213T233624Z&X-Amz-Expires=86400&X-Amz-Signature=9f0bc6487d433bf9aba7ad36a36c06768a6482ec95499048369e835a0888a1f3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

    - Cloneable๋ ๋ง์ปค ์ธํฐํ์ด์ค๋ผ๊ณ  ํ๋ค.
        - ์์ฒด ์ถ์ ๋ฉ์๋์ ๊ฐ์ ๋์์ด ํ๋๋ ์กด์ฌํ์ง ์๋๋ค.