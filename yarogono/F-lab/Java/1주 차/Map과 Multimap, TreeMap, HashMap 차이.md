# 🔗 참고자료

- 블로그 <개발 잡학사전> Map/HashMap/TreeMap/Hashtable 차이점 ⇒ [**링크**](https://genie247.tistory.com/entry/MapHashMapTreeMapHashtable-%EC%B0%A8%EC%9D%B4%EC%A0%90)
- 블로그 <코딩팩토리> 자바 TreeMap 사용법 & 예제 총정리 ⇒ [**링크**](https://coding-factory.tistory.com/557)
- AbstractMAp, HashMap ⇒ [**링크**](https://sup2is.github.io/2019/09/30/abstractmap-hashmap.html)
- Naver D2 Java HashMap은 어떻게 동작하는가? ⇒ [**링크**](https://d2.naver.com/helloworld/831311)

# 내용

### ❓ Map이란

- Key와 Value 한 쌍으로 이루어진 자료형이다.
- Map은 리스트나 배열처럼 순차적으로 해당 요소 값을 구하지 않고 Key를 통해 Value를 얻는다.
- 값(Value)은 중복될 수 있지만, Key는 고유한 값(Unique)을 가져야 한다.
- 한 개의 Key에 한 개의 Value가 매칭된다.

### ❓ Multimap이란

- Map과는 달리 Key의 중복이 허용합니다.
- Multimap은 중복이 허락된다는 점을 제외하고는 Map과 동일하다.

### ❓ TreeMap이란

- 이진트리를 기반으로 한 Map 컬렉션이다.
- TreeMap은 키와 값이 저장된 Map, Entry를 저장한다.
- 저장하면서 키를 정렬한다.
    - 정렬 순서 : “숫자 > 알파벳 대문자 > 알파벳 소문자 > 한글” 순이다.
    - 위 순서는 String과 같은 문자열이 저장되는 순서를 말하는 것이다.
    - 객체가 저장되거나, 숫자가 저장될 때에는 그 순서가 달라진다.
- TreeMap을 이용하여 보관하여 처리할 때에는 HashMap보다는 느리다.
    - 키가 정렬되기 때문이다.
      하지만 100건, 1000건 정도의 데이터를 처리하고, 정렬을 해야 할 필요가 있다면,
      HashMap 보다는 TreeMap을 사용하는 것이 더 유리하다.

### ❓ HashMap이란

- AbstractMap이라는 abstract 클래스를 확장했다.
    - 대부분의 주요 메소드는 AbstractMap 클래스가 구현해 놓았다.
- HashMap에 객체가 들어가면 hashCode() 메소드의 결과 값에 따른 버켓(bucket) 이라는 목록 형태의 바구니가 만들어진다.
    - 만약 서로 다른 키가 저장되었는데, hashCode() 메소드의 결과가 동일하다면, 이 버켓에 여러 개의 값이 들어갈 수 있다.
- Key 또는 Value 값으로써 null을 허용한다.
    - 하지만 HashMap이 여러 개의 null key를 가질 수 없다.
      하나의 null key와 여러 개의 null Value를 저장할 수 있다.

**❓  HashMap이 null을 허용하는 이유는?**

-

## 공부하면서 느낀 점

Map에 대한 개념을 책으로 읽기는 했지만, 코드를 직접 들여다 본 적이 없었습니다.  
개념을 학교 다닐 때 시험 공부를 하듯이 했던 것 같다.  
위 지식이 진짜 내 것이 되기 위해서는 끊임없이 고민하고 ‘왜?’를 나 자신에게 던져야 한다는 것을 느꼈습니다.  
위에 작성한 Map에 대한 개념도 너무 급조해서 작성한 것이고 아직 부족하다고 생각합니다.  
더 고민해보고 코드로 작성해보고 진정한 내 것으로 만들 것 입니다.  