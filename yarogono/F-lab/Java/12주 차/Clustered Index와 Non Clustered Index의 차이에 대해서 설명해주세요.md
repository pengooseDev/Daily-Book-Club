# 🔗 참고자료

---

- chatGPT
- MS Docs ⇒ [**링크**](https://learn.microsoft.com/ko-kr/sql/relational-databases/indexes/clustered-and-nonclustered-indexes-described?view=sql-server-ver16)
- Clustered vs. Nonclustered Index Structures in SQL Server ⇒ [**링크**](https://www.youtube.com/watch?v=ITcOiLSfVJQ&ab_channel=VoluntaryDBA)
- RealMySQL - 8.8 클러스터링 인덱스(270p)

# ✏공부 내용 정리

---

## Clustered Index와 Non Clustered Index의 차이

클러스터형 인덱스는 테이블 자체를 키-값(Key-Value) 기준으로 정렬하여 저장하는 인덱스이고,
비클러스터형 인덱스는 따로 정렬되지 않은 인덱스입니다.

## ❓Clustered Index(클러스터형 인덱스)란?

- 테이블의 레코드를 특정 필드에 따라 정렬된 상태로 저장하는 인덱스
- 따라서 테이블당 하나의 클러스터형 인덱스만 가질 수 있다.
- 클러스터형 인덱스는 검색 성능이 뛰어나지만, 레코드를 삽입, 삭제, 갱신할 때 성능 저하가 발생할 수 있다.
    - 예를 들어, 고객 테이블에서 주문일 필드를 기준으로 클러스터형 인덱스를 생성하면 주문일을 기준으로 검색할 때 성능이 좋아진다.

## ❓Non Clustered Index(비클러스터형 인덱스)란?

- 테이블의 레코드를 정렬하지 않고 인덱스를 생성하는 것
- 비클러스터형 인덱스는 테이블당 여러 개의 인덱스를 가질 수 있다
- 비클러스터형 인덱스는 레코드를 삽입, 삭제, 갱신할 때에도 성능이 뛰어나지만, 클러스터드 인덱스보다 검색 성능이 떨어진다.
    - 예를 들어, 고객 테이블에서 성별 필드를 기준으로 Non-Clustered Index를 생성하면 성별을 기준으로 검색할 때 성능이 좋아진다.

## 궁금한 점