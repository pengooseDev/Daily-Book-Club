# ๐ ์ฐธ๊ณ ์๋ฃ

---

- ์คํ๋ง ์์ฒญ์ฒ๋ฆฌ ๋ด๋ถ๊ตฌ์กฐ โ ****[๋งํฌ](https://gowoonsori.com/spring/architecture/)****
- Spring MVC ๊ณต์๋ฌธ์ โ [**๋งํฌ**](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-handlermapping-path)
- ์คํ๋ง(Spring) MVC ๋์ ๊ตฌ์กฐ ๋ฐ ์คํ๋ง ์ปจํ์ด๋ โ ****[๋งํฌ](https://codevang.tistory.com/248)****
- [Servlet] ์๋ธ๋ฆฟ ์ปจํ์ด๋์ ์คํ๋ง ์ปจํ์ด๋ โ ****[๋งํฌ](https://12bme.tistory.com/555)****

# โ๊ณต๋ถ ๋ด์ฉ ์ ๋ฆฌ

---

![spring-architecture.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e3e83df5-2c8c-41ea-88fb-01a1ce258e1c/spring-architecture.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230217%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230217T011049Z&X-Amz-Expires=86400&X-Amz-Signature=5ca3e982e3aa90696d430598bad0a0985ee64712926ce1e141b59a0bc234c94e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22spring-architecture.png%22&x-id=GetObject)

## HTTP ์์ฒญ์ด Dispatcher Servlet์ผ๋ก ์ ๋ฌ ๋๊ธฐ ๊น์ง์ ๊ณผ์ 

1. ํด๋ผ์ด์ธํธ โ ์น ์๋ฒ์ ์์ฒญ ๋ณด๋ด๊ธฐ
2. ๋์  ์น ์๋ฒ โ ์๋ธ๋ฆฟ ์ปจํ์ด๋๋ก ์ ๋ฌ
3. ์๋ธ๋ฆฟ ์ปจํ์ด๋๊ฐ ์๋ธ๋ฆฟ ์ค๋ ๋ ์์ฑ
4. ์๋ธ๋ฆฟ์ด ์์ฑ ์๋์ด์๋ค๋ฉด DispatcherServlet init(์ด๊ธฐํ)
5. ์์ฑ๋ ์ค๋ ๋์์ DisapatcherServlet์ service() ๋ฉ์๋ ํธ์ถ
6. HandlerMapping์ ํตํ ๋งคํ ์ปจํธ๋กค๋ฌ ์กฐํ
7. HandlerAdapter๋ฅผ ํตํด ๋งคํ ์ปจํธ๋กค๋ฌ์ ์์ฒญ ์ ๋ฌ
8. Developer Implementaion Controller โ Service ๋์โฆ

## โServlet Container๋?

- ๋จ์ํ Servlet์ ํฌํจํ๊ณ  ๋ผ์ดํ์ฌ์ดํด์ ๊ด๋ฆฌํ๋ ์น ์ปจํ์ด๋.

## ๊ถ๊ธํ ์ 

![blob.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1bec67b4-51e9-4167-9ade-92bd394d0ea7/blob.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230217%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230217T011111Z&X-Amz-Expires=86400&X-Amz-Signature=8c8525768e7dccdb03edca4c4a9b9b7c149224080bdf2507ce777e686c8b8d14&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22blob.png%22&x-id=GetObject)

- ์ ์์ผํ์ฒ๋ ํ๋ฆฐ๊ฑธ๊น?
    - ํ๋ฆฐ๊ฒ ๋ง๋ค.
      Dispatcher Servlet ์ bean ๋ฑ๋ก์ด ์๋์ด ์๊ธฐ ๋๋ฌธ์ Spring Container์์ ๊ด๋ฆฌ๋์ง ์๋๋ค.