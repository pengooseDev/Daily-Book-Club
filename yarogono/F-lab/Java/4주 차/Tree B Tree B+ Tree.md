# 🔗 참고자료

---

- geeksforgeeks - Introduction of B-Tree ⇒ [**링크**](https://www.geeksforgeeks.org/introduction-of-b-tree-2/?ref=gcse)
- geeksforgeeks - Introduction of B+Tree ⇒ [**링크**](https://www.geeksforgeeks.org/introduction-of-b-tree/?ref=gcse)
- 그림으로 알아보는 B+Tree ⇒ [**링크**](https://velog.io/@emplam27/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-B-Plus-Tree)
- 망나기 개발자 - [Database] 인덱스(index)란? ⇒ [**링크**](https://mangkyu.tistory.com/96)

# ✏공부 내용 정리

---

![binary-tree-to-DLL.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b42bd865-8f9b-4295-9ed0-967d7fe3190b/binary-tree-to-DLL.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142353Z&X-Amz-Expires=86400&X-Amz-Signature=8cb6a8c3bddd785e7285c8bedc80d5f952933fbdf7bdf561d0fb58a7a9b8c1be&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22binary-tree-to-DLL.png%22&x-id=GetObject)

## 트리(Tree)

- 노드들이 나무 가지처럼 연결된 비선형 계층적 자료구조

![img.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/71e60a9f-b8d8-4c24-a239-43efdc555ae2/img.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142411Z&X-Amz-Expires=86400&X-Amz-Signature=ac7ba2498a6877284062429035a8842fa8448b12a03d81f81e2d871b32211dc3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22img.png%22&x-id=GetObject)

## B Tree(Balanced Tree)

- 데이터베이스와 파일 시스템에서 널리 사용되는 트리 자료구조의 일종
- 이진 트리를 확장해 하나의 노드가 가질 수 있는 자식 노드의 최대 숫자가 2보다 큰 트리 구조이다.
- 대부분의 이진 트리는 항목이 삽일될 때 하향식으로 구성되는 데 반해, B-tree는 일반적으로 상향식으로 구성된다.
- B-Tree는 특히 하드 드라이브, 플래시 메모리, CD-ROM과 같이 느리고 부피가 큰 데이터 액세스가 있는 스토리지 시스템에 적합합니다.

![Btree.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e495859e-098a-4125-bace-e10514e45d50/Btree.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142425Z&X-Amz-Expires=86400&X-Amz-Signature=fd980521c80d0dcfc0bcfcf8a70f974f52f8d47070bd93339891fd9453c7e6f2&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Btree.jpg%22&x-id=GetObject)

## B+ Tree

B트리와 굉장히 유사하지만 리프노드는 연결리스트의 형태를 띄어 선형 검색이 가능하다.

- Leaf node에는 레코드(또는 이 레코드를 포함하는 블록)에 대한 데이터 포인터와 함께 검색 필드의 모든 값에 대한 항목이 있습니다.
- B 트리와 대조적으로 B+트리는, 모든 레코드들이 트리의 가장 하위 레벨에 정렬되어있다.
  오직 키들만이 내부 블록에 저장된다.

### ❓DB의 인덱싱은 B+트리로 이루어져 있다?

![images_emplam27_post_64290106-d927-4a82-9e08-8e52783c7dd3_DB 인덱스.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7010a961-797b-4f07-9207-7434c94b7647/images_emplam27_post_64290106-d927-4a82-9e08-8e52783c7dd3_DB_%EC%9D%B8%EB%8D%B1%EC%8A%A4.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142441Z&X-Amz-Expires=86400&X-Amz-Signature=8af37c4f0897e384e3987366780ea1c4e236ecde376747aede36b5cdf2d76e53&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22images_emplam27_post_64290106-d927-4a82-9e08-8e52783c7dd3_DB%2520%25EC%259D%25B8%25EB%258D%25B1%25EC%258A%25A4.jpg%22&x-id=GetObject)

**위 사진을 B+트리로 나타내면 아래와 같다.**

![images_emplam27_post_bcbce100-d475-4cda-aebe-946d1813949c_B플러스 트리 기본 형태.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e226c153-d191-414c-98db-3a75c8357a0c/images_emplam27_post_bcbce100-d475-4cda-aebe-946d1813949c_B%ED%94%8C%EB%9F%AC%EC%8A%A4_%ED%8A%B8%EB%A6%AC_%EA%B8%B0%EB%B3%B8_%ED%98%95%ED%83%9C.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142458Z&X-Amz-Expires=86400&X-Amz-Signature=5e9d33460af2d6aebecd051645b66081c40d77c17c686e59536e6635aa7b58c9&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22images_emplam27_post_bcbce100-d475-4cda-aebe-946d1813949c_B%25ED%2594%258C%25EB%259F%25AC%25EC%258A%25A4%2520%25ED%258A%25B8%25EB%25A6%25AC%2520%25EA%25B8%25B0%25EB%25B3%25B8%2520%25ED%2598%2595%25ED%2583%259C.jpg%22&x-id=GetObject)

### B트리와 B+트리의 차이점

1. 모든 Key, Data가 리프노드에 모여 있다.
    - B트리는 리프노드가 아닌 각자 Key마다 data를 가진다면,
      B+트리는 리프 노드에 모든 Data를 가진다.
2. 모든 리프 노드가 연결 리스트의 형태를 띄고 있다.
    - B트리는 옆에 있는 리프노드를 검사할 때, 다시 루트 노드부터 검사해야 한다면,
      B+트리는 리프노드에서 선형검사를 수행할 수 있어 시간복잡도가 굉장히 줄어듭니다.
3. 리프노드의 부모 Key는 리프노드의 첫번째 Key보다 작거나 같습니다.
