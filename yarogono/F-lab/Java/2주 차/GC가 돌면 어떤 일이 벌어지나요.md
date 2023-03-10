# ๐ ์ฐธ๊ณ ์๋ฃ

---

- Naver D2 - Java Reference์ GC โ [**๋งํฌ**](https://d2.naver.com/helloworld/329631)
- Nave D2 - Java Garbage Collection โ [**๋งํฌ**](https://d2.naver.com/helloworld/1329)
- ์ค๋ผํด ๊ณต์๋ฌธ์ โ [**๋งํฌ**](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html)
- ์ค๋ผํด์์ ์ ๊ณตํ๋ PDF โ [**๋งํฌ**](https://www.oracle.com/technetwork/java/javase/memorymanagement-whitepaper-150215.pdf)
- Garbage Collection(๊ฐ๋น์ง ์ปฌ๋ ์)์ ๊ฐ๋ ๋ฐ ๋์ ์๋ฆฌ โ [**๋งํฌ**](https://mangkyu.tistory.com/118)
- ๊ฐ๋น์ง ์ปฌ๋ ์ ๋์ ์๋ฆฌ & GC ์ข๋ฅ ์ด์ ๋ฆฌ โ [**๋งํฌ**](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%EC%85%98GC-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC)
- [JVM] Garbage Collection Algorithms โ [**๋งํฌ**](https://medium.com/@joongwon/jvm-garbage-collection-algorithms-3869b7b0aa6f)
- ๊ฐ๋น์ง ์ปฌ๋ ์ GC(Garbage Collection)์ ๋์์๋ฆฌ์ ๋์ํ๋ ์์  **โ [๋งํฌ](https://itkjspo56.tistory.com/285)**

# โ๊ณต๋ถ ๋ด์ฉ ์ ๋ฆฌ

---

## 1. GC๊ฐ ๋๋ฉด ๋ฒ์ด์ง๋ ์ผ(ํ ์ค ์ ๋ฆฌ)

- JVM์ Heap ๋ฉ๋ชจ๋ฆฌ๋ฅผ ์ ๊ฒํ์ฌ ์คํ์์ ์ฐธ์กฐ๋์ง ์๋ ๊ฐ์ฒด๋ฅผ ๋ฉ๋ชจ๋ฆฌ์์ ํด์ ํ๋ค.

## 2. ์ GC๋ฅผ ๊ณต๋ถํด์ผ ํ ๊น?

GC์ ์์กด์ ์ด๋ฉด, ๋ฉ๋ชจ๋ฆฌ๊ฐ ์ธ์  ํด์ ๋๋์ง ์ ์๊ฐ ์๊ฒ ๋ฉ๋๋ค.

GC์ ํน์ฑ๊ณผ ํ๊ณ๋ฅผ ๋ชจ๋ฅด๋ฉด ๋ฉ๋ชจ๋ฆฌ ๋ฌธ์ ๋ก๋ถํฐ ๋ณด๋ค ์์ ๋ก์ด ์ํํธ์จ์ด๋ฅผ ๋ง๋ค๊ธฐ ์ด๋ ต์ต๋๋ค.

- [TMI]ํ์ฌ๋ฅผ ๋ค๋ ๋ GC์ ํน์ฑ์ ๋ชจ๋ฅด๊ณ  ์ฝ๋ฉ์ ํ๋ค๊ฐ ๋ฌธ์ ๊ฐ ๋ฐ์ํ ์ฐ

  StringBuilder ๊ฐ์ฒด์ ์์ฒญ๋๊ฒ ๊ธด ๋ฌธ์์ด์ appendํ ๊ฑธ ํ์ผ๋ก ๋ง๋๋ ์๋ฌด์์ต๋๋ค.

  ์ ๋ฐฉ๋ฒ์ ๊ฒฐ๊ตญ OOM(Out Of Memory)์ด ๋ฐ์ํ๊ณ  ํด๊ฒฐํ๋๋ฐ ์๋นํ ์๊ฐ์ด ๊ฑธ๋ ธ์์ต๋๋ค.


GC๋ฅผ ๊ณต๋ถํด์ผ ํ๋ ๊ฒ์ ์ด์  ์์์ผ๋

๊ทธ๋ ๋ค๋ฉด GC๋ ๋ฌด์์ผ๊น?

## 3. Garbage Collection๋?

JVM์ Heap ์์ญ์์ ๋์ ์ผ๋ก ํ ๋นํ๋ ๋ฉ๋ชจ๋ฆฌ ์ค ํ์ ์๊ฒ ๋ ๋ฉ๋ชจ๋ฆฌ ๊ฐ์ฒด(Garbage)๋ฅผ ๋ชจ์

์ฃผ๊ธฐ์ ์ผ๋ก ์ ๊ฑฐํ๋ ํ๋ก์ธ์ค๋ฅผ ๋งํ๋ค.

GC๋ Heap ์์ญ์์ ์ฃผ๋ก ๋์์ ํ๋ ๊ฒ ๊ฐ์.

GC๊ฐ ์ฃผ๋ก ๋์ํ๋ ๋ฌด๋์ธ Heap์ ๋ํด ๋ ์์๋ด์ผ ํ  ๊ฒ ๊ฐ๋ค.

๊ทธ๋ฌ๋ฉด Heap์ ๊ตฌ์กฐ๋ ์ด๋ป๊ฒ ๋์ด์์๊น?

## 4. ๊ฐ์ฒด๋ฅผ ์ ์ฅํ๋ ํ(Heap)์ ๊ตฌ์กฐ๋?

![images_recordsbeat_post_682408fc-f29e-42e9-b980-3d6f1d6c4989_image.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/880b00ca-73df-4372-9851-c406a9c6919e/images_recordsbeat_post_682408fc-f29e-42e9-b980-3d6f1d6c4989_image.png)

๊ฐ์ฒด์ ์์กด ๊ธฐ๊ฐ์ ๋ฐ๋ผ ๋ฌผ๋ฆฌ์ ์ธ Heap ์์ญ์ ๋๋ ์ ธ ์๋ค.

Young, Old, Perm ์์ญ ์ด 3๊ฐ์ง ์์ญ์ด ์์์ง๋ง, Perm ์์ญ์ Java8๋ถํฐ ์ ๊ฑฐ๋์๋ค.

![Young ์์ญ.JPG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/87449c2d-e9b2-4fe4-8def-96cd16a128f1/Young_%EC%98%81%EC%97%AD.jpg)

### Young ์์ญ(Young Generation)

- ์๋กญ๊ฒ ์์ฑ๋ ๊ฐ์ฒด๊ฐ ํ ๋น(Allocation)๋๋ ์์ญ
- Young ์์ญ์ ๋ํ ๊ฐ๋น์ง ์ปฌ๋ ์(Garbage Collection)์ Minor GC๋ผ๊ณ  ๋ถ๋ฅธ๋ค.
- ๋๋ถ๋ถ์ ๊ฐ์ฒด๊ฐ ๊ธ๋ฐฉ ์ ๊ทผ ๋ถ๊ฐ ์ํ(unreachable)๊ฐ ๋๊ธฐ ๋๋ฌธ์ ๋ง์ ๊ฐ์ฒด๊ฐ Young ์์ญ์ ์์ฑ๋์๋ค๊ฐ ์ฌ๋ผ์ง๋ค.
- Young ์์ญ์ Eden, Survivor 2๊ฐ์ ์์ญ์ผ๋ก ๋๋์ด์ง๋ค.
    - **Eden ์์ญ**
        - ๊ฐ์ฒด๋ฅผ new ์ฐ์ฐ์๋ก ์์ฑํด ๋ฉ๋ชจ๋ฆฌ๊ฐ ํ ๋น๋๋ฉด Eden ์์ญ์ ์์ฑ๋๋ค.
        - Eden ์์ญ์ด ๊ฐ์ฒด๋ค๋ก ์ฐจ๋ฉด, Minor GC๊ฐ ์๋ํ๊ณ  ๋จ์ ๋ชจ๋  survivor ๊ฐ์ฒด๋ค์ survivor ์์ญ์ผ๋ก ์ฎ๊ฒจ์ง๋ค.

    - **Survivor ์์ญ**
        - Eden ์์ญ์์ java GC๊ฐ ์๋ํ๊ณ  ๋จ์ ๊ฐ์ฒด๋ค์ด ์ ์ฅ๋๋ pool์ด๋ค.
        - Survivor(From)์ด ๊ฐ๋ ์ฐจ๋ฉด Survivor(To)๋ก ๋ณด๋ด๊ณ  Survivor(From)์ ๋น์๋๋ค.
        - ๋ง์ง๋ง๊น์ง ์ด์๋จ์ ๊ฐ์ฒด๋ Old ์์ญ์ผ๋ก ๊ฐ๋๋ค.

### Old ์์ญ(Old Generation)

- Young ์ญ๋ณด๋ค ํฌ๊ฒ ํ ๋น๋๋ฉฐ, ์์ญ์ ํฌ๊ธฐ๊ฐ ํฐ ๋งํผ Young ์์ญ๋ณด๋ค GC๋ ์ ๊ฒ ๋ฐ์ํ๋ค.
- Old ์์ญ์ ๋ํ ๊ฐ๋น์ง ์ปฌ๋ ์(Garbage Collection)์ Major GC ๋๋ Full GC๋ผ๊ณ  ๋ถ๋ฅธ๋ค.
- Old ์์ญ์ ๊ฐ์ฒด๋ค์ด ๊ฐ๋ ์ฐจ๋ฉด Major GC๊ฐ ์คํ๋ฉ๋๋ค.
    - GC์ ์๊ณ ๋ฆฌ์ฆ์ ๋ฐ๋ผ์ Major GC(Full GC)์ ์ ์ฐจ๊ฐ ๋ฌ๋ผ์ง๋ค.
      โ Serial GC, Parallel GC, Concurrent Mark & Sweep GC (CMS), G1(Garbage First) GC

## 5. ๊ถ๊ธํ ๋ด์ฉ ์ ๋ฆฌ

### โMinor GC์ Major GC๋?

- **Minor GC**
    - Young ์์ญ์์ ๊ฐ์ฒด๊ฐ ์ฌ๋ผ์ง ๋ Minor GC๊ฐ ๋ฐ์ํ๋ค๊ณ  ๋งํ๋ค.
- **Major GC(Full GC)**
    - Old ์์ญ์์ ๊ฐ์ฒด๊ฐ ์ฌ๋ผ์ง ๋ Major GC(Full GC)๊ฐ ๋ฐ์ํ๋ค๊ณ  ๋งํ๋ค.


### โMajor GC(Full GC)์ ์๊ณ ๋ฆฌ์ฆ์ ์ข๋ฅ๋?

- Serial GC

  Mark-Sweep-Conpact ์๊ณ ๋ฆฌ์ฆ์ ์ฌ์ฉํฉ๋๋ค.

    - Old ์์ญ์์ Reachableํ ๊ฐ์ฒด๋ฅผ ์๋ณ(Mark)ํฉ๋๋ค.
    - ์ด์์๋ ๊ฐ์ฒด๋ง ๋จ๊ธฐ๊ณ  Unreachableํ ๊ฐ์ฒด๋ ์ ๊ฑฐ(Sweep)ํฉ๋๋ค.
    - ๊ฐ์ฒด๋ค์ ์๋ถํฐ ์ฑ์๋๊ฐ์ ๊ฐ์ฒด๊ฐ ์กด์ฌํ๋ ๋ถ๋ถ๊ณผ ์กด์ฌํ์ง ์๋ ๋ถ๋ถ์ ๋๋๋๋ค.
- Parallel GC
    - ๊ธฐ๋ณธ์ ์ธ ์๊ณ ๋ฆฌ์ฆ์ Serial GC์ ๊ฐ์ง๋ง, ์ฌ๋ฌ ์ค๋ ๋๋ฅผ ๋ณ๋ ฌ์ (Parallel)์ผ๋ก ์ด์ฉํ์ฌ GC๋ฅผ ์งํํฉ๋๋ค.
- Concurrent Mark & Sweep GC (CMS)
    - ์๋ต์๊ฐ์ด ์ฒ๋ฆฌ๋๋ณด๋ค ์ค์ํ ๊ฒฝ์ฐ ์ ํฉํ๋ค.
    - API์๋ฒ์ฒ๋ผ ์ฝ 1์ด ๋ณด๋ค ์งง์ pause ์๊ฐ์ ๊ณ์ํด ์ ์งํด์ผ ํ๋ค๋ฉด ํด๋น GC ์ฌ์ฉ์ ๊ถ์ฅํ๋ค.
- G1(Garbage First) GC
    - 64๋นํธ ์ปดํจํฐ ์ต์ ํ๋ GC๋ก 4GB  ์ด์์ Heap size์ ์ ํฉํ GC๋ค.

### โReachable, Unreachable ๊ฐ์ฒด๋?

๊ฐ๋น์ง ์ปฌ๋ ์(Garbage Collection)์ ํน์  ๊ฐ์ฒด๊ฐ ๊ฐ๋น์ง์ธ์ง ์๋์ง ํ๋จํ๊ธฐ ์ํด์

๋๋ฌ์ฑ, ๋๋ฌ๋ฅ๋ ฅ(Reachability) ์ด๋ผ๋ ๊ฐ๋์ ์ ์ฉํ๋ค.

๊ฐ์ฒด์ ์ ํจํ ๋ ํผ๋ฐ์ค๊ฐ ์๋ค๋ฉด **Unreachable**๋ก ๊ตฌ๋ถํด๋ฒ๋ฆฌ๊ณ  ์๊ฑฐํด๋ฒ๋ฆฐ๋ค.

๋ ํผ๋ฐ์ค๊ฐ ์๋ค๋ฉด **Reachable**๋ก ๊ตฌ๋ถ๋๋ค.

# ๊ณต๋ถํ๋ฉด์ ๋๋ ์ 

---

- ๊ณต๋ถ๋ฅผ ํ์ง๋ง ์์ง ๋ชจ๋ฅด๋๊ฒ ๋๋ฌด ๋ง๊ณ  ์ดํด๊ฐ ์๋๋ ๋ถ๋ถ์ด ์ฐ๋๋ฏธ์ด๋ค.
- GC ํ๋์ ํตํ ์ฑ๋ฅ ์ต์ ํ
    - ์์ง GC์ ๋ํด ๋ชจ๋ฅด๋๊ฒ ๋ง๊ณ  ์ฐ์  ์ฝ๋์ ์ฑ๋ฅ ์ต์ ํ์ ์ง์ค์ด ํ์ํ๋ค๊ณ  ๋๊ผ๋ค.
- GC์ ๋ํ ๊ฐ๋์ด ์๋๋ผ JVM์ ๋ฉ๋ชจ๋ฆฌ์ ์ฐ๊ฒฐ๋๋ ๊ฒ๋ค์ ์ฐพ๊ณ  ๊ณต๋ถํด์ผ๊ฒ ๋ค.
- ๊ณต๋ถ๋ฅผ ํ๋ฉด์ ์ฐพ์๋ณธ ๋ ํผ๋ฐ์ค ์๋ฃ๋ค์ ์ ์ ๋ฆฌํด์ ๋ณด๊ดํ์.
    - ์ง๊ธ์ ์ดํด๊ฐ ์๋๋๋ผ๋ ๋์ค์ ๊ผญ ๋ค์ ๋ด์ผ ํ  ๋ด์ฉ์ด๋ค.
    - ๋์ค์ ๋ค์ ๋ดค์ ๋ ๋ฏธํกํ๊ฑฐ๋ ์๋ชป๋ ๋ด์ฉ์ ์์ 
- ์ฌ๋ฌ ๋ธ๋ก๊ทธ๋ฅผ ์ฐพ์๋ณด๋ ๊ฒ๋ ์ข์ง๋ง ์๊ฐ์ด ๋ง์ด ๋ ๋ค.
    - ๋ฒ์ญํ๊ณ  ์ดํดํ๋๋ฐ ์๊ฐ์ด ์ข ๋ค๋๋ผ๋ ๊ณต์ ๋ฌธ์๋ฅผ ์ฐพ์ ๋ณด์.
      (๊ณต์ ๋ฌธ์๋ ์ฐธ๊ณ  ์๋ฃ ๋งํฌ์)