# ๐ ์ฐธ๊ณ ์๋ฃ

---

- Tecoble - HashMap vs HashTable vs ConcurrentHashMap โ [๋งํฌ](https://tecoble.techcourse.co.kr/post/2021-11-26-hashmap-hashtable-concurrenthashmap/)
- ConcurrentHashMap ์ด๋ ๋ฌด์์ผ๊น? โ [๋งํฌ](https://devlog-wjdrbs96.tistory.com/269)

# โ๊ณต๋ถ ๋ด์ฉ ์ ๋ฆฌ

---

## โconcurrentHashMap์ด๋?

thread-safeํ๊ณ  ๊ธฐ์กด HashMap์ ๋๊ธฐํ ๋ฌธ์ ๋ฅผ ๋ณด์ํ๊ธฐ ์ํด ๋ํ๋ฌ๋ค.

## concurrentHashMap์ ํน์ง

- key์ value์ null์ ํ์ฉํ์ง ์๋๋ค.
- ๋๊ธฐํ๋ฅผ ๋ณด์ฅํ๋ค.
- ๋ฉํฐ ์ค๋ ๋ ํ๊ฒฝ์์ ์ฌ์ฉ ํ  ์ ์๋๋ก ๋์จ ํด๋์ค์ด๋ค.
- JDK 1.5์ ๊ฒ์๊ณผ ์๋ฐ์ดํธ ์ ๋์์ฑ ์ฑ๋ฅ์ ๋์ด๊ธฐ ์ํด์ ๋์จ ํด๋์ค์๋๋ค.
- HashMap, HashTable ํด๋์ค์ ๊ธฐ๋ฅ์ ์ผ๋ก๋ ํฐ ์ฐจ์ด๊ฐ ์๋ค.

## ์ฝ๋๋ก ๋ณด๊ธฐ

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

- ConcurrentHashMap ํด๋์ค์ ์ผ๋ถ API
- ConcurrentHashMap์๋ Hashtable๊ณผ ๋ค๋ฅด๊ฒ synchronized ํค์๋๊ฐ ๋ฉ์๋ ์ ์ฒด์ ๋ถ์ด ์์ง ์์ต๋๋ค.
- get() ์๋ synchronized๊ฐ ์๊ณ , put() ์ค๊ฐ์ synchronized ํค์๋๊ฐ ์กด์ฌํ๋ค.
    - ์ฝ๊ธฐ ์์์๋ ์ฌ๋ฌ ์ค๋ ๋๊ฐ ๋์์ ์ฝ์ ์ ์์ง๋ง,
      ์ฐ๊ธฐ ์์์๋ ํน์  ์ธ๊ทธ๋จผํธ or ๋ฒํท์ ๋ํ Lock์ ์ฌ์ฉํ๋ค๋ ๊ฒ์ด๋ค.
- ๋ฒํท์ ์๋ ๋์ ์์ ๊ฐ๋ฅํ ์ค๋ ๋์ ์์ด๋ค.
    - ๋ฒํท ๋จ์๋ก Lock์ ์ฌ์ฉํ๊ธฐ ๋๋ฌธ์ ๊ฐ์ ๋ฒํท๋ง ์๋๋ผ๋ฉด Lock์ ๊ธฐ๋ค๋ฆด ํ์๊ฐ ์๋ค.
    - ๋ฒํท๋น ํ๋์ Lock์ ๊ฐ์ง๊ณ  ์๋ค.
- ์ฌ๋ฌ ์ค๋ ๋์์ ๊ฐ์ฒด์ ๋์์ ๋ฐ์ดํฐ๋ฅผ ์ฝ์, ์ฐธ์กฐํ๋๋ผ๋ ๊ทธ ๋ฐ์ดํฐ๊ฐ ๋ค๋ฅธ ์ธ๊ทธ๋จผํธ์ ์์นํ๋ฉด ์๋ก ๋ฝ์ ์ป๊ธฐ ์ํด ๊ฒฝ์ํ์ง ์๋๋ค.

## ๋ชจ๋ฅด๋ ๋จ์ด

- ์ธ๊ทธ๋จผํธ(segment)
    - ๋ง๊ทธ๋๋ก ๋ถํ ์ ์๋ฏธํ๊ณ  ์ปดํจํฐ์์๋ ๋ฉ๋ชจ๋ฆฌ ์ธ๊ทธ๋จผํธ(๋ถํ )์ ์๋ฏธํ๋ค.
    - ์ปดํจํฐ์ ๋ฉ๋ชจ๋ฆฌ๋ฅผ ์ธ๊ทธ๋จผํธ ๋๋ ์น์์ผ๋ก ๋๋๋ ์ด์์ฒด์  ๋ฉ๋ชจ๋ฆฌ ๊ด๋ฆฌ ๊ธฐ์ ์ด๋ค.
    - ํ๋ก์ธ์ค๋ ์ธ๊ทธ๋จผํธ๋ก ๋๋๋ค.

# ๊ณต๋ถํ๋ฉด์ ๋๋ ์ 

---

concurrentHashMap์ ๋ ๊น๊ฒ ๊ณต๋ถํด์ผ ํ  ๋ถ๋ถ ๊ฐ๋ค.

์ฐ์  ๋์์ฑ ์ฑ๋ฅ์ ๋์ด๊ณ  ๋ฉํฐ ์ค๋ ๋ ํ๊ฒฝ์์ HashTable ๋ณด๋ค ์์ ํ๋ค๋ ๊ฒ์ ์์๋ค.

๋๋ฌด ๊น๊ฒ ํ๊ณ  ๋ค์ด๊ฐ๋ฉด ๋๋ ์์ ๊ฒ ๊ฐ์์ ๋ค์์ ๋ ๋ณด์.

๋ค์์ ๋ณผ ๋ ํ  ์ผ

- ์ฝ๋ ์ง์  ๋ค์ฌ๋ค๋ณด๊ณ  ๋ถ์
- ๊ฐ๋ฅํ๋ค๋ฉด ์ง์  ๊ตฌํํด๋ณด๋๋ก ๋ธ๋ ฅ
- concurrentHashMap์ด ์ด๋ป๊ฒ thread-safeํ์ง ์๊ฐํ๊ณ  ๊ธ ์์ฑ
- ๋์์ฑ ์ฑ๋ฅ์ ์ด๋ป๊ฒ ๋์ด๋์ง ์๊ฐํ๊ณ  ๊ธ ์์ฑ