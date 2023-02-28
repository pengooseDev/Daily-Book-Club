# 🔗 참고자료

---

- [JWT] 토큰(Token) 기반 인증에 대한 소개 ⇒ ****[링크](https://velopert.com/2350)****
- [JWT] JSON Web Token 소개 및 구조 ⇒ [**링크**](https://velopert.com/2389)
- 코딩애플 - JWT 대충 쓰면 님들 코딩인생 끝남 ⇒ [**링크**](https://www.youtube.com/watch?v=XXseiON9CV0)
- JWT를 조금 더 안전하게 저장하기 & 쿠키와 웹 스토리지 ⇒ ****[링크](https://prolog.techcourse.co.kr/studylogs/2272)****
- NHN cloud - JWT를 소개합니다**. ⇒ [링크](https://meetup.nhncloud.com/posts/239)**
- JWT 공식문서 ⇒ [**링크**](https://jwt.io/introduction)

# ✏공부 내용 정리

---

## ❓JWT란?

JSON Web Token의 약자로, 말 그대로 JSON 형식의 웹 토큰을 말한다.

두 개체에서 JSON 객체를 사용하여 가볍고 자가수용적인(self-contained) 방식으로 정보를 안정성 있게 전달해준다.

## JWT의 용도

- 회원 인증
    - 유저가 로그인을 하면, 서버는 유저의 정보에 기반한 토큰을 발급하여 유저에게 전달해줍니다. 그 후 유저가 서버에 요청을 할 때마다 JWT를 포함하여 전달합니다.
    - 서버는 클라이언트에게서 요청을 받을 때 마다, 해당 토큰이 유효하고 인증됐는지 검증을 하고, 유저가 요청한 작업에 권한이 있는지 확인하여 작업을 처리한다.
- 정보 교류
    - 두 개체 사이에서 안정성있게 정보를 교환하는데도 사용한다.
    - 정보가 sign이 되어있기 때문에 정보를 보낸이가 바뀌진 않았는지, 또 정보가 도중에 조작되지는 않았는지 검증할 수 있다.

## JWT의 구조

![jwt.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/dbf8c8ae-8e5f-4ecd-8165-969e98183045/jwt.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230228%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230228T161901Z&X-Amz-Expires=86400&X-Amz-Signature=63bab37e081e6a5943ab236a2929092799a92c6f553c350f7854ef3db5a09d06&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22jwt.png%22&x-id=GetObject)

### 헤더(Header)

헤더에는 도 가지의 정보를 담고 있다.

- type : 토큰의 타입을 지정합니다(ex. “**JWT”)**
- alg : 서명시 사용하는 알고리즘이다.

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

### 내용(Payload)

페이로드에 있는 속성들을 크레임 셋(Claim set)이라 부른다.

클레임 셋은 JWT에 대한 내용(토큰 생성자의 정보, 생성 일시 등)이나 클라이언트와 서버 간 주고 받기고 한 값들로 구성된다.

- 페이로드에 담는 정보의 한 ‘조각’을 클레임(claim)이라고 부른다.
    - name / value 의 한 쌍으로 이뤄져 있다.
- Payload는 3개 타입의 클레임들이 있습니다.
    - Registered claims(등록된 클레임), Public claims(공개 클레임), Private claims(비공개 클레임)

**등록된(registered) 클레임**

- 서비스에서 필요한 정보들이 아닌, 토큰에 대한 정보들을 담기위해 이름이 이미 정해진 클레임들
- 클레임의 사용은 모두 선택적(optional)이다.
- 예시로 iss(issuer), exp(expiration time), sub(subject), aud(audience)가 있다.

**공개(public) 클레임**

- 충돌이 방지된(collision-resistant) 이름을 가지고 있어야 한다.
    - 충돌을 방지하기 위해서는, 클레임 이름을 URI 형식으로 짓는다.

**비공개(private) 클레임**

- 등록된 클레임도 아니고, 공개된 클레임들도 아니다.
- 양 측간에(보통 클라이언트와 서버) 협의 하에 사용되는 클레임 이름이다.
- 공개 클레임과는 달리 이름이 중복되어 충돌이 될 수 있으니 사용할 때에 유의해야 한다.

> 서명된 토큰의 경우 패이로드 정보는 변조로부터 보호되지만, 누구나 읽을 수 있다.
암호화되지 않은 경우 JWT의 페이로드 또는 헤더 요소에 민감한 정보를 입력하면 안된다.
>

### 서명(signature)

JWT의 마지막 부분으로, 서명은 헤더의 인코딩값과, 정보의 인코딩값을 합친 후 주어진 비밀키로 해쉬를 하여 생성합니다.

- 서명은 도중에 메시지가 변경되지 않았는지 확인하는데 사용됩니다.

## ❓JWS, JWE, JWK, JWA 들은 무엇일까?

- JWT는 URL, Cookie, Header와 같이 사용할 수 있는 문자가 제한된 환경에서 정보를 주고받을 수 있게 하는 데이터 표현 형식(Format)이다.
- 개발자가 JWT를 이용한 서명(Sign)이나 암호화(Encryption)에 대한 명세는 JWT 하위 JWS(JSON Web Signature)와 JWE(JSON Web Encryption)에 되어있다.
    - JWT는 추상화 클래스라 할 수 있고, JWS와 JWE는 추상화 클래스를 마저 구현한 콘크리트 클래스라고 할 수 있다.
- JWK(JSON Web Key)는 JSON 형식으로 암호화 키를 표현한 것
- JWA(JSON Web Algorithm)은 JWS, JWE, JWK에 사용하는 알고리즘에 대한 명세다.

**우리가 일반적으로 사용하는 대부분의 JWT는 JWS다.**