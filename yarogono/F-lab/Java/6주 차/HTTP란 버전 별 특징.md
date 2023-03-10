# π μ°Έκ³ μλ£

---

- MDN - HTTPμ μ§ν β **[λ§ν¬](https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/Evolution_of_HTTP)**

# βκ³΅λΆ λ΄μ© μ λ¦¬

---

## HTTPλ?

μλ μμ΄λ μΉμ λ΄μ¬λ νλ‘ν μ½μλλ€.

- Tim Berners-Leeμ μν΄ 1989λλΆν° 1991λμ λ°λͺλμλ€.

## λ²μ  λ³ νΉμ§

### HTTP/0.9 - μ λΌμΈ νλ‘ν μ½

- μ΄κΈ° λ²μ μΌλ‘ λ²μ  λ²νΈκ° μλ€.
- HTTP/0.9λ μ΄νμ μ°¨ν λ²μ κ³Ό κ΅¬λ³νκΈ° μν΄ 0.9λ‘ λΆλ¦¬κ² λμλ€.
- μμ²­μ λ¨μΌ λΌμΈμΌλ‘ κ΅¬μ±λλ©° λ¦¬μμ€μ λν κ²½λ‘λ‘ κ°λ₯ν λ©μλλ **GET**μ΄ μ μΌνλ€.

**μμ²­κ³Ό μλ΅**

```html
GET /mypage.html

<html>
A very Simple HTML page
</html>
```

- ν€λκ° μλ€.
    - HTML νμΌλ§ μ μ‘ λ  μ μκ³  λ€λ₯Έ μ νμ λ¬Έμλ μ μ‘λ  μ μλ€.
- μν νΉμ μ€λ₯ μ½λλ μλ€.

### HTTP/1.0 - νμ₯μ± λ§λ€κΈ°

- λ²μ  μ λ³΄ μΆκ°
    - HTTP/1.0 μ΄ GET λΌμΈμ λΆμ νν
- μν μ½λ λΌμΈ λν μλ΅μ μμ λΆλΆμ λΆμ΄ μ μ‘
    - λΈλΌμ°μ κ° μμ²­μ λν μ±κ³΅κ³Ό μ€ν¨λ₯Ό μ μ μκ³  κ·Έ κ²°κ³Όμ λν λμμ ν  μ μκ² λμλ€.
- HTTP ν« κ°λμ μμ²­κ³Ό μλ΅ λͺ¨λλ₯Ό μν΄ λμ
    - λ©ν λ°μ΄ν° μ μ‘ νμ©
      (λ©ν λ°μ΄ν° : λ°μ΄ν°λ₯Ό μ€λͺνλ λ°μ΄ν°)
- μλ‘μ΄ HTTP ν€λμ λμμΌλ‘, HTML νμΌ μΈμ λ€λ₯Έ λ¬Έμλ€ μ μ‘ κΈ°λ₯ μΆκ°
  (content-Type)

**μμ²­κ³Ό μλ΅**

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

**μ΄λ―Έμ§λ₯Ό λ΄λ €λ°κΈ° μν μμ²­κ³Ό μλ΅**

```html
GET /myimage.gif HTTP/1.0
User-Agent: NCSA_Mosaic/2.0 (Windows 3.1)

200 OK
Date: Tue, 15 Nov 1994 08:12:32 GMT
Server: CERN/3.0 libwww/2.17
Content-Type: text/gif
(image content)
```

### HTTP/1.1 - νμ€ νλ‘ν μ½

- μ»€λ₯μμ΄ μ¬μ¬μ© ν  μ μλ€.
    - μμμ μΈ μ»€λ₯μ λͺ¨λΈμ λμν΄ μ°μμ μΈ μμ²­ μ¬μ΄μ μ»€λ₯μμ μ μ§νμ¬ μ μ»€λ₯μμ μ¬λλ° νμν μκ°μ μ€μλ€. β [**μμΈν λ΄μ©**](https://developer.mozilla.org/ko/docs/Web/HTTP/Connection_management_in_HTTP_1.x)
- νμ΄νλΌμ΄λ μΆκ°
    - μ²«λ²μ§Έ μμ²­μ λν μλ΅μ΄ μμ ν μ μ‘λκΈ° μ΄μ μ λλ²μ§Έ μμ²­ μ μ‘μ κ°λ₯νκ² νλ€.
      *μ»€λ?€λμΌμ΄μ λ μ΄ν΄μ(μμ²­κ³Ό μλ΅ μ§μ° μκ°)λ₯Ό λ?μ·λ€.
- μ²­ν¬λ μλ΅ λν μ§μ
    - HTTP Bodyμ λ©μμ§κ° ν¬λ©΄ λΆν νμ¬ λ©μμ§λ₯Ό λ³΄λΈλ€.
- μΆκ°μ μΈ μΊμ μ μ΄ λ©μ»€λμ¦ λμ
- μΈμ΄, μΈμ½λ© νΉμ νμμ ν¬ν¨ν [**μ»¨νμΈ  νμ**](https://developer.mozilla.org/ko/docs/Web/HTTP/Content_negotiation) λμ
    - ν΄λΌμ΄μΈνΈμ μλ²λ‘ νμ¬κΈ κ΅ννλ €λ κ°μ₯ μ ν©ν μ»¨νμΈ μ λν λμλ₯Ό κ°λ₯μΌ νλ€.
- Host ν€λ
    - λμΌ IP μ£Όμμ λ€λ₯Έ λλ©μΈμ νΈμ€νΈνλ κΈ°λ₯μ΄ μλ² [**μ½λ‘μΌμ΄μ**](http://www.terms.co.kr/co-location.htm)μ κ°λ₯νκ² νλ€.

**νλμ λ¨μΌ μ»€λ₯μμ ν΅ν μμ²­μ μ νμ μΈ μ μ²΄ νλ¦ μμ**

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

### HTTP/2 - λ λμ μ±λ₯μ μν νλ‘ν μ½

- νμ€νΈ νλ‘ν μ½ λ³΄λ€λ μ΄μ§ νλ‘ν μ½μ ν΅ν κ²½λν
    - λ©μμ§λ₯Ό λ°μ΄λλ¦¬ ννμ νλ μμΌλ‘ λλκ³  μ μ‘ ν λ°μ μͺ½μμ λ€μ μ‘°λ¦½
      β **[μμΈν λ΄μ©](https://www.whatap.io/ko/blog/38/)**
- λ³λ ¬ μμ²­
    - λμΌν μ»€λ₯μ μμμ λ€λ£¨μ΄μ§ μ μλ λ€μ€ν νλ‘ν μ½
    - μμλ₯Ό μ κ±°ν΄μ£Όκ³  HTTP/1.,x νλ‘ν μ½μ μ μ½μ¬ν­μ λ§μμ€λ€.
- μ μ‘λ λ°μ΄ν°μ μ€λ³΅μΌλ‘ μΈν λΆνμν μ€λ²ν€λ μ κ±°
    - μ°μλ μμ²­ μ¬μ΄μ λ§€μ° μ μ¬ν λ΄μ©μΌλ‘ μ‘΄μ¬νλ ν€λλ€μ μμΆ
- μλ² νΈμ¬ λ§€μ»€λμ¦
    - ν΄λΌμ΄μΈνΈκ° λ¦¬μμ€λ₯Ό μμ²­νκΈ° μ μ μλ²κ° ν΄λΌμ΄μΈνΈμ λ¦¬μμ€λ₯Ό λ³΄λΌ μ μλ€.
    - ν΄λΌμ΄μΈνΈκ° νμνλ€λ κ²μ μκΈ°λ μ μ λ¦¬μμ€λ₯Ό μ μ μ μΌλ‘ λ‘λνμ¬ λκΈ° μκ°μ μ€μΈλ€.

### μ°¨μΈλ - HTTP/2λ‘μ μ§ν

2016λμ λνλ HTTPμ μλ‘μ΄ νμ₯ κΈ°λ₯λ€

- [**Alt-Svc (en-US)**](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Alt-Svc) μ§μ
    - μ’ λ μλ¦¬ν [**CDN (en-US)**](https://developer.mozilla.org/en-US/docs/Glossary/CDN) λ©μ»€λμ¦μ λ°λΌ, μ λΆ μ¦λͺμ κ°λκ³Ό μ£Όμ΄μ§ μμμ μμΉλ₯Ό λΆλ¦¬
- [**Client Hints**](https://developer.mozilla.org/ko/docs/Web/HTTP/Client_hints) μ λμ
    - λΈλΌμ°μ  νΉμ ν΄λΌμ΄μΈνΈκ° μκ΅¬μ¬ν­μ΄λ μλ²μ νλμ¨μ΄ μ μ½μ¬ν­μ κ΄ν μ λ³΄λ₯Ό μ¬μ μ λ―Έλ¦¬ μ£Όκ³  λ°μ μ μκ² λμλ€.
- [**Cookie**](https://developer.mozilla.org/ko/docs/Web/HTTP/Headers/Cookie) λ΄μ λ³΄μ κ΄λ ¨ μ λμ¬ λμ
    - λ³΄μ μΏ ν€κ° λ³κ²½λμ§ μμλ€λ κ²μ λ³΄μ₯νλλ° λμμ μ€λ€.

### HTTP/3 - HTTP over QUIC

- HTTPμ λ€μ λ©μ΄μ  λ²μ μΈ HTTP/3μμλ μ μ‘ κ³μΈ΅ λΆλΆμ TCP/TLS λμ  QUICμ΄ μ¬μ©λ©λλ€.
    - βQUIC(Quick UDP Internet Clonnection)μ΄λ?
        - UDP μμ κ΅¬νλ μ€νμ μΈ λ€μ€ μ μ‘ νλ‘ν μ½
        - TCP λ° μΉ μ νλ¦¬μΌμ΄μ μ μ‘μ κ°μ νκΈ° μν λ°©λ²μ μν΄ Googleμμ κ°λ°

      ### QUICμ μ€μν κΈ°λ₯

        - μ°κ²° μ€μ  μκ° λ¨μΆ
        - νΌμ‘ μ μ΄ κ°μ 
        - Head of Line Blocking μλ λ©ν°νλ μ±
        - μ λ¬ μ€λ₯ μμ 
        - μ°κ²° λ§μ΄κ·Έλ μ΄μ

