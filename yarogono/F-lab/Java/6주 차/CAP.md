# 🔗 참고자료

---

- IBM - CAP 정리 ⇒ [**링크**](https://www.ibm.com/kr-ko/cloud/learn/cap-theorem)
- Wikipedia - CAP theorem ⇒ **[링크](https://en.wikipedia.org/wiki/CAP_theorem)**
- 위키백과 - CAP 정리 ⇒ [**링크**](https://ko.wikipedia.org/wiki/CAP_%EC%A0%95%EB%A6%AC)
- 유튜브 채널 <IBM Technology> - What is CAP Theorem? ⇒ [**링크**](https://www.youtube.com/watch?v=eWMgsk7mpFc)

# ✏공부 내용 정리

---

![CapImage.07cc2b7.dd8b935c30da4454e015c7f8d2451c9c.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1dab9a0b-026b-4637-8d90-488e46299e46/CapImage.07cc2b7.dd8b935c30da4454e015c7f8d2451c9c.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230218%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230218T130830Z&X-Amz-Expires=86400&X-Amz-Signature=8858c9231bc04c90614a83c2a775e8f5cabc718c2e2e417f84af2fcf59a6d9c0&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22CapImage.07cc2b7.dd8b935c30da4454e015c7f8d2451c9c.png%22&x-id=GetObject)

## ❓CAP란?

네트워크로 연결된 분산된 데이터베이스 시스템은 일관성(Consistency), 가용성(Availability), 분할 내구성(Partition Tolerance)의 3가지 특성 중 2가지 특성만을 충족할 수 있고 3가지를 모두 충족할 수 없다는 이론

## 일관성(Consistency)

- 모든 노드가 같은 순간에 같은 데이터를 볼 수 있다.
    - 이러한 상황이 발생하려면, 데이터가 하나의 노드에 기록될 때마다 데이터는 쓰기가 ‘성공’으로 간주되기 전에 시스템의 다른 모든 노드로 즉시 전달되거나 복제되어야 한다.

## 가용성(Availability)

- 모든 요청이 성공 또는 실패 결과를 반환할 수 있다.
- 하나 이상의 노드가 작동 중지된 경우에도 데이터를 요청하는 클라이언트가 응답을 받음을 의미
    - 분산 시스템의 모든 작업 중인 노드는 예외 없이 모든 요청에 대해 유효한 응답을 리턴한다.

## 분할내성(Partition tolerance)

- 메시지 전달이 실패하거나 시스템 일부가 망가져도 시스템이 계속 동작할 수 있다.
