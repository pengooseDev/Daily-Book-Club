# 🔗 참고자료

---

- geeksforgeeks - Introduction to Red-Black Tree ⇒ [**링크**](https://www.geeksforgeeks.org/introduction-to-red-black-tree/)
- 위키피디아 - Red black tree ⇒ [**링크**](https://en.wikipedia.org/wiki/Red%E2%80%93black_tree)
- 유튜브 쉬운코드 ⇒ [**링크**](https://www.youtube.com/watch?v=2MdsebfJOyM&ab_channel=%EC%89%AC%EC%9A%B4%EC%BD%94%EB%93%9C)
- Red/Black Tree visualization ⇒ **[링크](https://www.cs.usfca.edu/~galles/visualization/RedBlack.html)**

# ✏공부 내용 정리

---

![Red-black_tree_example.svg.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c0cc6f53-5351-4a04-a522-462ab41e9598/Red-black_tree_example.svg.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142532Z&X-Amz-Expires=86400&X-Amz-Signature=235dcb8ff556aab4ce13a454f39d86b41358646253832dbae0819d8cf08978bf&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Red-black_tree_example.svg.png%22&x-id=GetObject)

## ❓Red Black Tree란?

이진 트리의 특수한 형태로서, 숫자 등의 비교 가능한 자료를 정리하는 데 쓰이는 자료구조이다.

기존 이진 트리와는 다르게 리프 노드들은 비어 있고, 자료를 가지고 있지 않다.

## 용도와 장점

- 자료와 삽입과 삭제, 검색에서 최악의 경우에도 일정한 실행 시간을 보장한다.
    - 이는 실시간 처리와 같은 실행시간이 중요한 경우에 유용하게 쓰일 뿐만 아니라, 일정한 실행 시간을 보장하는 또 다른 자료구조를 만드는 데에도 쓸모가 있다.
- 레드 블랙 트리는 함수형 프로그래밍에서 특히 유용한데, 함수형 프로그래밍에서 쓰이는 연관 배열이나 집합(set)등을 내부적으로 레드 블랙 트리로 구현해 놓은 경우가 많다.
- 스스로 균형 잡는 트리이면서 AVL 트리보다는 덜 균형하다.
