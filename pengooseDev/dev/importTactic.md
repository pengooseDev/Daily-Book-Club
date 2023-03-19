하나의 폴더에서 여러가지 모듈을 import할 경우 아래와 같은 문제가 발생한다.

```tsx
import Add from 'assets/icons';
import User from 'assets/icons';
import Shuffle from 'assets/icons';
import Toggle from 'assets/icons';
import Exit from 'assets/icons';
import Upload from 'assets/icons';
import Login from 'assets/icons';
import Logout from 'assets/icons';
```

import를 어떻게하면 깔끔하게 정리할 수 있을까 고민하던 차에, 사부님과 export 방식에 대한 토론을 하던 도중 해결책을 깨닫게 되었다.

> 사부님 : Pengoose님. 하나의 폴더에서 export default한 모듈들을 하나로 묶어주는 index파일을 만든 뒤, 해당 level의 모듈들을 import하여 다시 export한다면 깔끔하게 관리가 가능합니다!

!!! 🥳🥳🥳

---

### 적용

![](https://i.imgur.com/aPnTFhz.png)
위의 사례에선 shared 폴더에서 export default한 Providers와 Nav가 존재한다.

```tsx
const Nav = () => {
  return (
    <Wrapper>
      <LeftWrapper></LeftWrapper>
      <RightWrapper>
        <User />
        <ThemeToggle />
      </RightWrapper>
    </Wrapper>
  );
};

export default Nav;
```

이러한 export default된 값들을 한 번에 관리할 수 있는
index.tsx를 만들어 이를 import한다.

### index

해당 level의 모듈들을 전부 import 한 뒤, 각각 export 해준다.

```tsx
// /shared/index.tsx
export { default as Nav } from './Nav';
export { default as Providers } from './Providers';
```

아래와 같은 방식으로도 해결 가능하다는 강준님의 조언!!
![](https://i.imgur.com/XH1FrRP.png)

shared 내부에서 Nav, Providers와 같은 컴포넌트를 export default하고, 이를 하나로 합치는 하나의 index 모듈이 import받아 다시 export하는 모습은 마치 객체가 DI하는 과정과 굉장히 닮아있다.

---

### 결과

결과적으로 아래와 같은 깔끔한 import가 가능해진다.
![](https://i.imgur.com/sWNwrcV.png)

오늘도 맛있는 지식 감사합니다 🥳
