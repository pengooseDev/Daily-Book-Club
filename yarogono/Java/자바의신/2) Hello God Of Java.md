![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a4fda6de-08ae-44d6-9a13-1bd78cccd55a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230201T072142Z&X-Amz-Expires=86400&X-Amz-Signature=561f68e95fe739f7876ef7c6460971645019ba1e2733cee964037cb9045bd912&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

위와 같이 cmd창에 명령어를 입력하면 java 버전이 나온다.

# 어떻게 CMD 창에 java라는 프로그램이 실행 될 까?

---

자바를 설치한 디렉터리의 bin 디렉터리를 보면 각종 exe 파일이 존재한다(맥, 리눅스 제외).

Path라는 경로에서 찾아서 실행한다.

cmd 창의 어떤 위치에서라도 실행할 수 있으려면 Path에 지정되어 있으면 된다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4a942b77-798b-4065-bc1d-f5ec60aa4b56/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230201T072246Z&X-Amz-Expires=86400&X-Amz-Signature=05bbd1ff88c6f86f8431a1d658a073aa9b9fbe4f5bcc37978911c3d95767550f&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- cmd 창에 “set %PATH%” 라고 치면 위와 같이 지정된 PATH가 뜬다.

# 자바 컴파일 및 실행 절차

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c6850152-bc71-4bae-93c2-0755ff734d36/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230201T072258Z&X-Amz-Expires=86400&X-Amz-Signature=94cd2fa5690126ca4f594db7b4837f91057832a2e4d4ae7c3f91d4069a671a67&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

- 대부분의 프로그래밍 언어들은 텍스트로 된 파일로 실행할 수가 없다.
- 컴파일 단계를 거쳐서 프로그래밍 언어를 실행하는 프로그램들이 실행을 할 수 있다.
- compile이라는 단어의 의미는 “엮다”라는 말이다.
  즉, 내가 만든 프로그램 코드를 컴퓨터가 이해할 수 있도록 엮어주는 작업이 바로 컴파일이다.

1. .java 라는 확장자로 되어 있는 소스를 컴파일하면 .class라는 확장자를 가진 파일이 생성되어 디스크게 저장된다.
    - .class 파일은 바이너리 파일로 되어 있기 때문에 에디터에서 열어도 제대로 보기가 어렵다.
2. 컴파일을 하는 프로그램을 컴파일러라고 부르며, 자바에서는 javac.exe라는 프로그램이 그 역할을 수행한다.
3. 컴파일 과정에서 프로그램 코드가 규칙이 지켜져 있지 않으면 컴파일 오류가 발생한다.
4. 컴파일을 마친 클래스 파일은 JVM에서 읽어서 운영체제에서 실행된다.

### ❓바이너리 파일이란?

- 우리나라말로 0과 1로 구성되어 있는 2진법을 의미한다.
    - 바이너리 파일은 2진수로 채워져 있는 파일을 말한다.
- 컴퓨터는 2진 파일을 읽는 것이 훨씬 빠르기 때문에 컴퓨터가 읽기 위한 파일들은 대부분 바이너리로 되어 있다.