# 🔗 참고자료

---

- 스택오버플로우 - Hot do you crash a JVM ⇒ [**링크**](https://stackoverflow.com/questions/65200/how-do-you-crash-a-jvm)
- 고맙다 JVM, 사과해라 JVM 크래시 ⇒ [**링크**](https://d2.naver.com/helloworld/1134732)
- 스택오버플로우 - Write Java code to crash the java virtual machine ⇒ [**링크**](https://stackoverflow.com/questions/7771068/write-java-code-to-crash-the-java-virtual-machine)
- sun.misc.Unsafe ⇒ [**링크**](http://younghwannam.blogspot.com/2018/11/javathreadunsafe-sunmiscunsafe-1.html)
- Guide to sun.misc.Unsafe ⇒ [**링크**](https://www.baeldung.com/java-unsafe)
- Java Magic. Part 4: sun.misc.Unsafe ⇒ [**링크**](http://mishadoff.com/blog/java-magic-part-4-sun-dot-misc-dot-unsafe/)
- JVM Crash 문제 해결하기 ⇒ **[링크](https://www.whatap.io/ko/blog/28/)**
- 오라클 - Determine Where the Crash Occurred ⇒ [**링크**](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/crashes001.html)
- Crashing Java with sun.misc.Unsafe ⇒ [**링크**](https://alexkalinins.medium.com/crashing-java-with-sun-misc-unsafe-404099e5b471)
- JVMLS 2015 - The Secret History and Tragic Fate of sun.misc.Unsafe 유튜브 영상 ⇒ [**링크**](https://www.youtube.com/watch?v=4HG0YQVy8UM&t=60s&ab_channel=Java)

# ✏공부 내용 정리

---

# JVM 크래시 내는 코드

---

```java
public class JvmCrash {
	public static void main(String... args) throws Exception {
	    getUnsafe().getByte(0);
	}
	
	private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
	    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
	    theUnsafe.setAccessible(true);
	    return (Unsafe) theUnsafe.get(null);
	}
}
```

- Unsafe 클래스는 new 연산자를 사용해 인스턴스를 생성 할 수 없다.
   - Reflection을 이용하여 Unsafe를 사용할 수 있다.

## 에러 사진 캡처

---

![에러캡처.JPG](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/52aad9c5-6d6d-4f9c-8baf-912f5cb42d8f/%EC%97%90%EB%9F%AC%EC%BA%A1%EC%B2%98.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230205%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230205T234232Z&X-Amz-Expires=86400&X-Amz-Signature=177ad1ab68862b889f58ff16e1accfe39cc77820528734c4a85344cf023ac9bd&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EC%2597%2590%25EB%259F%25AC%25EC%25BA%25A1%25EC%25B2%2598.JPG.jpg%22&x-id=GetObject)

- 코드를 실행하면 위와 같은 에러가 발생한다.
- JVM 크래시 로그 파일이 하나 생성이 된다.(hs_err_pid5096.log)
- 버그 리포트를 할 수 있는 오라클 링크가 있다.

꽤 긴 로그 파일을 생성해서 유저에게 주는 이유는 JVM이 버그를 찾을 수 없으니까,
직접 버그를 찾아서 오라클에 리포트 하라는 것 같다.

그렇다면 해당 코드는 왜 JVM 크래시를 유발 할 까?

우선 Unsafe가 뭔지 찾아봤다.

## ❓Unsafe란

---

- sun.misc.Unsafe 는 public API 이다.
- low-level의 안전하지 못한 오퍼레이션을 수행하는 메소드의 모음이다.
   - low-level 프로그래밍을 할 수 있게 해준다.
- JVM 내의 메모리에 대해 직접 액세스를 허용한다.

```java
package org.example.week3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeSample {

    private final static byte BYTE = 1;
    private long size;
    private long address;

    public UnsafeSample(long size) throws NoSuchFieldException, IllegalAccessException {
        this.size = size;
        address = getUnsafe().allocateMemory(size * BYTE);
    }

    public Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }

    public void set(long i, byte value) throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().putByte(address + i * BYTE, value);
    }

    public long size() {
        return size;
    }

    public void freeMemory() throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().freeMemory(address);
    }

    public byte get(long i, byte value) throws NoSuchFieldException, IllegalAccessException {
        return getUnsafe().getByte(address + i * BYTE);
    }
}

class RunUnsafeSample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        long SUPER_SIZE = (long) Integer.MAX_VALUE * 2;
        UnsafeSample unsafeSample = new UnsafeSample(SUPER_SIZE);
        byte tempByte = 8;
        unsafeSample.set(2L, tempByte);

        System.out.println(unsafeSample.get(2L, tempByte));
    }
}
```

- Unsafe 클래스가 제대로 작동되는 코드이다.

제대로 작동하는 코드를 보니까 왜 에러가 났는지 알 거 같다.

그 이유는 아래와 같아.

- 메모리를 할당하지 않았다 ⇒ allocateMemory
- 값을 set 하지도 않고 get 할려고 했다.

일련의 절차를 거치지 않고 그냥 임의에 주소 값을 입력하니까 JVM 크래시가 난 것이다.

이유를 알았으니 로그에도 해당 정보가 나와있는지 찾아봤다.

## 로그 파일 들여다보기

---

```java
# A fatal error has been detected by the Java Runtime Environment:
#
#  EXCEPTION_ACCESS_VIOLATION (0xc0000005) at pc=0x00007ff8e0cd1263, pid=12076, tid=10220
#
# JRE version: OpenJDK Runtime Environment (17.0+35) (build 17+35-2724)
# Java VM: OpenJDK 64-Bit Server VM (17+35-2724, mixed mode, sharing, tiered, compressed oops, compressed class ptrs, g1 gc, windows-amd64)
# Problematic frame:
# V  [jvm.dll+0x7a1263]
#
# No core dump will be written. Minidumps are not enabled by default on client versions of Windows
#
# If you would like to submit a bug report, please visit:
#   https://bugreport.java.com/bugreport/crash.jsp
#
```

위 에러를 보면 로그에서 ‘Probematic frame’ 이 있다.

그 아래에 있는 [jvm.dll+0x7a1263] 은 문제가 발생한 위치를 나타낸다.

**❓jvm.dll이 무엇일까?**

> Dynamic Link Library(DLL) 은 마이크로소프트가 공유 라이브러리 개념을 구현한 것이다.
DLL 파일은 여러 프로그램이 동시에 사용 할 수 있는 코드와 데이터를 포함하므로
코드 재사용과 모듈화를 촉진한다.
>
- 정적 라이브러리(lib)와 동적 라이브러리(dll)

  아무래도 위 차이를 제대로 알고 넘어가야 할 것 같아서 적게 되었다.

  ![1620088158145.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c5bbc1f8-b8ed-4557-a026-767568209b30/1620088158145.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230205%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230205T234218Z&X-Amz-Expires=86400&X-Amz-Signature=abd5c243fa641b6266e226a318471617296c9e53da7456dc2999246e200a1586&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%221620088158145.png%22&x-id=GetObject)

  ## 정적 라이브러리(Static Library / Lib)

   - 여러 프로그램에서 재사용 할 수 있지만, 컴파일 타임에는 프로그램에 잠겨 있습니다.
   - 컴파일의 연결 단계에서 프로그램에 연결되는 개체 파일 모음일 뿐이며,
     런타임 중에는 관련이 없습니다.

  ## 동적 라이브러리(Dynamic Link Library)

   - 실행 파일 외부에 별도의 파일로 존재합니다.

jvm.dll 과 Unsafe 클래스의 연관성을 정확히 모르겠다.

여러번 어플리케이션을 돌려봐도 [jvm.dll+0x7a1263] 에 문제가 발생한다.

```java
getUnsafe().getInt(0);
```

getByte(0)가 아니라 위와 같이 코드를 작성해봤다.

`[jvm.dll+0x7a1722`

위와 같은 에러가 나왔다.

추론해 봤을 때 가져올려는 자료형에 따라서 차이가 있는 것 같다.

우선적으로 로그를 더 보면

```java
Stack: [0x000000da0bf00000,0x000000da0c000000],  sp=0x000000da0bfff5f0,  free space=1021k
Native frames: (J=compiled Java code, j=interpreted, Vv=VM code, C=native code)
V  [jvm.dll+0x7a1722]
C  0x00000240a54fd621

Java frames: (J=compiled Java code, j=interpreted, Vv=VM code)
j  jdk.internal.misc.Unsafe.getInt(Ljava/lang/Object;J)I+0 java.base@17
j  jdk.internal.misc.Unsafe.getInt(J)I+3 java.base@17
j  sun.misc.Unsafe.getInt(J)I+4 jdk.unsupported@17
j  test.JvmCrash.main([Ljava/lang/String;)V+6
v  ~StubRoutines::call_stub

siginfo: EXCEPTION_ACCESS_VIOLATION (0xc0000005), reading address 0x0000000000000064
```

네이티브 코드에 문제가 생긴다고 알려주고,

Unsafe의 getInt 부분이 문제가 있다고 얘기해주고 있다.

정확하게 알 수는 없지만 잘못된 주소의 값을 읽으려고 하다가 발생하는 문제 같아보인다.

getInt(주소) 의 주소값을 변경하면 reading address 부분도 동일하게 변한다.

## 결론

---

- 할당도 안되고 정확하지 않는 주소를 Unsafe로 접근을 하면 JVM 크래시가 발생한다.
- 네이티브 코드는 JVM이 관리하는 메모리가 있고 아닌 메모리가 있다.
  JVM이 관리하지 않는 메모리 영역에 에러가 발생하면 JVM 크래시가 발생 할 수 있다.

## 해보면서 배우고 느낀 점

---

- 낮은 JDK 버전이 아니라면 보통은 Exception을 터트린다.
   - StackOverFlow, OutOfMemory과 Heap 영역 메모리 관련 Exception은 JVM 크래시가 아니다.
- JVM 크래시가 발생하면 로그 파일이 생성된다.
   - 로그 파일을 참고해서 에러를 유추해서 해결한다.
- JVM 크래시가 발생한 이유를 오라클 공식 사이트에 버그 리포트를 할 수도 있다.
- JNI라는 것을 사용해서 Native Code를 작성 할 수 있다.
  직접 해보지는 않았지만, 잘못 작성하면 JVM 크래시를 유발한다.
- Unsafe 라는 클래스는 매우 강력한 기능들이 들어있으며,
  네이티브 코드를 직접 작성하지 않고도 사용 할 수 있게 만들었다.
   - ❓네이티브 코드(Native Code)란?
      - C, C++과 같은 언어를 말한다.
      - 프로그래머가 직접 메모리를 할당하고, 해제해야 한다.
      - Unmanaged code 라고도 불린다.
      - Compile을 하게 되면 OS에서 해석 가능한 기계어로 바로 변역 된다.