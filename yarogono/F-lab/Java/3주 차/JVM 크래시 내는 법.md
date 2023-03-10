# ๐ ์ฐธ๊ณ ์๋ฃ

---

- ์คํ์ค๋ฒํ๋ก์ฐ - Hot do you crash a JVM โ [**๋งํฌ**](https://stackoverflow.com/questions/65200/how-do-you-crash-a-jvm)
- ๊ณ ๋ง๋ค JVM, ์ฌ๊ณผํด๋ผ JVM ํฌ๋์ โ [**๋งํฌ**](https://d2.naver.com/helloworld/1134732)
- ์คํ์ค๋ฒํ๋ก์ฐ - Write Java code to crash the java virtual machine โ [**๋งํฌ**](https://stackoverflow.com/questions/7771068/write-java-code-to-crash-the-java-virtual-machine)
- sun.misc.Unsafe โ [**๋งํฌ**](http://younghwannam.blogspot.com/2018/11/javathreadunsafe-sunmiscunsafe-1.html)
- Guide to sun.misc.Unsafe โ [**๋งํฌ**](https://www.baeldung.com/java-unsafe)
- Java Magic. Part 4: sun.misc.Unsafe โ [**๋งํฌ**](http://mishadoff.com/blog/java-magic-part-4-sun-dot-misc-dot-unsafe/)
- JVM Crash ๋ฌธ์  ํด๊ฒฐํ๊ธฐ โ **[๋งํฌ](https://www.whatap.io/ko/blog/28/)**
- ์ค๋ผํด - Determine Where the Crash Occurred โ [**๋งํฌ**](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/crashes001.html)
- Crashing Java with sun.misc.Unsafe โ [**๋งํฌ**](https://alexkalinins.medium.com/crashing-java-with-sun-misc-unsafe-404099e5b471)
- JVMLS 2015 - The Secret History and Tragic Fate of sun.misc.Unsafe ์ ํ๋ธ ์์ โ [**๋งํฌ**](https://www.youtube.com/watch?v=4HG0YQVy8UM&t=60s&ab_channel=Java)

# โ๊ณต๋ถ ๋ด์ฉ ์ ๋ฆฌ

---

# JVM ํฌ๋์ ๋ด๋ ์ฝ๋

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

- Unsafe ํด๋์ค๋ new ์ฐ์ฐ์๋ฅผ ์ฌ์ฉํด ์ธ์คํด์ค๋ฅผ ์์ฑ ํ  ์ ์๋ค.
   - Reflection์ ์ด์ฉํ์ฌ Unsafe๋ฅผ ์ฌ์ฉํ  ์ ์๋ค.

## ์๋ฌ ์ฌ์ง ์บก์ฒ

---

![์๋ฌ์บก์ฒ.JPG](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/52aad9c5-6d6d-4f9c-8baf-912f5cb42d8f/%EC%97%90%EB%9F%AC%EC%BA%A1%EC%B2%98.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230205%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230205T234232Z&X-Amz-Expires=86400&X-Amz-Signature=177ad1ab68862b889f58ff16e1accfe39cc77820528734c4a85344cf023ac9bd&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EC%2597%2590%25EB%259F%25AC%25EC%25BA%25A1%25EC%25B2%2598.JPG.jpg%22&x-id=GetObject)

- ์ฝ๋๋ฅผ ์คํํ๋ฉด ์์ ๊ฐ์ ์๋ฌ๊ฐ ๋ฐ์ํ๋ค.
- JVM ํฌ๋์ ๋ก๊ทธ ํ์ผ์ด ํ๋ ์์ฑ์ด ๋๋ค.(hs_err_pid5096.log)
- ๋ฒ๊ทธ ๋ฆฌํฌํธ๋ฅผ ํ  ์ ์๋ ์ค๋ผํด ๋งํฌ๊ฐ ์๋ค.

๊ฝค ๊ธด ๋ก๊ทธ ํ์ผ์ ์์ฑํด์ ์ ์ ์๊ฒ ์ฃผ๋ ์ด์ ๋ JVM์ด ๋ฒ๊ทธ๋ฅผ ์ฐพ์ ์ ์์ผ๋๊น,
์ง์  ๋ฒ๊ทธ๋ฅผ ์ฐพ์์ ์ค๋ผํด์ ๋ฆฌํฌํธ ํ๋ผ๋ ๊ฒ ๊ฐ๋ค.

๊ทธ๋ ๋ค๋ฉด ํด๋น ์ฝ๋๋ ์ JVM ํฌ๋์๋ฅผ ์ ๋ฐ ํ  ๊น?

์ฐ์  Unsafe๊ฐ ๋ญ์ง ์ฐพ์๋ดค๋ค.

## โUnsafe๋

---

- sun.misc.Unsafe ๋ public API ์ด๋ค.
- low-level์ ์์ ํ์ง ๋ชปํ ์คํผ๋ ์ด์์ ์ํํ๋ ๋ฉ์๋์ ๋ชจ์์ด๋ค.
   - low-level ํ๋ก๊ทธ๋๋ฐ์ ํ  ์ ์๊ฒ ํด์ค๋ค.
- JVM ๋ด์ ๋ฉ๋ชจ๋ฆฌ์ ๋ํด ์ง์  ์ก์ธ์ค๋ฅผ ํ์ฉํ๋ค.

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

- Unsafe ํด๋์ค๊ฐ ์ ๋๋ก ์๋๋๋ ์ฝ๋์ด๋ค.

์ ๋๋ก ์๋ํ๋ ์ฝ๋๋ฅผ ๋ณด๋๊น ์ ์๋ฌ๊ฐ ๋ฌ๋์ง ์ ๊ฑฐ ๊ฐ๋ค.

๊ทธ ์ด์ ๋ ์๋์ ๊ฐ์.

- ๋ฉ๋ชจ๋ฆฌ๋ฅผ ํ ๋นํ์ง ์์๋ค โ allocateMemory
- ๊ฐ์ set ํ์ง๋ ์๊ณ  get ํ ๋ ค๊ณ  ํ๋ค.

์ผ๋ จ์ ์ ์ฐจ๋ฅผ ๊ฑฐ์น์ง ์๊ณ  ๊ทธ๋ฅ ์์์ ์ฃผ์ ๊ฐ์ ์๋ ฅํ๋๊น JVM ํฌ๋์๊ฐ ๋ ๊ฒ์ด๋ค.

์ด์ ๋ฅผ ์์์ผ๋ ๋ก๊ทธ์๋ ํด๋น ์ ๋ณด๊ฐ ๋์์๋์ง ์ฐพ์๋ดค๋ค.

## ๋ก๊ทธ ํ์ผ ๋ค์ฌ๋ค๋ณด๊ธฐ

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

์ ์๋ฌ๋ฅผ ๋ณด๋ฉด ๋ก๊ทธ์์ โProbematic frameโ ์ด ์๋ค.

๊ทธ ์๋์ ์๋ [jvm.dll+0x7a1263] ์ ๋ฌธ์ ๊ฐ ๋ฐ์ํ ์์น๋ฅผ ๋ํ๋ธ๋ค.

**โjvm.dll์ด ๋ฌด์์ผ๊น?**

> Dynamic Link Library(DLL) ์ ๋ง์ดํฌ๋ก์ํํธ๊ฐ ๊ณต์  ๋ผ์ด๋ธ๋ฌ๋ฆฌ ๊ฐ๋์ ๊ตฌํํ ๊ฒ์ด๋ค.
DLL ํ์ผ์ ์ฌ๋ฌ ํ๋ก๊ทธ๋จ์ด ๋์์ ์ฌ์ฉ ํ  ์ ์๋ ์ฝ๋์ ๋ฐ์ดํฐ๋ฅผ ํฌํจํ๋ฏ๋ก
์ฝ๋ ์ฌ์ฌ์ฉ๊ณผ ๋ชจ๋ํ๋ฅผ ์ด์งํ๋ค.
>
- ์ ์  ๋ผ์ด๋ธ๋ฌ๋ฆฌ(lib)์ ๋์  ๋ผ์ด๋ธ๋ฌ๋ฆฌ(dll)

  ์๋ฌด๋๋ ์ ์ฐจ์ด๋ฅผ ์ ๋๋ก ์๊ณ  ๋์ด๊ฐ์ผ ํ  ๊ฒ ๊ฐ์์ ์ ๊ฒ ๋์๋ค.

  ![1620088158145.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c5bbc1f8-b8ed-4557-a026-767568209b30/1620088158145.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230205%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230205T234218Z&X-Amz-Expires=86400&X-Amz-Signature=abd5c243fa641b6266e226a318471617296c9e53da7456dc2999246e200a1586&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%221620088158145.png%22&x-id=GetObject)

  ## ์ ์  ๋ผ์ด๋ธ๋ฌ๋ฆฌ(Static Library / Lib)

   - ์ฌ๋ฌ ํ๋ก๊ทธ๋จ์์ ์ฌ์ฌ์ฉ ํ  ์ ์์ง๋ง, ์ปดํ์ผ ํ์์๋ ํ๋ก๊ทธ๋จ์ ์ ๊ฒจ ์์ต๋๋ค.
   - ์ปดํ์ผ์ ์ฐ๊ฒฐ ๋จ๊ณ์์ ํ๋ก๊ทธ๋จ์ ์ฐ๊ฒฐ๋๋ ๊ฐ์ฒด ํ์ผ ๋ชจ์์ผ ๋ฟ์ด๋ฉฐ,
     ๋ฐํ์ ์ค์๋ ๊ด๋ จ์ด ์์ต๋๋ค.

  ## ๋์  ๋ผ์ด๋ธ๋ฌ๋ฆฌ(Dynamic Link Library)

   - ์คํ ํ์ผ ์ธ๋ถ์ ๋ณ๋์ ํ์ผ๋ก ์กด์ฌํฉ๋๋ค.

jvm.dll ๊ณผ Unsafe ํด๋์ค์ ์ฐ๊ด์ฑ์ ์ ํํ ๋ชจ๋ฅด๊ฒ ๋ค.

์ฌ๋ฌ๋ฒ ์ดํ๋ฆฌ์ผ์ด์์ ๋๋ ค๋ด๋ [jvm.dll+0x7a1263] ์ ๋ฌธ์ ๊ฐ ๋ฐ์ํ๋ค.

```java
getUnsafe().getInt(0);
```

getByte(0)๊ฐ ์๋๋ผ ์์ ๊ฐ์ด ์ฝ๋๋ฅผ ์์ฑํด๋ดค๋ค.

`[jvm.dll+0x7a1722`

์์ ๊ฐ์ ์๋ฌ๊ฐ ๋์๋ค.

์ถ๋ก ํด ๋ดค์ ๋ ๊ฐ์ ธ์ฌ๋ ค๋ ์๋ฃํ์ ๋ฐ๋ผ์ ์ฐจ์ด๊ฐ ์๋ ๊ฒ ๊ฐ๋ค.

์ฐ์ ์ ์ผ๋ก ๋ก๊ทธ๋ฅผ ๋ ๋ณด๋ฉด

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

๋ค์ดํฐ๋ธ ์ฝ๋์ ๋ฌธ์ ๊ฐ ์๊ธด๋ค๊ณ  ์๋ ค์ฃผ๊ณ ,

Unsafe์ getInt ๋ถ๋ถ์ด ๋ฌธ์ ๊ฐ ์๋ค๊ณ  ์๊ธฐํด์ฃผ๊ณ  ์๋ค.

์ ํํ๊ฒ ์ ์๋ ์์ง๋ง ์๋ชป๋ ์ฃผ์์ ๊ฐ์ ์ฝ์ผ๋ ค๊ณ  ํ๋ค๊ฐ ๋ฐ์ํ๋ ๋ฌธ์  ๊ฐ์๋ณด์ธ๋ค.

getInt(์ฃผ์) ์ ์ฃผ์๊ฐ์ ๋ณ๊ฒฝํ๋ฉด reading address ๋ถ๋ถ๋ ๋์ผํ๊ฒ ๋ณํ๋ค.

## ๊ฒฐ๋ก 

---

- ํ ๋น๋ ์๋๊ณ  ์ ํํ์ง ์๋ ์ฃผ์๋ฅผ Unsafe๋ก ์ ๊ทผ์ ํ๋ฉด JVM ํฌ๋์๊ฐ ๋ฐ์ํ๋ค.
- ๋ค์ดํฐ๋ธ ์ฝ๋๋ JVM์ด ๊ด๋ฆฌํ๋ ๋ฉ๋ชจ๋ฆฌ๊ฐ ์๊ณ  ์๋ ๋ฉ๋ชจ๋ฆฌ๊ฐ ์๋ค.
  JVM์ด ๊ด๋ฆฌํ์ง ์๋ ๋ฉ๋ชจ๋ฆฌ ์์ญ์ ์๋ฌ๊ฐ ๋ฐ์ํ๋ฉด JVM ํฌ๋์๊ฐ ๋ฐ์ ํ  ์ ์๋ค.

## ํด๋ณด๋ฉด์ ๋ฐฐ์ฐ๊ณ  ๋๋ ์ 

---

- ๋ฎ์ JDK ๋ฒ์ ์ด ์๋๋ผ๋ฉด ๋ณดํต์ Exception์ ํฐํธ๋ฆฐ๋ค.
   - StackOverFlow, OutOfMemory๊ณผ Heap ์์ญ ๋ฉ๋ชจ๋ฆฌ ๊ด๋ จ Exception์ JVM ํฌ๋์๊ฐ ์๋๋ค.
- JVM ํฌ๋์๊ฐ ๋ฐ์ํ๋ฉด ๋ก๊ทธ ํ์ผ์ด ์์ฑ๋๋ค.
   - ๋ก๊ทธ ํ์ผ์ ์ฐธ๊ณ ํด์ ์๋ฌ๋ฅผ ์ ์ถํด์ ํด๊ฒฐํ๋ค.
- JVM ํฌ๋์๊ฐ ๋ฐ์ํ ์ด์ ๋ฅผ ์ค๋ผํด ๊ณต์ ์ฌ์ดํธ์ ๋ฒ๊ทธ ๋ฆฌํฌํธ๋ฅผ ํ  ์๋ ์๋ค.
- JNI๋ผ๋ ๊ฒ์ ์ฌ์ฉํด์ Native Code๋ฅผ ์์ฑ ํ  ์ ์๋ค.
  ์ง์  ํด๋ณด์ง๋ ์์์ง๋ง, ์๋ชป ์์ฑํ๋ฉด JVM ํฌ๋์๋ฅผ ์ ๋ฐํ๋ค.
- Unsafe ๋ผ๋ ํด๋์ค๋ ๋งค์ฐ ๊ฐ๋ ฅํ ๊ธฐ๋ฅ๋ค์ด ๋ค์ด์์ผ๋ฉฐ,
  ๋ค์ดํฐ๋ธ ์ฝ๋๋ฅผ ์ง์  ์์ฑํ์ง ์๊ณ ๋ ์ฌ์ฉ ํ  ์ ์๊ฒ ๋ง๋ค์๋ค.
   - โ๋ค์ดํฐ๋ธ ์ฝ๋(Native Code)๋?
      - C, C++๊ณผ ๊ฐ์ ์ธ์ด๋ฅผ ๋งํ๋ค.
      - ํ๋ก๊ทธ๋๋จธ๊ฐ ์ง์  ๋ฉ๋ชจ๋ฆฌ๋ฅผ ํ ๋นํ๊ณ , ํด์ ํด์ผ ํ๋ค.
      - Unmanaged code ๋ผ๊ณ ๋ ๋ถ๋ฆฐ๋ค.
      - Compile์ ํ๊ฒ ๋๋ฉด OS์์ ํด์ ๊ฐ๋ฅํ ๊ธฐ๊ณ์ด๋ก ๋ฐ๋ก ๋ณ์ญ ๋๋ค.