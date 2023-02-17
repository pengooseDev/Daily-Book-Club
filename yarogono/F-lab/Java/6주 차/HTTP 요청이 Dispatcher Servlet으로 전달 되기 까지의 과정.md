# 🔗 참고자료

---

- 스프링 요청처리 내부구조 ⇒ ****[링크](https://gowoonsori.com/spring/architecture/)****
- Spring MVC 공식문서 ⇒ [**링크**](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-handlermapping-path)
- 스프링(Spring) MVC 동작 구조 및 스프링 컨테이너 ⇒ ****[링크](https://codevang.tistory.com/248)****
- [Servlet] 서블릿 컨테이너와 스프링 컨테이너 ⇒ ****[링크](https://12bme.tistory.com/555)****

# ✏공부 내용 정리

---

![spring-architecture.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e3e83df5-2c8c-41ea-88fb-01a1ce258e1c/spring-architecture.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230217%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230217T011049Z&X-Amz-Expires=86400&X-Amz-Signature=5ca3e982e3aa90696d430598bad0a0985ee64712926ce1e141b59a0bc234c94e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22spring-architecture.png%22&x-id=GetObject)

## HTTP 요청이 Dispatcher Servlet으로 전달 되기 까지의 과정

1. 클라이언트 → 웹 서버에 요청 보내기
2. 동적 웹 서버 → 서블릿 컨테이너로 전달
3. 서블릿 컨테이너가 서블릿 스레드 생성
4. 서블릿이 생성 안되어있다면 DispatcherServlet init(초기화)
5. 생성된 스레드에서 DisapatcherServlet의 service() 메서드 호출
6. HandlerMapping을 통한 매핑 컨트롤러 조회
7. HandlerAdapter를 통해 매핑 컨트롤러에 요청 전달
8. Developer Implementaion Controller → Service 동작…

## ❓Servlet Container란?

- 단순히 Servlet을 포함하고 라이프사이클을 관리하는 웹 컨테이너.

## 궁금한 점

![blob.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1bec67b4-51e9-4167-9ade-92bd394d0ea7/blob.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230217%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230217T011111Z&X-Amz-Expires=86400&X-Amz-Signature=8c8525768e7dccdb03edca4c4a9b9b7c149224080bdf2507ce777e686c8b8d14&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22blob.png%22&x-id=GetObject)

- 위 아케텍처는 틀린걸까?
    - 틀린게 맞다.
      Dispatcher Servlet 은 bean 등록이 안되어 있기 때문에 Spring Container에서 관리되지 않는다.