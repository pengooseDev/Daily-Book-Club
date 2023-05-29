### 글로 남기면 좋겠다. 누군가는 참고자료로 쓸 수 있지 않을까?

애자일 툴은 Jira가 아닌 linear를 도입하였으며 git을 곁들인 프로젝트 작업 Flow 전략을 아래와 같이 수립하게 되었다.

문득, git + 애자일 프로세스(Ticket 기반)를 동시에 설명하는 방법론에 관련한 글을 자주 접해보지 않았던 것 같아 글로 남기면 좋겠다고 생각했다.

![](https://velog.velcdn.com/images/pengoose_dev/post/fe817c2c-0add-4e0a-901d-df171e1a91fb/image.gif)

---

## git 전략

`git-flow`

채택 근거 : FE의 인원은 2명이기 때문에 trunk based로 운영할까 생각도 했다. 하지만, 6주 기간동안 진행되는 프로젝트이기 때문에 예상치 못한 문제점이 많이 발생할 수 있다. 따라서 branch를 세분화해서 운영하는 git-flow를 채택.

빠르게 결과물을 내고, branch 관리에 사용되는 cost가 부담되는 프로젝트라면 trunk-based에 추가 branch를 만드는 것도 아주 좋은 전략이다.

---

## 각 Branch별 역할

#### feature: 기능을 구현하는 branch

- 반드시 Ticket 단위로 생성한다.
- upstream에 merge된 경우, branch를 삭제하고 ticket을 완료처리 한다.
- branch convention은 아래와 같다.

> git checkout -b feature/{작업자 이름}/{티켓}
> git checkout feature/pengooseDev/TicketBoard

#### develop: feature이 모이는 branch.

- feature이 모여 develop을 구성한다.
- release로 갈 product를 개발하는 branch이다.

#### main 배포되는 실제 프로덕트 branch

- deploy되는 branch이다.

#### release: 새롭게 배포되는 프로덕트를 준비하는 branch

#### hotfix: main branch에서 발생한 에러를 수정하는 branch

---

## Work Flow

FE 인원이 2명이라는 강점을 반드시 살릴 것.
문제점가 발생하면 빠르게 토론하고 의사결정을 내린다.

### 1. 구현할 기능 확인

### 2. FE 기능명세서 작성 (API가 필요한 경우, BE와 토론해 API 명세서 추가 작성)

### 3. 사용할 기술 및 전략 토론

사용할 기술이나 문제점을 해결할 전략의 Cost가 적절한지 토론한다.

- react-query를 사용해 캐싱을 할 것인가? 캐싱이 꼭 필요한 부분인지?
- 이미지 Assets은 어디서 관리할 것이고, 어떻게 최적화를 할 것인가?
- 개발자 도구를 사용해서 input의 validation을 파훼하는 경우 어떻게 대처할 것인지?
- 컴포넌트의 재사용성을 확보해야 하는지? 커스텀 훅을 만들 것인지? Cost대비 return이 충분한지?

FE의 기술만으로 해결하기에 `Cost가 높거나 한계가 있는 경우 BE에서 해결할 수 있는 방안을 준비해 BE에게 제시 및 상의`한다. (무작정 해줘 X)

### 4. Ticket 생성

- 토론한 기능명세서를 기반으로 Ticket을 생성한다.
- Ticket의 issue에서 토론한 것 이외의 issue가 필요한 경우 해당 Ticket의 담당자의 재량으로 생성한다.

### 5. Ticket 할당

- 자신이 원하는 Ticket을 각자 수령한다. 최대 2개의 Ticket을 보유할 수 있다.

### 6. Ticket 작업

- branch를 생성한다.
  - branch convention : feature/{작업자 이름}/{Ticket 이름}
- Ticket 작업을 시작했을 경우 Ticket의 State를 변경한다. (ToDo ⇒ In Progress)
- commit은 Ticket과 해당 Ticket의 issue기반으로 진행한다.
- `문서(Ticket, issue)로 존재하지 않는 Commit은 생성하지 않는다.`
- 추가적인 Ticket이 필요할 경우, 토론을 진행하고 Ticket의 하위 issue는 토론 이외의 것이 필요한 경우, Ticket 담당자의 재량에 맞게 생성한다.

### 7. Ticket PR

- Ticket의 하위 issue가 모두 처리되면 PR을 생성하고 코드리뷰를 요청한다.

> 본인의 origin feature/{작업자 이름}/{Ticket 이름} ⇒ upstream의 develop

### 8. Ticket 완료처리

- PR이 merge되었을 경우, `Ticket의 state를 변경`한다. (In Progress ⇒ Complete)
- Ticket을 완료처리 한 뒤, `작업한 branch는 삭제`한다.

### 8. refactoring

- PR전에 반드시 리팩터링을 최대한 진행한다.
- PR이 close된 경우, 리뷰를 기반해 리팩터링을 진행한다.
- 그날 작성한 코드의 리팩터링은 최대한 당일 진행한다.
- 아래의 것들을 항상 숙지한다.
  - 하드코딩 지양.
  - 컴포넌트 재사용성 고민하기.
  - 컴포넌트는 관심사/기능 단위로 분리.
  - Store에 등록할 것인지, State로 처리할 것인지 고민해보기.
  - 메모이징은 잘 되었는지? 굳이 메모이징을 해야하는지? Cost 고민.

---

# 추가로 고민해야 할 사항들!

## Code Convention

ESLint와 Prettier을 도입하였다.
Airbnb방식을 도입하였으며, conflict를 최소화할 수 있는 전략 중 하나이다.
사실 conflict 문제가 아니더라도 코드 컨벤션을 맞춰야 불필요한 code 변경이 발생하지 않는다.

---

## Commit Convention

좋은 커밋은 무엇인가? 나의 생각은 아래와 같다.

> 1. 커밋 로그만 확인하더라도 무슨 작업을 어떻게 진행했는지 흐름을 확인할 수 있어야 한다.
> 2. 커밋 로그와 커밋 내용이 일치해야 한다.

위의 목표를 달성하기 위해, husky를 이용해 Commit Convention을 설정했다.

이전까지 자주 실수하던 부분 중 하나가, 하나의 Commit에 여러 내용이 들어가있었다는 것이다.
이러한 실수를 신경쓰다보니 git add .을 하는 경우가 거의 없어졌다.
문제는 이전에 작성했던 코드들의 내역이 기억나지 않는 경우가 가끔 있다는 것이다.
이때, github desktop으로 코드의 변경사항을 확인하고, 기능명세서 단위의 commit을 생성하는 방식을 도입하여 문제점을 해결하게 되었다.

위 두 사항을 인지하고 Ticket기반 commit을 하다보면 커밋로그가 깔끔하고 효용성이 높아진다는 느낌을 받게 되었다.

---

## Node version

![](https://velog.velcdn.com/images/pengoose_dev/post/e322f751-5f2a-496f-8f7d-3dda752e8394/image.png)

NodeJS의 version은 18.12.0으로 통일하였다.
팀원들 간의 NodeJS version이 다를 경우, 패키지 매니저가 설치하는 의존성 모듈들의 버젼이 달라 오류가 발생할 수 있기 때문이다.
