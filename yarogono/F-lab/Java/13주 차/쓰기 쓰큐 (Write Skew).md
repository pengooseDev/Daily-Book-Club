# 🔗 참고자료

---

- 지마켓 기술블로그 - 레거시 시스템의 성능과 정합성 두 마리 토끼 잡기 ⇒ [**링크**](https://dev.gmarket.com/44)
- chatGPT
- [데이터베이스] 트랜잭션 격리수준 ⇒ ****[링크](https://velog.io/@guswns3371/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B2%A9%EB%A6%AC%EC%88%98%EC%A4%80)****

# ✏공부 내용 정리

---

![img.png](https://file.notion.so/f/s/801af848-e3f7-41a2-a27b-1e3e83d68aac/img.png?id=98e4d921-f51e-4973-9b47-e4e1a7707d4c&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1681041150786&signature=RiNypa1hzh9K-A4EucjAwGxiS9V7RT96CnhD2RZaIOo&downloadName=img.png)

## ❓쓰기 쓰큐(Write Skew)란?

데이터베이스 트랜잭션에서 발생할 수 있는 문제 중 하나로, 다른 트랜잭션에 의해 동시에 업데이트되는 여러 테이블의 행을 변경하는 경우 발생한다.

- 이러한 상황에서는 각 트랜잭션이 동시에 작업을 수행하므로, 결과적으로 일관성이 없는 데이터가 발생할 수 있다.

## ❓쓰기 쓰큐(Write Skew)를 어떻게 방지할까?

데이터베이스 락(lock)을 사용하여 동시에 업데이트하는 것을 방지하거나, 트랜잭션 격리 수준을 높이는 방법 등이 있다.

- 각 수행에 포함한 트랜잭션의 격리 수준을 REPEATABLE READ 이상으로 올리면 간편하게 해결 된다고 한다.

## ❓DB lock과 트랜잭션의 격리 수준만 올려도 과연 해결이 될까?

격리 수준은 정합성과 성능의 트레이드오프를 갖는다.

더 정합적인 격리 수준은 성능을 낮춘다.

- REPEATABLE READ는 쓰기 쓰큐를 해결해 주지만 이 방식으로는 이벤트와 같은 트래픽이 몰리는 상황에서는 오히려 독이 된다.

## 궁금한 점