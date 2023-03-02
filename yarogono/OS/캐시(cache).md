# 참고자료

- CS160 - Memory Hierarchy ⇒ [**링크**](https://computerscience.chemeketa.edu/cs160Reader/ComputerArchitecture/MemoryHeirarchy.html)
- [10분 테코톡] 🐻큰곰의 Cache ⇒ ****[링크](https://www.youtube.com/watch?v=c33ojJ7kE7M)**
- [10분 테코톡] 📸소니의 Cache ⇒ [**링크**](https://www.youtube.com/watch?v=NxFJ-mJdVNQ)
- 유튜브 [기술노트with알렉] ⇒ [**링크**](https://www.youtube.com/watch?v=jXLeXgIWNbQ)
- 💵 캐시가 동작하는 아주 구체적인 원리 ⇒ ****[링크](https://parksb.github.io/article/29.html)**
- [번역] 슈퍼마켓에서 우유를 사면서 웹 캐싱(Web Caching)을 알아봅시다 ⇒ [**링크**](https://www.rinae.dev/posts/web-caching-explained-by-buying-milk-kr)
- [우아한테크세미나] 191121 우아한레디스 by 강대명님 ⇒ [**링크**](https://www.youtube.com/watch?v=mPB2CZiAkKM)

# 메모리 계층 구조

---

![Memory-Hierarchy.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/88d2f2ae-8681-4bb3-9e5d-4fb0e7a4dbdd/Memory-Hierarchy.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230302%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230302T031752Z&X-Amz-Expires=86400&X-Amz-Signature=2a19284c40ff5092895163630e243193167b739ca1453424eda3daa6706dd005&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Memory-Hierarchy.jpg%22&x-id=GetObject)

- CPU 레지스터
    - CPU 자체의 작은 메모리이다. CPU에 레지스터를 위한 공간이 많이 않기 때문에 가장 중요한 정보들만 저장이 되어 있다.
- CPU 캐시
    - 일반 메인 메모리보다 작고 빠르며 CPU에 더 가깝게 위치해 있다.
    - 주 메모리 부분의 복사본을 유지 및 관리한다.
- RAM - Main Memoery(Physical Memory)
    - CPU보다 훨씬 느리게 실행되고, 일반적으로 상태를 유지하기 위한 전원이 필요해서
      전원이 꺼지면 저장하고 있던 정보가 소실되게 된다.
      ⇒ 전원이 필요한 회로로 구성되어 있다.
- 보조 메모리
    - 정보를 장기간 저장할 수 있는 솔리드 스테이트, 하드 드라이브, CD 드라이브, 플래시 드라이브 등과 같은 것들을 가리키는 용어이다.
    - 저장된 데이터가 전원이 종료되어도 소실되지 않는다.
    - 메인 메모리보다 느리므로 보조 메모리에 저장된 정보는 프로세서가 액세스 하기 전에 메인 메모리(RAM)에 로드 되어야 한다.

# 파레토의 법칙

---

‘이탈리아의 인구의 20%가 이탈리아 전체 부의 80%를 가지고 있다’고 주장한 경제학자 빌프레도 파레토의 이름에서 따왔다고 한다. 파레토의 법칙은 ‘2080법칙’이라고도 하는데 ‘전체 결과의 80%가 전체 원인의 20%에서 일어나는 현상’을 의미한다.

> 전체 요청의 80%는 20%의 사용자가 처리를 한다.
>

- 서비스 구축 시 분석이 잘 되어있는 20프로의 데이터를 예측하면 전체 요청의 80프로에 해당하는 사용자의 요청을 더 빠르게 처리 할 수 있는 좋은 서비스를 만들 수 있다.
- 자주 사용하는 20퍼센트를 가능한 빠른 처리를 하는 곳에 몰아 넣으면
  80퍼센트의 일을 최대한 빠르게 처리할 수 잇다.

# 데이터 지역성의 원리

---

자주 쓰이는 데이터는 시간적 혹은 금전적으로 한 곳에 몰려 있을 가능성이 높다.

## 시간 지역성(Temporal Locality)

시간 지역성은 최근 접근한 데이터에 다시 접근하는 경향을 말한다.

예시로 반복문에서 인덱스 역할을 하는 변수 `i` 에는 짧은 시간안에 여러 번 접근이 이뤄진다.

```markdown
for (int i = 0; i < 10; i++) {
	arr[i] = i;
}
```

## 공간 지역성(Spatial Locality)

최근 접근한 데이터의 주변 공간에 다시 접근하는 경햠을 말한다.

위 예시에 나온 반복문의 경우 배열 `arr` 의 각 요소를 참조하면서 가까운 메모리 공간에 연속적으로 접근하고 있다. 배열의 요소들이 메모리 공간에 연속적으로 할당되기 때문이다.

⇒ 반대로 LinkedList와 같은 자료구조는 메모리의 공간에 연속적으로 할당되지 않기 때문에 공간 지역성에 해당되지 않는다.

![54877425-e73f7280-4e61-11e9-9526-d33a04c189f3.webp](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/42644e4e-85a4-444d-a840-9c2b129fade5/54877425-e73f7280-4e61-11e9-9526-d33a04c189f3.webp?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230302%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230302T031809Z&X-Amz-Expires=86400&X-Amz-Signature=682ce7e06dd79acc90c461c6f265df5510bd6496142a4aeebcdc404078a7e531&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%2254877425-e73f7280-4e61-11e9-9526-d33a04c189f3.webp%22&x-id=GetObject)

- 한 프로세스 안에도 자주 사용하는 부분과 그렇지 않은 부분이 있기 때문에 운영체제는 프로세스를 페이지(Page)라는 단위로 나눠 관리한다.
- 위 그림의 가로 축은 실행 시간이고, 세로 축은 메모리 주소다.
- 수평으로 이어진 참조 기록은 긴 시간에 걸쳐 같은 메모리 주소를 참조한 것이고, 수직으로 이어진 참조 기록은 같은 시간에 밀접한 메모리 주소들을 참조한 것이다.
- 페이지에 접근할 때도 지역성 원리가 적용된다는 것을 알 수 있다.

# 다양한 캐시들

---

- CPU - L1, L2, L3
- DRAM, HDD
- CDN(Content Delivery Network)
- HTTP Cache(웹 캐시)
- Application Cache
- Proxy Cache
- Redis(레디스)

# 모르는 키워드

---

- Race Condition
    - 두 개 이상의 프로세스가 공통 자원을 병행적으로(concurrently) 읽거나 쓰는 동작을 할 때, 공용 데이터에 대한 접근이 어떤 순서에 따라 이루어졌는지에 따라 그 실행 결과가 같지 않고 달라지는 상황을 말한다. ⇒ [**참고 링크**](https://iredays.tistory.com/125)
- 페이징(Paging)
    - 하나의 프로세스가 사용하는 메모리 공간이 연속적이어야 한다는 제약을 없애는 기법
    - 나중에 읽어볼 자료들
        - [운영체제 OS] 메모리 관리기법 - 페이징(paging)이란? ⇒ **[링크**](https://jhnyang.tistory.com/290)
        - 페이징 (Paging) ⇒ [**링크**](https://wansook0316.github.io/cs/os/2020/04/06/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9C-%EC%A0%95%EB%A6%AC-14-%ED%8E%98%EC%9D%B4%EC%A7%95.html)