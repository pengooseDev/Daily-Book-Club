# ๐ ์ฐธ๊ณ ์๋ฃ

---

- geeksforgeeks - Introduction of B-Tree โ [**๋งํฌ**](https://www.geeksforgeeks.org/introduction-of-b-tree-2/?ref=gcse)
- geeksforgeeks - Introduction of B+Tree โ [**๋งํฌ**](https://www.geeksforgeeks.org/introduction-of-b-tree/?ref=gcse)
- ๊ทธ๋ฆผ์ผ๋ก ์์๋ณด๋ B+Tree โ [**๋งํฌ**](https://velog.io/@emplam27/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-B-Plus-Tree)
- ๋ง๋๊ธฐ ๊ฐ๋ฐ์ - [Database] ์ธ๋ฑ์ค(index)๋? โ [**๋งํฌ**](https://mangkyu.tistory.com/96)

# โ๊ณต๋ถ ๋ด์ฉ ์ ๋ฆฌ

---

![binary-tree-to-DLL.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b42bd865-8f9b-4295-9ed0-967d7fe3190b/binary-tree-to-DLL.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142353Z&X-Amz-Expires=86400&X-Amz-Signature=8cb6a8c3bddd785e7285c8bedc80d5f952933fbdf7bdf561d0fb58a7a9b8c1be&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22binary-tree-to-DLL.png%22&x-id=GetObject)

## ํธ๋ฆฌ(Tree)

- ๋ธ๋๋ค์ด ๋๋ฌด ๊ฐ์ง์ฒ๋ผ ์ฐ๊ฒฐ๋ ๋น์ ํ ๊ณ์ธต์  ์๋ฃ๊ตฌ์กฐ

![img.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/71e60a9f-b8d8-4c24-a239-43efdc555ae2/img.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142411Z&X-Amz-Expires=86400&X-Amz-Signature=ac7ba2498a6877284062429035a8842fa8448b12a03d81f81e2d871b32211dc3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22img.png%22&x-id=GetObject)

## B Tree(Balanced Tree)

- ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ํ์ผ ์์คํ์์ ๋๋ฆฌ ์ฌ์ฉ๋๋ ํธ๋ฆฌ ์๋ฃ๊ตฌ์กฐ์ ์ผ์ข
- ์ด์ง ํธ๋ฆฌ๋ฅผ ํ์ฅํด ํ๋์ ๋ธ๋๊ฐ ๊ฐ์ง ์ ์๋ ์์ ๋ธ๋์ ์ต๋ ์ซ์๊ฐ 2๋ณด๋ค ํฐ ํธ๋ฆฌ ๊ตฌ์กฐ์ด๋ค.
- ๋๋ถ๋ถ์ ์ด์ง ํธ๋ฆฌ๋ ํญ๋ชฉ์ด ์ฝ์ผ๋  ๋ ํํฅ์์ผ๋ก ๊ตฌ์ฑ๋๋ ๋ฐ ๋ฐํด, B-tree๋ ์ผ๋ฐ์ ์ผ๋ก ์ํฅ์์ผ๋ก ๊ตฌ์ฑ๋๋ค.
- B-Tree๋ ํนํ ํ๋ ๋๋ผ์ด๋ธ, ํ๋์ ๋ฉ๋ชจ๋ฆฌ, CD-ROM๊ณผ ๊ฐ์ด ๋๋ฆฌ๊ณ  ๋ถํผ๊ฐ ํฐ ๋ฐ์ดํฐ ์ก์ธ์ค๊ฐ ์๋ ์คํ ๋ฆฌ์ง ์์คํ์ ์ ํฉํฉ๋๋ค.

![Btree.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e495859e-098a-4125-bace-e10514e45d50/Btree.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142425Z&X-Amz-Expires=86400&X-Amz-Signature=fd980521c80d0dcfc0bcfcf8a70f974f52f8d47070bd93339891fd9453c7e6f2&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Btree.jpg%22&x-id=GetObject)

## B+ Tree

Bํธ๋ฆฌ์ ๊ต์ฅํ ์ ์ฌํ์ง๋ง ๋ฆฌํ๋ธ๋๋ ์ฐ๊ฒฐ๋ฆฌ์คํธ์ ํํ๋ฅผ ๋์ด ์ ํ ๊ฒ์์ด ๊ฐ๋ฅํ๋ค.

- Leaf node์๋ ๋ ์ฝ๋(๋๋ ์ด ๋ ์ฝ๋๋ฅผ ํฌํจํ๋ ๋ธ๋ก)์ ๋ํ ๋ฐ์ดํฐ ํฌ์ธํฐ์ ํจ๊ป ๊ฒ์ ํ๋์ ๋ชจ๋  ๊ฐ์ ๋ํ ํญ๋ชฉ์ด ์์ต๋๋ค.
- B ํธ๋ฆฌ์ ๋์กฐ์ ์ผ๋ก B+ํธ๋ฆฌ๋, ๋ชจ๋  ๋ ์ฝ๋๋ค์ด ํธ๋ฆฌ์ ๊ฐ์ฅ ํ์ ๋ ๋ฒจ์ ์ ๋ ฌ๋์ด์๋ค.
  ์ค์ง ํค๋ค๋ง์ด ๋ด๋ถ ๋ธ๋ก์ ์ ์ฅ๋๋ค.

### โDB์ ์ธ๋ฑ์ฑ์ B+ํธ๋ฆฌ๋ก ์ด๋ฃจ์ด์ ธ ์๋ค?

![images_emplam27_post_64290106-d927-4a82-9e08-8e52783c7dd3_DB ์ธ๋ฑ์ค.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7010a961-797b-4f07-9207-7434c94b7647/images_emplam27_post_64290106-d927-4a82-9e08-8e52783c7dd3_DB_%EC%9D%B8%EB%8D%B1%EC%8A%A4.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142441Z&X-Amz-Expires=86400&X-Amz-Signature=8af37c4f0897e384e3987366780ea1c4e236ecde376747aede36b5cdf2d76e53&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22images_emplam27_post_64290106-d927-4a82-9e08-8e52783c7dd3_DB%2520%25EC%259D%25B8%25EB%258D%25B1%25EC%258A%25A4.jpg%22&x-id=GetObject)

**์ ์ฌ์ง์ B+ํธ๋ฆฌ๋ก ๋ํ๋ด๋ฉด ์๋์ ๊ฐ๋ค.**

![images_emplam27_post_bcbce100-d475-4cda-aebe-946d1813949c_Bํ๋ฌ์ค ํธ๋ฆฌ ๊ธฐ๋ณธ ํํ.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e226c153-d191-414c-98db-3a75c8357a0c/images_emplam27_post_bcbce100-d475-4cda-aebe-946d1813949c_B%ED%94%8C%EB%9F%AC%EC%8A%A4_%ED%8A%B8%EB%A6%AC_%EA%B8%B0%EB%B3%B8_%ED%98%95%ED%83%9C.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142458Z&X-Amz-Expires=86400&X-Amz-Signature=5e9d33460af2d6aebecd051645b66081c40d77c17c686e59536e6635aa7b58c9&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22images_emplam27_post_bcbce100-d475-4cda-aebe-946d1813949c_B%25ED%2594%258C%25EB%259F%25AC%25EC%258A%25A4%2520%25ED%258A%25B8%25EB%25A6%25AC%2520%25EA%25B8%25B0%25EB%25B3%25B8%2520%25ED%2598%2595%25ED%2583%259C.jpg%22&x-id=GetObject)

### Bํธ๋ฆฌ์ B+ํธ๋ฆฌ์ ์ฐจ์ด์ 

1. ๋ชจ๋  Key, Data๊ฐ ๋ฆฌํ๋ธ๋์ ๋ชจ์ฌ ์๋ค.
    - Bํธ๋ฆฌ๋ ๋ฆฌํ๋ธ๋๊ฐ ์๋ ๊ฐ์ Key๋ง๋ค data๋ฅผ ๊ฐ์ง๋ค๋ฉด,
      B+ํธ๋ฆฌ๋ ๋ฆฌํ ๋ธ๋์ ๋ชจ๋  Data๋ฅผ ๊ฐ์ง๋ค.
2. ๋ชจ๋  ๋ฆฌํ ๋ธ๋๊ฐ ์ฐ๊ฒฐ ๋ฆฌ์คํธ์ ํํ๋ฅผ ๋๊ณ  ์๋ค.
    - Bํธ๋ฆฌ๋ ์์ ์๋ ๋ฆฌํ๋ธ๋๋ฅผ ๊ฒ์ฌํ  ๋, ๋ค์ ๋ฃจํธ ๋ธ๋๋ถํฐ ๊ฒ์ฌํด์ผ ํ๋ค๋ฉด,
      B+ํธ๋ฆฌ๋ ๋ฆฌํ๋ธ๋์์ ์ ํ๊ฒ์ฌ๋ฅผ ์ํํ  ์ ์์ด ์๊ฐ๋ณต์ก๋๊ฐ ๊ต์ฅํ ์ค์ด๋ญ๋๋ค.
3. ๋ฆฌํ๋ธ๋์ ๋ถ๋ชจ Key๋ ๋ฆฌํ๋ธ๋์ ์ฒซ๋ฒ์งธ Key๋ณด๋ค ์๊ฑฐ๋ ๊ฐ์ต๋๋ค.
