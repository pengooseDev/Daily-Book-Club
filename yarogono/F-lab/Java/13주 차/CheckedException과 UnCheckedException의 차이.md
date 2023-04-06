# 🔗 참고자료

---

- chatGPT
- [Java] Checked Exception과 Unchecked Exception ⇒ **[링크](https://steady-coding.tistory.com/583)**
- Java Exception 생성 비용은 비싸다. ⇒ **[링크](https://meetup.nhncloud.com/posts/47?ref=codenary)**

# ✏공부 내용 정리

---

## CheckedException과 UnCheckedException의 차이

| 구분 | Checked Exception | Unchecked Exception |
| --- | --- | --- |
| 컴파일 시점 검사 여부 | 예 | 아니오 |
| 예외 발생 시점 | 실행 중에 발생 | 런타임 시점에 발생 |
| 예외 처리 요구 사항 | 필수 | 선택적 |
| 예외 전파(예외 체인) | 예 | 예 |
| 예외 클래스 계층 구조 | Exception 하위 클래스 | RuntimeException 하위 클래스 |
| 예외 처리에 대한 컴파일러 체크 | 예 | 아니오 |
| 예외 처리의 중요성 | 높음 | 낮음 |

1. 컴파일 시점 검사 여부 및 예외 발생 시점
    - Checked Exception은 말그대로 컴파일 시점에 Exception을 체크하는 것을 말한다.
    - Unchecked Exception은 컴파일 시점에 체크를 안하고 런타임 시점에 발생한다.
2. 예외 처리 요구 사항
    - Cheked Exception은 컴파일 과정에서 강제적으로 예외 처리를 요구한다. 그래서 필수적으로 예외 처리를 해야 한다.
    - Unchecked Exception은 반대로 컴파일러가 강제적으로 예외 처리를 요구하지 않는다.
3. 예외 클래스 계층 구조
    - Uncheked Exception도 Exception의 하위 클래스이기는 하다.
      하지만 RuntimeException 하위 클래스에 있는 영역을 UncheckedException이라고 한다.
    - RuntimeException 하위 클래스가 아닌 것들을 Checked Exception이라고 보는게 좀 더 정확할 것 같다.
4. 예외 처리에 대한 컴파일러 체크
    - CheckedException은 말그대로 컴파일가 예외를 check 한다.
      (UncheckedException 당연히 그 반대로 check를 안한다.)
5. 예외 처리의 중요성
    - UncheckException이 CheckedExceptio보다 비교적 중요성이 낮다.
