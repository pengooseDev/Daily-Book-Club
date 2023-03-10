# π μ°Έκ³ μλ£

---

- Naver D2 - Garbage Collection νλ β [**λ§ν¬**](https://d2.naver.com/helloworld/37111)
- μ± <μλ° μ±λ₯ νλ μ΄μΌκΈ°> - story03 μ μκΎΈ Stringμ μ°μ§ λ§λΌλ κ±°μΌ?
- μ± <μλ° μ±λ₯ νλ μ΄μΌκΈ°> - story19 GC νλμ ν­μ ν  νμλ μλ€
- μ± <μ΄νν°λΈ μλ°> - μμ΄ν6 λΆνμν κ°μ²΄ μμ±μ νΌνλΌ
- Understanding Memory Leaks in Java β [**λ§ν¬**](https://www.baeldung.com/java-memory-leaks)
- μ€ν  λ°μ± & μ€ν  μΈλ°μ± β [**λ§ν¬**](https://gyoogle.dev/blog/computer-language/Java/Auto%20Boxing%20&%20Unboxing.html)

# βκ³΅λΆ λ΄μ© μ λ¦¬

---

## 1. String λμ  StringBuilderλ StringBuffer μ¬μ©νκΈ°

String μ¬μ©μ λ¨λ°νλ©΄μ String + String μ νλ κ²μΌλ‘ μΈν΄ λ°μνλ μκΈ°λ λ¬Έμ μ΄λ€.

```java
String resultStr = new String();
resultStr += "String test";
```

- resultStr String λ³μμ λ©λͺ¨λ¦¬κ° μλλΌ μλ‘μ΄ κ°μ²΄μ λ©λͺ¨λ¦¬λ₯Ό ν λΉνκ² λλ€.
- λ§μ½μ λ¬Έμμ΄κ³Ό λ¬Έμμ΄μ λνλ μ°μ°μ λ°λ³΅ν΄μ νλ€κ³  νλ©΄,
  λ°λ³΅λ¬Έ νμ λ§νΌ κ°μ²΄κ° μμ±λλ κ²μ΄λ€.
  β μ΄μ μ μλ κ°μ²΄λ νμ μλ μ°λ κΈ° κ°μ΄ λμ΄ GC λμμ΄ λμ΄ λ²λ¦°λ€.

- μ§μ  μ½λ μμ±ν΄μ μ±λ₯ λΉκ΅ν΄λ³΄κΈ°

    ```java
    @State(Scope.Thread)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public class TestClass {
    
        String aValue = "abcde";
    
        @Benchmark
        @OperationsPerInvocation(10000)
        public String strTest() {
            String a = new String();
            for (int loop = 0; loop < 10000; loop++) {
                a += aValue;
            }
    
            return a;
        }
    
        @Benchmark
        @OperationsPerInvocation(10000)
        public String stringBuilderTest() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int loop = 0; loop < 10000; loop++) {
                stringBuilder.append(aValue);
            }
    
            return stringBuilder.toString();
        }
    
        @Benchmark
        @OperationsPerInvocation(10000)
        public String stringBufferTest() {
            StringBuffer stringBuffer = new StringBuffer();
    
            for (int loop = 0; loop < 10000; loop++) {
                stringBuffer.append(aValue);
            }
            String temp2 = stringBuffer.toString();
    
            return stringBuffer.toString();
        }
    
        public static void main(String[] args) throws RunnerException {
            Options opt = new OptionsBuilder()
                    .include(TestClass.class.getSimpleName())
                    .forks(1)
                    .build();
    
            new Runner(opt).run();
        }
    }
    ```

  <μλ° μ±λ₯ νλ μ΄μΌκΈ°> μ±μ λμ€λ JMHλ₯Ό μ¬μ©ν΄, μ±λ₯ νμ€νΈλ₯Ό μ§μ  μ§νν΄ λ΄€μ΅λλ€.

  μ½λλ μ±μ μμ μ JMHμ μν μ½λλ₯Ό μ°Έκ³ ν΄μ μμ±νμ΅λλ€.

  μ€ν κ²°κ³Όλ μλμ κ°μ΅λλ€.

  ![μ±λ₯νμ€νΈ.JPG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0c6f82b2-acd8-4ea8-8d38-e63d1683d0ca/%EC%84%B1%EB%8A%A5%ED%85%8C%EC%8A%A4%ED%8A%B8.jpg)

    - TestClass.strTest β λ¬Έμμ΄ λ³μμ βabcdβ λ¬Έμμ΄μ λνλ μ°μ° νμ€νΈ
    - TestClass.stringBufferTest β StringBufferμ βabcdβ λ¬Έμμ΄μ append νλ νμ€νΈ
    - TestClass.stringBuilderTest β StrinbBuilderμ βabcdβ λ¬Έμμ΄μ append νλ νμ€νΈ

  StringBuilderλ₯Ό μ¬μ© ν κ²μ΄ λ¬Έμμ΄μ κ°κ° λν κ²λ³΄λ€ μ½ 300λ°° λλ μ±λ₯ μ°¨μ΄λ₯Ό λ³΄μλ€.


## 2. μ€ν λ°μ±

- μ€ν λ°μ±μ νλ‘κ·Έλλ¨Έκ° κΈ°λ³Έ νμκ³Ό λ°μ±λ κΈ°λ³Έ νμμ μμ΄ μΈ λ
  μλμΌλ‘ μνΈ λ³νν΄μ£Όλ κΈ°μ μ΄λ€.
- μ€ν λ°μ±μ κΈ°λ³Έ νμκ³Ό κ·Έμ λμνλ λ°μ±λ κΈ°λ³Έ νμμ κ΅¬λΆμ νλ €μ£Όμ§λ§,
  μμ ν μμ μ£Όλ κ²μ μλλ€.

```java
private static long sum() {
	Long sum = 0L;
	for (long i = 0; i <= Integer.MAX_VALUE; i++) {
		sum += i;
	}
	return sum;
}
```

- sum λ³μλ₯Ό longμ΄ μλ LongμΌλ‘ μ μΈν΄μ λΆνμν Long μΈμ€ν΄μ€κ° μ½ 231κ°λ λ§λ€μ΄μ§ κ²μ΄λ€.
- λ°μ±λ κΈ°λ³Έ νμλ³΄λ€λ κΈ°λ³Έ νμμ μ¬μ©νκ³ , μλμΉ μμ μ€ν λ°μ±μ΄ μ¨μ΄λ€μ§ μλλ‘ μ£Όμ

- **μ΄λ‘ μ λ΄€μΌλ μ§μ  μ½λ μμ±ν΄μ μ±λ₯ λΉκ΅ν΄λ³΄κΈ°**

  ### μ€ν λ°μ± μ°μ°

    ```java
    public static void main(String[] args) {
    	long start = System.nanoTime();
    	Long sum = 0L;
    	for (long i = 0; i < 1000000; i++) {
    	  sum += i;
    	}
    	System.out.println("μ€ν μκ° : " + (System.nanoTime() - start));
    }
    ```

  ![Long.JPG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/beddb66e-2b39-4e4b-b640-e6c7d60002be/Long.jpg)

  μ½ 14ms μ λμ μκ°μ΄ κ±Έλ Έλ€.

  ### λμΌ νμ μ°μ°

    ```java
    public static void main(String[] args) {
    	long start = System.nanoTime();
    	long sum = 0;
    	  for (long i = 0; i < 1000000; i++) {
    	  sum += i;
    	}
    	System.out.println("μ€ν μκ° : " + (System.nanoTime() - start));
    }
    ```

  ![longNum.JPG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c6952a85-c3a2-4718-931f-a217f023485c/longNum.jpg)

  μ½ 2ms μ λμ μκ°μ΄ κ±Έλ Έλ€.

    - λ¬Έμ νλ μ°¨μ΄λ‘ μ±λ₯μ μ°¨μ΄κ° λμ ν λ³΄μ΄κ² λλ€.
    - μλ¬΄λ¦¬ CPUμ μ±λ₯μ΄ μ’μμ‘λ€κ³  ν΄λ μμ κ²λΆν° μ±λ₯ μ΅μ νμ μ κ²½ μ°μ.
        - μμ κ°μ μ±λ₯ μ΄μκ° μλ μ½λκ° μ μΌλ©΄ λͺ¨λ₯΄κ² μ§λ§,
          μ½λκ° μμ΄κ³  μμΌμλ‘ μ±λ₯μλ μμν₯μ μ€ κ²μ΄λ€.


### 3. GC νλμ νλ©΄ λ μλνμ§ μμκΉ?

- β[**GCκ° λλ©΄ μ΄λ€ μΌμ΄ λ²μ΄μ§λμ?**](https://www.notion.so/GC-445ed53b3a254486b7490f0bcf9240e0)β μλ μμ±νμ§λ§ μ±λ₯ μ΅μ νλ μμ§ GCμ λν μ΄ν΄κ° λΆμ‘±ν΄μ κ³ λ €νμ§λ μμμ΅λλ€.
- GC νλμ λν κΈμ μ½μ΄λ³΄λ©΄μ λλ μ μ μ μ΄λ΄€μ΅λλ€.
    - AλΌλ μλΉμ€μμ GCμ΅μμ μ μ μ©ν΄μ μ μλνλ€κ³  ν΄λ,
      λ€λ₯Έ μλΉμ€μμλ νλ₯­νκ² μ μ©λμ΄ μ΅μ νμ ν¨κ³Όλ₯Ό λ³Ό μ μλ€κ³  μκ°νμ§ λ§μ.
      β κ° μλΉμ€λ§λ€ νκ²½μ΄ λ€λ₯΄λ€. κ·Έλμ ν΄λΉ μλΉμ€μ λ§κ² GC νλμ μ§μμ μΌλ‘ λͺ¨λν°λ§ νλ©΄μ μ§νν΄μΌ νλ€.
    - κΈ°λ³Έμ μΈ λ©λͺ¨λ¦¬ ν¬κΈ° μ λλ§ μ§μ νλ©΄ μ¬λ§νΌ μ¬μ©λμ΄ λ§μ§ μμ μμ€νμμλ νλμ ν  νμκ° μλ€.


κ²°λ‘ μ μ μ λ΅μ²λΌ μ΅μ νλ GC νλμ μ΅μμ μλ€.

GC νλ μ΅μμ ν΄λΉ νκ²½μ λ§κ² μ§ν νλ©΄μ μ§μμ μΌλ‘ λͺ¨λν°λ§ νλ κ²μ΄λ€.

- β κ·Έλ λ€λ©΄ λ΄κ° μ§κΈ μμμΌ ν  κ²μ?
    - GCνλ μ΅μκ³Ό μ΅μ λ³κ²½ λ°©λ²
        - μ£Όμν΄μΌ ν  μ΅μ
    - GC λͺ¨λν°λ§ νλ λ°©λ²
        - λͺ¨λν°λ§ ν΄ μ§μ  μ€μΉνκ³  μ¬μ©ν΄λ³΄κΈ°

# κ³΅λΆνλ©΄μ λλ μ 

---

- Stringκ³Ό Stringμ λνλ μ°μ°μ λ©λͺ¨λ¦¬ λμμ μμΈμ΄λΌλ μκΈ°λ λ€μμλ€.
  νμ§λ§ μ§μ  κ³΅λΆν΄λ³΄κ³  StringBuilderλ³΄λ€ μμ­λ°° μ°¨μ΄κ° λλ€λ κ²μ μΆ©κ²©μ μ΄μλ€.
- μμ μλ μ±λ₯μ΄λ μ¬λ¬ μμ κ° λμ€λ©΄ κ·Έλ₯ μ½κ³  λμ΄κ° μ μ΄ λ§μλ€.
  μ΄λ²μλ μ§μ  μ½λλ₯Ό μμ±ν΄λ³΄λ©΄μ μ±λ₯ μ²΄ν¬λ₯Ό ν΄λ³΄λ κΈ°μ΅μ λ μ λ¨κ³  μ λΏμλ€.
- μ±μ μ½μ λ μ λΆλΆλΆν° λ΄μ©μ μ λ¦¬νλ©΄μ μ½μμλ€.
  μ΄λ²μ βμλ° μ±λ₯ νλ μ΄μΌκΈ°β λ κΆκΈν λ΄μ©κ³Ό μ°κ²°λλ λ΄μ©μ μ°Ύμμ μ½κ³  λ΄μ©μ μ λ¦¬νλ€.
    - μ±μ μ²μλΆν° λκΉμ§ μ½λ κ²λ μ’μ§λ§, κΈ°μ΅μ λ¨μ§ μμλ€.
      μκ° λλΉ ν¨μ¨μ΄ λλ¬΄ μ μλ€.
      μ λΆ λ€ μ½κΈ°κ° μ’κΈ°λ νκ² μ§λ§, νμν λΆλΆμ μ½κ³  μμ½νλ λ°©μμ΄ μ§κΈμ λ§λ κ² κ°λ€.