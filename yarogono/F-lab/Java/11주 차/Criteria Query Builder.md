# 🔗 참고자료

---

- chatGPT
- Baeldung - JPA Criteria Queries ⇒ [**링크**](https://www.baeldung.com/hibernate-criteria-queries)


# ✏공부 내용 정리

---

## ❓Criteria Query Builder란?

JPQL을 자바 코드로 작성하도록 도와주는 객체 지향 쿼리 빌더 클래스 API입니다.

- 쿼리를 자바 코드로 제어 할 수 있습니다.
- JPA에서 표준으로 제공해주는 기능이다.

## Criteria Query Builder의 장, 단점

### 장점

- 쿼리문을 하드코딩 하는 것을 방지 할 수 있다.
    - JPQL로 하드코딩으로 작성되어 생기던 문제 방지
- 객체 지향 프로그래밍에 가깝게 코딩 할 수 있다.

### 단점

- 타입 검증을 런타임 시점에서 수행해서 컴파일러가 오타나 잘못된 타입을 검증할 수 없다.
    - 런타임에 타입 검증을 수행한다.
    - 잘못된 타입이나 변수명을 사용하는 경우에는 런타임 오류가 발생 할 수 있다.
    - 예시 코드

        ```java
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user);
        query.where(builder.equal(user.get("name"), "John"));
        List<User> users = entityManager.createQuery(query).getResultList();
        ```

        - 위 코드에서 user.get() 부분을 보면 User엔티티의 ‘name’ 필드를 가져올려고 하고 있다.
          여기서 ‘name’ 대신에 ‘Name’이나 ‘names’와 같이 오타를 내면 런타임 오류가 발생한다.
- 코드의 가독성이 떨어진다.

Criteria Query Builder을 공부하면서 QueryDSL과 비교 할 수 밖에 없었다.

타입안정성, 코드의 가독성 및 직관성, 유지보수성 등 대부분이 QueryDSL에 비해 부족한 것 같다.

장점이라고 하면 QueryDSL을 적용하기 위해서는 따로 설정을 해야하지만,

Criteria Query Builder는 JPA에 해당 기능이 포함되어 있다는 것이다.

## 궁금한 점

- QueryDSL과 차이점은 무엇일까?
    - QueryDSL이 보편적으로 많이 사용 되는 것 같은데 왜 그럴까?