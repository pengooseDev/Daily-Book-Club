# 🔗 참고자료

---

- chatGPT
- Baeldung - Intro to Querydsl ⇒ [**링크**](https://www.baeldung.com/intro-to-querydsl)

# ✏공부 내용 정리

---

## ❓QueryDSL이란?

자바 언어 기반의 라이브러리로, 객체 지향 방식으로 데이터베이스 쿼리를 작성할 수 있도록 지원하는 프레임워크이다.

## ❓QueryDSL을 왜 사용할까?

- 기존의 SQL 쿼리문 문제 해결
    - 문자열로 작성해야 하기 때문에 컴파일 단계에서 오류를 확인하기 어렵고 가독성이 떨어지는 문제
    - 문자열 SQL문 작성 시 오타가 발생할 확률이 높고, 이런 에러는 런타임 환경에서 발생하는 문제가 있었다.
- QueryDSL은 **자바 코드**로 작성해서 컴파일 시점에서 오류를 잡을 수 있을 확률이 높고,
  **객체 지향적**으로 코드를 작성해 **가독성**과 **유지 보수성**을 높일 수 있다.

## ❓QueryDSL을 사용해서 해결할 수 있는 문제들은?

- 동적 쿼리 생성
    - 기존에 동적 쿼리를 작성 할 때는 직접 if문을 통해 분기 처리를 진행하면서 쿼리문을 조합했다. 간단한 로직도 코드가 너무 길어지는 문제와 복잡도가 높아지는게 있었는데, QueryDSL은 자바 코드로 보다 쉽게 해결이 가능하다 ⇒ [**참고 링크**](https://jojoldu.tistory.com/394)(이동욱, 향로님 블로그)
- **타입 안정성(Type Safe)**
    - 자바 코드로 작성을 하기 때문에 타입 안정성이 보장된다.
- 복잡한 조건절 처리
    - 여러 개의 조건절을 조합하거나, 서브쿼리를 사용하는 등의 복잡한 쿼리도 처리할 수 있다.
- 대부분의 데이터베이스 지원

## ❓Criteria Query API와 차이점은?

Criteria Query API도 QueryDSL과 같이 자바로 쿼리를 작성할 수 있는 쿼리 빌더이다.

하지만 QueryDSL보다는 사용하는 곳이 확실히 적은 것 같다.

(배달의 민족이라는 회사에서도 QueryDSL을 사용하고 있다고 한다.)

```java
EntityManager em = ...;
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Pet> cq = cb.createQuery(Pet.class);
Root<Pet> pet = cq.from(Pet.class);
cq.select(pet);
TypedQuery<Pet> q = em.createQuery(cq);
List<Pet> allPets = q.getResultList();
```

위 예시 코드를 보면 Criteria Query API는 ‘SELECT p FROM Pet p’ 를 하는데도 많은 라인수의 코드를 작성해야 한다.

**발생할 수 있는 문제점들**

- 코드 라인수가 많아서 **가독성**이 떨어진다.
    - 쿼리가 작성된 코드 중간에 다른 로직의 코드가 들어간다면, 가독성은 더욱 떨어질 것 같다.
- SELECT문은 쿼리문으로 한 줄 작성하면 되는데, 쿼리문은 보다 많이 코드를 작성해야 한다.

QueryDSL은 위와 같은 문제점을 보완했기 때문에 더욱 많이 사용되고 있다고 생각합니다.

### 정리

QueryDSL은 유연성과 가독성, 표현력이 뛰어나며 IDE에서도 지원되어 개발자들에게 사용이 용이하다. 반면 Criteria Query API는 기본적인 연산자만 지원하지만, JPA에 내장되어 있기 때문에 추가적인 라이브러리를 다운로드 할 필요가 없습니다.

## 궁금한 점

- N+1 문제란?
    - 일반적으로 ORM 프레임워크에서 발생하는 문제로 연관된 엔티티를 조회할 때 연관된 엔티티의 수만큼 추가적인 쿼리가 발생하는 문제
    - fetch join이라는 기능을 제공하여 N+1 문제를 해결 할 수 있다.
        - fetch join은 연관된 엔티티를 함께 조회할 때 사용하는 기능입니다.
    - **예시 코드 보기**

        ```java
        QOrder order = QOrder.order;
        QMember member = QMember.member;
        QProduct product = QProduct.product;
        
        List<Order> orders = queryFactory
            .selectFrom(order)
            .join(order.member, member)
            .join(order.orderLines, orderLine)
            .join(orderLine.product, product)
            .where(member.name.eq("홍길동"))
            .fetchJoin()
            .fetch();
        ```