# 🔗 참고자료

---

- 토비의 스프링 4장 예외(279p)
- (Spring Boot)오류 처리에 대해 ⇒ **[링크](https://supawer0728.github.io/2019/04/04/spring-error-handling/)**
- [스프링] 스프링에서 예외 처리 ⇒ **[링크](https://velog.io/@injoon2019/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90%EC%84%9C-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC)**
- Spring Docs - ExceptionHandlers ⇒ [**링크**](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-exceptionhandlers)
- [Spring] 스프링의 다양한 예외 처리 방법(ExceptionHandler, ControllerAdvice 등) 완벽하게 이해하기 - (1/2) ⇒ [**링크**](https://mangkyu.tistory.com/204)

# ✏공부 내용 정리

---

## Spring MVC 예외 처리 프로세스

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0a59d1cc-7c31-4a95-ab2f-f0e27fc45341/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230320%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230320T081453Z&X-Amz-Expires=86400&X-Amz-Signature=ed66c4f24cf6bbfa7fc83a25c5e9e14150331c4085b2c57814ad11ffe91584fb&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- 기본적인 에러 처리 방식은 결국 에러 컨트롤러를 한번 더 호출한다.
  그러므로 필터나 인터셉터가 다시 호출 될 수있는데, 이를 제어하기 위해서는 별도의 설정이 필요하다.
- 컨트롤러에서 예외가 발생하면 예외 처리를 담당하는 기능을 가진 다른 컨트롤러 또는 예외 처리 기능을 가지고 있는 컨트롤러로 다시 요청이 전달 된다.
    - 이때 요청은 DispatcherServlet 을 통해 다시 처리된다.
- 컨트롤러에서 발생한 에러가 WAS(톰캣)까지 전달되고 다시 WAS(톰캣)에서 BasicErrorController 까지 에러 정보를 전달해 클라이언트에게 전달하게 된다.

## DispatcherServlet과 Servlet 에러 처리 도식화

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/10b0213d-58ff-4fed-949b-cf1cda370cc3/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230320%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230320T081512Z&X-Amz-Expires=86400&X-Amz-Signature=10a00315babc7fb0697ff26a4c747358cc1f4351d511e25715a0ed53bdbe2680&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- Request Handler(ex. @Controller)에서 Exception이 발생하면 **DispatcherServlet**은 HandlerExceptionResolver 흐름에게 처리를 맡긴다.
    - HandlerExceptionResolver의 구현체는 위와 같다.
- DispatcherServlet은 요청 처리 과정에서 발생하는 예외와 연관이 있으며,
  인터셉터를 통해 에러를 가로채서 처리 흐름을 통해 클라이언트에게 전달 된다.
- **필터(Filter)**는 Servlet 앞 단에 위치하며 에러를 보통 웹 애플리케이션 초기화 시 발생하는 에러를 처리한다.
    - 필터에서 발생한 에러는 필터 자체에서 처리한다.
    - doFilter()에서 try-catch와 같은 에러 처리 할 수는 있지만,
      예외에 대한 분석이 어렵다는 단점이 있다.

### BasicErrorController - 스프링 부트의 기본 오류 처리

스프링 부트는 오류가 발생하면 `server.error.path`에 설정된 경로에서 요청을 처리하게 한다.

그리고 기본적으로 BasicErrorController가 등록이 되어 해당 요청을 처리하게 된다.

```java
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")  // 1️⃣
public class BasicErrorController extends AbstractErrorController {

	// ... 생략 ...

	// 2️⃣
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		HttpStatus status = getStatus(request);
		Map<String, Object> model = Collections
			.unmodifiableMap(getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.TEXT_HTML)));
		response.setStatus(status.value());
		ModelAndView modelAndView = resolveErrorView(request, response, status, model);
		return (modelAndView != null) ? modelAndView : new ModelAndView("error", model);
	}

	// 3️⃣
	@RequestMapping
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		HttpStatus status = getStatus(request);
		if (status == HttpStatus.NO_CONTENT) {
			return new ResponseEntity<>(status);
		}
		// 4️⃣
		Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
		return new ResponseEntity<>(body, status);
	}

	// ... 생략 ...

	protected ErrorAttributeOptions getErrorAttributeOptions(HttpServletRequest request, MediaType mediaType) {
		ErrorAttributeOptions options = ErrorAttributeOptions.defaults();
		if (this.errorProperties.isIncludeException()) {
			options = options.including(Include.EXCEPTION);
		}
		if (isIncludeStackTrace(request, mediaType)) {
			options = options.including(Include.STACK_TRACE);
		}
		if (isIncludeMessage(request, mediaType)) {
			options = options.including(Include.MESSAGE);
		}
		if (isIncludeBindingErrors(request, mediaType)) {
			options = options.including(Include.BINDING_ERRORS);
		}
		return options;
	}

	// Error Response에 StackTrace를 포함하는지 에러프로퍼티 설정을 확인하는 메서드
	protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
		switch (getErrorProperties().getIncludeStacktrace()) {
			case ALWAYS:
				return true;
			case ON_PARAM:
				return getTraceParameter(request);
			default:
				return false;
		}
	}

	// Error Response에 메시지를 포함하는지 에러프로퍼티 설정을 확인하는 메서드
	protected boolean isIncludeMessage(HttpServletRequest request, MediaType produces) {
		switch (getErrorProperties().getIncludeMessage()) {
			case ALWAYS:
				return true;
			case ON_PARAM:
				return getMessageParameter(request);
			default:
				return false;
		}
	}

	// Error Response에 바인딩에러를 포함하는지 에러프로퍼티 설정을 확인하는 메서드
	protected boolean isIncludeBindingErrors(HttpServletRequest request, MediaType produces) {
		switch (getErrorProperties().getIncludeBindingErrors()) {
			case ALWAYS:
				return true;
			case ON_PARAM:
				return getErrorsParameter(request);
			default:
				return false;
		}
	}

	/**
	 * Provide access to the error properties.
	 * @return the error properties
	 */
	protected ErrorProperties getErrorProperties() {
		return this.errorProperties;
	}

}
```

1️⃣ Spring 환경 내에 `server.error.path` 혹은 `error.path`로 등록된 property의 값을 넣거나, 없는 경우 기본값인 `/error`를 사용한다.

2️⃣ HTML로 응답을 주는 경우 `errorHTML`에서 응답을 처리한다.

- `@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)` 을 보면 알 수 있듯이 HTML 값으로 생성해서 응답 해주도록 설정 되어 있다.

3️⃣ `error` 에서는 ResponseEntity 객체를 리턴하게 된다.

- 2️⃣번과 달리 resolveErrorView() 메서드가 없고 ResponseEntity 객체를 생성해 return 한다.

4️⃣ ResponseEntity 객체에 HashMap 자료형인 body 객체에 getErrorAttributes를 사용해서 값 할당

- View가 아닌 Model에 해당하는 값만 ResponseEntity 객체의 body에 담아 리턴한다.

> BasicErrorController
BasicErrorController는 `resolveErrorView`를 통해 HTML를 만들기와 `getErrorAttributes`를 메서드를 통해 에러에 해당하는 값을 Model에 담아 에러 정보를 클라이언트에게 전달한다.
*View가 없이 Model만 ResponseEntity 객체에 담아 리턴 할 수 있다.
>

## ❓Filter와 Intercepter의 개념과 차이는?

Filter와 Interceptor는 실행되는 위치가 다르다.

때문에 Exception이 발생했을 때 처리하는 방법도 달라진다.

1️⃣Filter는 DispatcherServlet 외부에서 발생해서 `ErrorController`에서 처리해야 한다.

2️⃣Interceptor는 DispatcherServlet 내부에서 발생하기 때문에 `ControllerAdvice`를 적용할 수 있다.

![spring-request-lifecycle.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/889169a7-db23-41a7-8263-4c8df9846ae2/spring-request-lifecycle.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230320%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230320T081545Z&X-Amz-Expires=86400&X-Amz-Signature=4ad5277fb2d7935bbda85ee943a22a70591182a3d4b66eee6f3d55e5924f0be2&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22spring-request-lifecycle.jpg%22&x-id=GetObject)

우선 Servlet Filter에서 에러를 처리

## 궁금한 점

- Spring Autoconfiguration은 무엇일까?
- Spring AutoConfiguration과 SpringMVC의 차이는?