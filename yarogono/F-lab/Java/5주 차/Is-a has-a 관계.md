# π μ°Έκ³ μλ£

---

- μ± <μ€νλ§ μλ¬Έμ μν μλ° κ°μ²΄ μ§ν₯μ μλ¦¬μ μ΄ν΄> 115p
- μν€νΌλμ - Is-a β [**λ§ν¬**](https://en.wikipedia.org/wiki/Is-a)
- μν€νΌλμ - Has-a β [**λ§ν¬**](https://en.wikipedia.org/wiki/Has-a)
- Quora - What is Is-a and Has-a means in Java? β **[λ§ν¬](https://www.quora.com/What-is-Is-a-and-Has-a-means-in-Java)**
- λ΄λ μ² - μλ° κ°μ²΄μ§ν₯ κ°μ 12κ° - Has A μμ β [**λ§ν¬**](https://www.youtube.com/watch?v=6wKyPg9rxtw&ab_channel=%EB%89%B4%EB%A0%89%EC%B2%98)
- javaTpoint - Composition in Java β [**λ§ν¬**](https://www.javatpoint.com/composition-in-java)
- javaTpoint - Aggregation in Java ****β [**λ§ν¬**](https://www.javatpoint.com/aggregation-in-java)
- Guru99 - Difference Between Aggregation and Composition in UML β [**λ§ν¬**](https://www.guru99.com/uml-aggregation-vs-composition.html)
- μ€νμ€λ²νλ‘μ° - Difference between dependency and composition? β **[λ§ν¬](https://stackoverflow.com/questions/21022012/difference-between-dependency-and-composition)**
- μ€νμ€λ²νλ‘μ° - Implementation difference between Aggregation and Composition in Java β **[λ§ν¬](https://stackoverflow.com/questions/11881552/implementation-difference-between-aggregation-and-composition-in-java/12431359#12431359)**

# βκ³΅λΆ λ΄μ© μ λ¦¬

---

![main-qimg-5e179dad2321fbace5731c7d0b782337.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ab7cc348-c21d-4103-93af-cf7bc7607721/main-qimg-5e179dad2321fbace5731c7d0b782337.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230209%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230209T231724Z&X-Amz-Expires=86400&X-Amz-Signature=3d3a6244bb60e8c7bf4c7922c2618e4a7e017d4b9010f2b514b69be71e4efb28&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22main-qimg-5e179dad2321fbace5731c7d0b782337.png%22&x-id=GetObject)

## βis-a λ?

κ°μ²΄ μ§ν₯ μ€κ³ νλ‘κ·Έλλ°μμ μμμ κ΄κ³λ₯Ό νννλ ν€μλμ΄λ€.

> Car is a Vehicle
A is a B
>

μ°¨λ μ°¨λ ν κ²(μ΄μ‘ μλ¨)μ΄ λ  μ μλ€.

νμ§λ§ ν κ²(μ΄μ‘ μλ¨)μ μ°¨κ° λ  μ μλ€.

- Aλ μμ(λΆλͺ¨) ν΄λμ€,
  Bλ νμ(μμ) ν΄λμ€μ΄λ€.
- μ¬κΈ°μ a λ βνλμβ λΌλ μλ―Έκ° μλλΌ,
  ν¬κ² μλ―Έκ° μμ΄ μλ‘μ μΌλ‘ λΆλ λΆμ κ΄μ¬λ‘ λ³΄μΈλ€. β [**μ°Έκ³  λ§ν¬](https://www.englishcube.net/grammar_view.php?category2=86)**
  ex) My brother is a lawyer. λμ νμ λ³νΈμ¬μ΄λ€.

## βHas-a λ?

κ°μ²΄ μ§ν₯ μ€κ³ νλ‘κ·Έλλ°μμ κ΅¬μ±(Composition) κ΄κ³λ₯Ό νννλ ν€μλμ΄λ€.

> Car has a Engine
A has a B
>
- μλμ°¨λ μμ§μ κ°μ§κ³  μλ€.
- Aκ° λΆνμΌλ‘ Bλ₯Ό κ°μ§κ³  μλ€.
- μΊ‘μμ΄ λ€λ₯Έ μΊ‘μμ κ°μ²΄λ₯Ό κ°μ§κ³  μλ μν

has a κ΄κ³λ **κ΅¬μ±(Composition)**κ³Ό **μ§κ³(Aggregation)** λ κ°μ§λ‘ ν¬κ² λλλ€κ³  νλ€.

### κ΅¬μ±(Composition)

- κ΅¬μ±μ μμ κΆμ λνλΈλ€.
- κ΅¬μ± κ΄κ³λ μλ‘ κ°ν μμ‘΄ κ΄κ³λ₯Ό μ μ§νκ² λλ€.
- μ»΄ν¬μ§μμμ λ¨μΌ μμλ₯Ό μ­μ νλ©΄ μ°κ²°λ λ€λ₯Έ μμμ μν₯μ μ€λλ€.
    - μμ νλ κ°μ²΄κ° μλ©Έλλ©΄ ν¬ν¨λ κ°μ²΄λ μλ©Έλλ€.
- μμ : ν΄λ μμ νμΌμ΄ μμ΅λλ€.Β ν΄λλ₯Ό μ­μ νλ©΄ ν΄λΉ ν΄λμ κ΄λ ¨λ νμΌλ μ­μ λ©λλ€.

### μ§κ³(Aggregation)

- μ§κ³λ μ½ν μ°κ²° κ΄κ³λ₯Ό λνλΈλ€.
- μ°κ²°λ κ°μ²΄λ λ€λ₯Έ κ°μ²΄μ μ’μλμ§ μμ΅λλ€.
- λ¨μΌ μμλ₯Ό μ­μ ν΄λ μ°κ²°λ λ€λ₯Έ μμμλ μν₯μ λ―ΈμΉμ§ μμ΅λλ€.
- μμ : μλμ°¨μλ λ°ν΄κ° νμνμ§λ§ ν­μ κ°μ λ°ν΄κ° νμν κ²μ μλλλ€.Β 
μλμ°¨λ λ€λ₯Έ λ°ν΄λ‘λ μΆ©λΆν κΈ°λ₯ν  μ μμ΅λλ€.



κ°λμ λλ΅ μμμΌλ μμ μ½λλ₯Ό λ΄λ³΄μ.

### μμ μ½λ λ° μ λ¦¬(feat. Dependency)

```java
package org.example.week4.composition;

class Engine {
    public void work() { }
}

// Aggregation
class AggregationCar {
    private Engine engine;

    void setEngine(Engine engine) {
        this.engine = engine;
    }

    void move() {
        if (engine != null)
            engine.work();
    }
}

// Dependency
class DependencyCar {
    private Engine engine;

    // constructor
    public DependencyCar( Engine engine ) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return this.engine;
    }
    public void setAddress( Engine engine ) {
        this.engine = engine;
    }
}

// Composition
public class CompositionCar {
    private final Engine engine;

    public CompositionCar() {
        engine = new Engine();
    }

    void move() {
        engine.work();
    }
}
```

*κ³΅λΆλ₯Ό νλ€κ° Dependencyλ κ°μ΄ λμ€κΈΈλ κ°μ΄ μ λ¦¬λ₯Ό ν΄λ³΄μλ€.

- Dependency(μ’μμ±)
    - Engine κ°μ²΄λ₯Ό μΈλΆμμ κ°μ Έμ€κ³  Engine κ°μ²΄λ λ€λ₯Έ κ³³μ ν λΉ λμ΄ μλ€.
      μ¦, DependencyCar κ°μ²΄μ  Engine κ°μ²΄λ λ³λλ‘ μ‘΄μ¬νλ©° μλ‘μκ²λ§ μμ‘΄νλ€.
- Composition(κ΅¬μ±)
    - CompositionCar λ΄λΆμμ Engine κ°μ²΄κ° μμ±λλ€.
      μμ§ κ°μ²΄λ CompositionCarμ μΌλΆλΆμ΄λ€.
- Aggregation(μ§κ³)
    - AggregationCarλ μΈλΆμμ Engineμ κ°μ Έμ setEngine ν΄μ€μΌ νλ€.
    - AggregationCarμ Engineμ κ²°ν©λκ° λ?λ€.

## κΆκΈν μ 

- μμμ μ¬μ¬μ©μ κ°λμΌλ‘λ§ μ¬μ©νλ©΄ μλλ€?
    - μ½λλ₯Ό μ¬μ¬μ© ν  μ μλ€κ³  λ§μ΄ μ¬μ©νκ² λλ©΄ ν΄λμ€ κ°μ κ²°ν©λκ° λμμ§λ€.
      λΆλμ΄νκ² μμ ν΄λμ€λ₯Ό μμ ν΄μΌ ν  λ, νμ ν΄λμ€μ ν° μν₯μ λ―ΈμΉκ² λλ€.
    - μμμ IS-A κ΄κ³μμ μ¬μ©νλ κ±Έ κΆμ₯νλ€.