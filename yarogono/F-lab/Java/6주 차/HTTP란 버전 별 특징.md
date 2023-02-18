# 🔗 참고자료

---

- MDN - HTTP의 진화 ⇒ **[링크](https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/Evolution_of_HTTP)**

# ✏공부 내용 정리

---

## HTTP란?

월드 와이드 웹에 내재된 프로토콜입니다.

- Tim Berners-Lee에 의해 1989년부터 1991년에 발명되었다.

## 버전 별 특징

### HTTP/0.9 - 원 라인 프로토콜

- 초기 버전으로 버전 번호가 없다.
- HTTP/0.9는 이후에 차후 버전과 구별하기 위해 0.9로 불리게 되었다.
- 요청은 단일 라인으로 구성되며 리소스에 대한 경로로 가능한 메서드는 **GET**이 유일했다.

**요청과 응답**

```html
GET /mypage.html

<html>
A very Simple HTML page
</html>
```

- 헤더가 없다.
    - HTML 파일만 전송 될 수 있고 다른 유형의 문서는 전송될 수 없다.
- 상태 혹은 오류 코드도 없다.

### HTTP/1.0 - 확장성 만들기

- 버전 정보 추가
    - HTTP/1.0 이 GET 라인에 붙은 형태
- 상태 코드 라인 또한 응답의 시작 부분에 붙어 전송
    - 브라우저가 요청에 대한 성공과 실패를 알 수 있고 그 결과에 대한 동작을 할 수 있게 되었다.
- HTTP 헫 개념은 요청과 응답 모두를 위해 도입
    - 메타 데이터 전송 허용
      (메타 데이터 : 데이터를 설명하는 데이터)
- 새로운 HTTP 헤더의 도움으로, HTML 파일 외에 다른 문서들 전송 기능 추가
  (content-Type)

**요청과 응답**

```html
GET /mypage.html HTTP/1.0
User-Agent: NCSA_Mosaic/2.0 (Windows 3.1)

200 OK
Date: Tue, 15 Nov 1994 08:12:31 GMT
Server: CERN/3.0 libwww/2.17
Content-Type: text/html
<HTML>
A page with an image
  <IMG SRC="/myimage.gif">
</HTML
```

**이미지를 내려받기 위한 요청과 응답**

```html
GET /myimage.gif HTTP/1.0
User-Agent: NCSA_Mosaic/2.0 (Windows 3.1)

200 OK
Date: Tue, 15 Nov 1994 08:12:32 GMT
Server: CERN/3.0 libwww/2.17
Content-Type: text/gif
(image content)
```

### HTTP/1.1 - 표준 프로토콜

- 커넥션이 재사용 할 수 있다.
    - 영속적인 커넥션 모델을 도입해 연속적인 요청 사이에 커넥션을 유지하여 새 커넥션을 여는데 필요한 시간을 줄였다. ⇒ [**자세한 내용**](https://developer.mozilla.org/ko/docs/Web/HTTP/Connection_management_in_HTTP_1.x)
- 파이프라이닝 추가
    - 첫번째 요청에 대한 응답이 완전히 전송되기 이전에 두번째 요청 전송을 가능하게 했다.
      *커뮤니케이션 레이턴시(요청과 응답 지연 시간)를 낮췄다.
- 청크된 응답 또한 지원
    - HTTP Body에 메시지가 크면 분할하여 메시지를 보낸다.
- 추가적인 캐시 제어 메커니즘 도입
- 언어, 인코딩 혹은 타입을 포함한 [**컨텐츠 협상**](https://developer.mozilla.org/ko/docs/Web/HTTP/Content_negotiation) 도입
    - 클라이언트와 서버로 하여금 교환하려는 가장 적합한 컨텐츠에 대한 동의를 가능케 했다.
- Host 헤더
    - 동일 IP 주소에 다른 도메인을 호스트하는 기능이 서버 [**코로케이션**](http://www.terms.co.kr/co-location.htm)을 가능하게 한다.

**하나의 단일 커넥션을 통한 요청의 전형적인 전체 흐름 예시**

```html
GET /en-US/docs/Glossary/Simple_header HTTP/1.1
Host: developer.mozilla.org
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate, br
Referer: https://developer.mozilla.org/en-US/docs/Glossary/Simple_header

200 OK
Connection: Keep-Alive
Content-Encoding: gzip
Content-Type: text/html; charset=utf-8
Date: Wed, 20 Jul 2016 10:55:30 GMT
Etag: "547fa7e369ef56031dd3bff2ace9fc0832eb251a"
Keep-Alive: timeout=5, max=1000
Last-Modified: Tue, 19 Jul 2016 00:59:33 GMT
Server: Apache
Transfer-Encoding: chunked
Vary: Cookie, Accept-Encoding

(content)

GET /static/img/header-background.png HTTP/1.1
Host: developer.mozilla.org
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
Accept: */*
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate, br
Referer: https://developer.mozilla.org/en-US/docs/Glossary/Simple_header

200 OK
Age: 9578461
Cache-Control: public, max-age=315360000
Connection: keep-alive
Content-Length: 3077
Content-Type: image/png
Date: Thu, 31 Mar 2016 13:34:46 GMT
Last-Modified: Wed, 21 Oct 2015 18:27:50 GMT
Server: Apache

(image content of 3077 bytes)
```

### HTTP/2 - 더 나은 성능을 위한 프로토콜

- 텍스트 프로토콜 보다는 이진 프로토콜을 통한 경량화
    - 메시지를 바이너리 형태의 프레임으로 나누고 전송 후 받은 쪽에서 다시 조립
      ⇒ **[자세한 내용](https://www.whatap.io/ko/blog/38/)**
- 병렬 요청
    - 동일한 커넥션 상에서 다루어질 수 있는 다중화 프로토콜
    - 순서를 제거해주고 HTTP/1.,x 프로토콜의 제약사항을 막아준다.
- 전송된 데이터의 중복으로 인한 불필요한 오버헤드 제거
    - 연속된 요청 사이의 매우 유사한 내용으로 존재하는 헤더들을 압축
- 서버 푸쉬 매커니즘
    - 클라이언트가 리소스를 요청하기 전에 서버가 클라이언트에 리소스를 보낼 수 있다.
    - 클라이언트가 필요하다는 것을 알기도 전에 리소스를 선제적으로 로드하여 대기 시간을 줄인다.

### 차세대 - HTTP/2로의 진화

2016년에 나타난 HTTP의 새로운 확장 기능들

- [**Alt-Svc (en-US)**](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Alt-Svc) 지원
    - 좀 더 영리한 [**CDN (en-US)**](https://developer.mozilla.org/en-US/docs/Glossary/CDN) 메커니즘을 따라, 신분 증명의 개념과 주어진 자원의 위치를 분리
- [**Client Hints**](https://developer.mozilla.org/ko/docs/Web/HTTP/Client_hints) 의 도입
    - 브라우저 혹은 클라이언트가 요구사항이나 서버의 하드웨어 제약사항에 관한 정보를 사전에 미리 주고 받을 수 있게 되었다.
- [**Cookie**](https://developer.mozilla.org/ko/docs/Web/HTTP/Headers/Cookie) 내에 보안 관련 접두사 도입
    - 보안 쿠키가 변경되지 않았다는 것을 보장하는데 도움을 준다.

### HTTP/3 - HTTP over QUIC

- HTTP의 다음 메이저 버전인 HTTP/3에서는 전송 계층 부분에 TCP/TLS 대신 QUIC이 사용됩니다.
    - ❓QUIC(Quick UDP Internet Clonnection)이란?
        - UDP 상에 구현된 실험적인 다중 전송 프로토콜
        - TCP 및 웹 애플리케이션 전송을 개선하기 위한 방법을 위해 Google에서 개발

      ### QUIC의 중요한 기능

        - 연결 설정 시간 단축
        - 혼잡 제어 개선
        - Head of Line Blocking 없는 멀티플렉싱
        - 전달 오류 수정
        - 연결 마이그레이션

