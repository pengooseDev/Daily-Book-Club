# 🔗 참고자료

---

- 책 <스프링 입문을 위한 자바 객체 지향의 원리와 이해> 115p
- 위키피디아 - Is-a ⇒ [**링크**](https://en.wikipedia.org/wiki/Is-a)
- 위키피디아 - Has-a ⇒ [**링크**](https://en.wikipedia.org/wiki/Has-a)
- Quora - What is Is-a and Has-a means in Java? ⇒ **[링크](https://www.quora.com/What-is-Is-a-and-Has-a-means-in-Java)**
- 뉴렉처 - 자바 객체지향 강의 12강 - Has A 상속 ⇒ [**링크**](https://www.youtube.com/watch?v=6wKyPg9rxtw&ab_channel=%EB%89%B4%EB%A0%89%EC%B2%98)
- javaTpoint - Composition in Java ⇒ [**링크**](https://www.javatpoint.com/composition-in-java)
- javaTpoint - Aggregation in Java ****⇒ [**링크**](https://www.javatpoint.com/aggregation-in-java)
- Guru99 - Difference Between Aggregation and Composition in UML ⇒ [**링크**](https://www.guru99.com/uml-aggregation-vs-composition.html)
- 스택오버플로우 - Difference between dependency and composition? ⇒ **[링크](https://stackoverflow.com/questions/21022012/difference-between-dependency-and-composition)**
- 스택오버플로우 - Implementation difference between Aggregation and Composition in Java ⇒ **[링크](https://stackoverflow.com/questions/11881552/implementation-difference-between-aggregation-and-composition-in-java/12431359#12431359)**

# ✏공부 내용 정리

---

![main-qimg-5e179dad2321fbace5731c7d0b782337.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ab7cc348-c21d-4103-93af-cf7bc7607721/main-qimg-5e179dad2321fbace5731c7d0b782337.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230209%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230209T231724Z&X-Amz-Expires=86400&X-Amz-Signature=3d3a6244bb60e8c7bf4c7922c2618e4a7e017d4b9010f2b514b69be71e4efb28&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22main-qimg-5e179dad2321fbace5731c7d0b782337.png%22&x-id=GetObject)

## ❓is-a 란?

객체 지향 설계 프로그래밍에서 상속의 관계를 표현하는 키워드이다.

> Car is a Vehicle
A is a B
>

차는 차량 탈 것(운송 수단)이 될 수 있다.

하지만 탈 것(운송 수단)은 차가 될 수 없다.

- A는 상위(부모) 클래스,
  B는 하위(자식) 클래스이다.
- 여기서 a 는 ‘하나의’ 라는 의미가 아니라,
  크게 의미가 없이 의례적으로 붙는 부정관사로 보인다. ⇒ [**참고 링크](https://www.englishcube.net/grammar_view.php?category2=86)**
  ex) My brother is a lawyer. 나의 형은 변호사이다.

## ❓Has-a 란?

객체 지향 설계 프로그래밍에서 구성(Composition) 관계를 표현하는 키워드이다.

> Car has a Engine
A has a B
>
- 자동차는 엔진을 가지고 있다.
- A가 부품으로 B를 가지고 있다.
- 캡슐이 다른 캡슐의 객체를 가지고 있는 상태

has a 관계는 **구성(Composition)**과 **집계(Aggregation)** 두 가지로 크게 나눈다고 한다.

### 구성(Composition)

- 구성은 소유권을 나타낸다.
- 구성 관계는 서로 강한 의존 관계를 유지하게 된다.
- 컴포지션에서 단일 요소를 삭제하면 연결된 다른 요소에 영향을 줍니다.
    - 소유하는 객체가 소멸되면 포함된 객체도 소멸된다.
- 예시 : 폴더 안에 파일이 있습니다. 폴더를 삭제하면 해당 폴더와 관련된 파일도 삭제됩니다.

### 집계(Aggregation)

- 집계는 약한 연결 관계를 나타낸다.
- 연결된 개체는 다른 개체에 종속되지 않습니다.
- 단일 요소를 삭제해도 연결된 다른 요소에는 영향을 미치지 않습니다.
- 예시 : 자동차에는 바퀴가 필요하지만 항상 같은 바퀴가 필요한 것은 아닙니다. 
자동차는 다른 바퀴로도 충분히 기능할 수 있습니다.



개념은 대략 알았으니 예시 코드를 봐보자.

### 예시 코드 및 정리(feat. Dependency)

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

*공부를 하다가 Dependency도 같이 나오길래 같이 정리를 해보았다.

- Dependency(종속성)
    - Engine 객체를 외부에서 가져오고 Engine 객체는 다른 곳에 할당 되어 있다.
      즉, DependencyCar 객체와  Engine 객체는 별도로 존재하며 서로에게만 의존한다.
- Composition(구성)
    - CompositionCar 내부에서 Engine 객체가 생성된다.
      엔진 객체는 CompositionCar의 일부분이다.
- Aggregation(집계)
    - AggregationCar는 외부에서 Engine을 가져와 setEngine 해줘야 한다.
    - AggregationCar와 Engine의 결합도가 낮다.

## 궁금한 점

- 상속을 재사용의 개념으로만 사용하면 안된다?
    - 코드를 재사용 할 수 있다고 많이 사용하게 되면 클래스 간의 결합도가 높아진다.
      부득이하게 상위 클래스를 수정해야 할 때, 하위 클래스에 큰 영향을 미치게 된다.
    - 상속은 IS-A 관계에서 사용하는 걸 권장한다.