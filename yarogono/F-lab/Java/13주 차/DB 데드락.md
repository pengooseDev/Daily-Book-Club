# 🔗 참고자료

---

- chatGPT
- 위키피디아 ⇒ [**링크**](https://ko.wikipedia.org/wiki/%EA%B5%90%EC%B0%A9_%EC%83%81%ED%83%9C)
- geeksforgeeks - Deadlock in DBMS ⇒ [**링크**](https://www.geeksforgeeks.org/deadlock-in-dbms/)
- 데이터베이스의 데드락과 해결방법 | deadlock ⇒ [**링크**](https://www.youtube.com/watch?v=5yobcvhMV2M&ab_channel=%ED%81%B0%EB%8F%8C%EC%9D%98%ED%84%B0%EC%A0%84)

# ✏공부 내용 정리

---

![185b4067883325287.jpg](https://file.notion.so/f/s/34fb473c-56b8-4678-90d8-12bb792aedb5/185b4067883325287.jpg?id=c7b5f26c-ba9d-4b12-a117-be2fe2d9f48e&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1680955139890&signature=3Ll5L1ZoXytRaw-ebhPU0AZXmgKHtb9lmhVxR2vbYk4&downloadName=185b4067883325287.jpg)

### 데드락이란? ⇒ [(예전에 정리한)링크](https://www.notion.so/2a03a3fb65504e47a6169441d2b5b4c3)

## DB 데드락

데이터베이스에서 트랜잭션이 서로 다른 트랜잭션의 작업 결과를 기다리는 경우 발생한다.

- 모든 트랜잭션이 무한정 기다리게 되면, 이를 해결할 수 없는 상태가 되며, 이 상태를 DB 데드락이라고 한다.
- 각각의 트랜잭션이 서로 상대방이 가진 락(lock)을 획득하지 못하면서 대기하는 상황이 발생한다.

## ❓InnoDB 스토리지 엔진은 자동 데드락 감지가 있다?

- InnoDB 스토리지 엔진은 내부적으로 잠금이 교착 상태에 빠지지 않았는지 체크하기 위해 잠금 대기 목록을 그래프(Wait-for List) 형태로 관리한다.
- InnoDB 스토리지 엔진은 데드락 감지 스레드를 가지고 있어서 데드락 감지 스레드가 주기적으로 잠금 대기 그래프를 검사해 교착 상태에 빠진 트랜잭션들을 찾아서 그중 하나를 강제 종료한다.
    - 이때 어느 트랜잭션을 먼저 강제 종료할 것인지를 판단하는 기준은 트랜잭션의 **언두 로그** 양이며, 언두 로그 레코드를 더 적게 가진 트랜잭션이 일반적으로 **롤백**의 대상이 된다.
    - 언두 레코드를 적게 가졌다는 것은 롤백을 해도 언두 처리를 해야 할 내용이 적다는 것이며,
      트랜잭션 강제 롤백으로 인한 MySQL 서버의 부하도 덜 유발하기 때문이다.

### DB 데드락을 방지하는 방법

- lock wait timeout 설정
- 데드락 검출(deadlock detection)
- 락 해제(lock release)
