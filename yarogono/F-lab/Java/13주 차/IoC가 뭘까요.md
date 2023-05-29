# 🔗 참고자료

---

- chatGPt
- [DI] Inversion Of Control Container 란? ⇒ [**링크**](https://medium.com/@jang.wangsu/di-inversion-of-control-container-%EB%9E%80-12ecd70ac7ea)
- Programming - What is... Inversion of Control ⇒ ****[링크](https://www.youtube.com/watch?v=zmdWWujU8M4&t=5s&ab_channel=ChristianRichards)****

# ✏공부 내용 정리

---

![Untitled](https://file.notion.so/f/s/43616fde-7115-4f6f-99b6-7894432568a0/Untitled.png?id=4144ff94-6ce6-4b6c-9b68-7d944b6c7f6f&table=block&spaceId=a6996cfb-7419-48fb-9ad1-d4bdae0c3162&expirationTimestamp=1681041124402&signature=cr6_SYO2wi7AbFEujZ4TPBCH5u-3acbp3VANhdsvRxE&downloadName=Untitled.png)

## IOC(Inversion Of Control)란?

제어의 역전을 의미하며, 프로그래머가 작성한 프로그램이 재사용 라이브러리의 흐름 제어를 받게 되는 소프트웨어 디자인 패턴을 말한다.

- 객체 간의 결합도를 낮추고 유연성을 높이기 위한 디자인 패턴 중 하나이다.

전통적인 프로그래밍에서 흐름은 프로그래머가 작성한 프로그램이 외부 라이브러리의 코드가 프로그래머가 작성한 코드를 호출합니다.

## IOC의 설계 목적

- 작업을 구현하는 방식과 작업 수행 자체를 분리한다.
- 모듈을 제작할 때, 모듈과 외부 프로그램의 결합에 대해 고민할 필요 없이 모듈의 목적에 집중할 수 있다.
- 다른 시스템이 동작 하는 것에 대해 고민할 필요 없이, 정해진 협약대로만 동작하게 하면 된다.
- 모듈을 바꾸어도 다른 시스템에 부작용을 일으키지 않는다.

## 궁금한 점

- JVM도 IOC 패턴을 사용한다고 볼 수 있을까?
    - 결론적으로 아니다. 객체의 라이프 사이클을 어느정도 개발자가 컨트롤 할 수 있기 때문이다. 객체 생성은 대부분 개발자가 한다.
      Spring Framework 같은 경우에는 Application을 run 하면 추상화된 객체들을 생성하고 IOC Container에서 보관해 관리를 하게 된다.
      개발자는 이런 객체들을 의존성 주입을 통해 사용한다.