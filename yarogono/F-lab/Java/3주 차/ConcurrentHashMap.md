# 🔗 참고자료

---

- Tecoble - HashMap vs HashTable vs ConcurrentHashMap ⇒ [링크](https://tecoble.techcourse.co.kr/post/2021-11-26-hashmap-hashtable-concurrenthashmap/)
- ConcurrentHashMap 이란 무엇일까? ⇒ [링크](https://devlog-wjdrbs96.tistory.com/269)

# ✏공부 내용 정리

---

## ❓concurrentHashMap이란?

thread-safe하고 기존 HashMap의 동기화 문제를 보완하기 위해 나타났다.

## concurrentHashMap의 특징

- key와 value에 null을 허용하지 않는다.
- 동기화를 보장한다.
- 멀티 스레드 환경에서 사용 할 수 있도록 나온 클래스이다.
- JDK 1.5에 검색과 업데이트 시 동시성 성능을 높이기 위해서 나온 클래스입니다.
- HashMap, HashTable 클래스와 기능적으로는 큰 차이가 없다.

## 코드로 보기

```java
public class ConcurrentHashMap<K,V> extends AbstractMap<K,V>
    implements ConcurrentMap<K,V>, Serializable {

    public V get(Object key) {}

    public boolean containsKey(Object key) { }

    public V put(K key, V value) {
        return putVal(key, value, false);
    }

    final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null)))
                    break;                   // no lock when adding to empty bin
            }
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else {
                V oldVal = null;
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }
}
```

- ConcurrentHashMap 클래스의 일부 API
- ConcurrentHashMap에는 Hashtable과 다르게 synchronized 키워드가 메소드 전체에 붙어 있지 않습니다.
- get() 에는 synchronized가 없고, put() 중간에 synchronized 키워드가 존재한다.
    - 읽기 작업에는 여러 스레드가 동시에 읽을 수 있지만,
      쓰기 작업에는 특정 세그먼트 or 버킷에 대한 Lock을 사용한다는 것이다.
- 버킷의 수는 동시 작업 가능한 스레드의 수이다.
    - 버킷 단위로 Lock을 사용하기 때문에 같은 버킷만 아니라면 Lock을 기다릴 필요가 없다.
    - 버킷당 하나의 Lock을 가지고 있다.
- 여러 스레드에서 객체에 동시에 데이터를 삽입, 참조하더라도 그 데이터가 다른 세그먼트에 위치하면 서로 락을 얻기 위해 경쟁하지 않는다.

## 모르는 단어

- 세그먼트(segment)
    - 말그대로 분할을 의미하고 컴퓨터에서는 메모리 세그먼트(분할)을 의미한다.
    - 컴퓨터의 메모리를 세그먼트 또는 섹션으로 나누는 운영체제 메모리 관리 기술이다.
    - 프로세스는 세그먼트로 나뉜다.

# 공부하면서 느낀 점

---

concurrentHashMap은 더 깊게 공부해야 할 부분 같다.

우선 동시성 성능을 높이고 멀티 스레드 환경에서 HashTable 보다 안전하다는 것을 알았다.

너무 깊게 파고 들어가면 끝도 없을 것 같아서 다음에 또 보자.

다음에 볼 때 할 일

- 코드 직접 들여다보고 분석
- 가능하다면 직접 구현해보도록 노력
- concurrentHashMap이 어떻게 thread-safe한지 생각하고 글 작성
- 동시성 성능을 어떻게 높이는지 생각하고 글 작성