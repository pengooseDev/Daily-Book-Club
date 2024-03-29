
<img src="https://velog.velcdn.com/images/yarogono/post/8e61fca5-6f52-4772-865b-a98269e0b523/image.png">



JPA를 사용하면서 Boolean이 직관적이고 사용하기 편해서 위와 같이 사용했습니다.
ORM을 사용하면서 데이터베이스에 어떻게 저장되는지 고려해보지 않은게 큰 문제인 것 같아 좀 더 찾아보게 되었습니다.


<br/>

# Boolean타입은 DB에 어떻게 저장 될까?

```
create table USER
(
    users_id bigint generated by default as identity,
    username varchar(255),
    enabled BOOLEAN
);
````
위의 예시는 Boolean 타입 칼럼을 만드는 DDL이다.



<img src="https://velog.velcdn.com/images/yarogono/post/7f32dd36-8182-4dc4-9030-ebe3e3b53267/image.png">

MariaDB에서의 Boolean타입으로 저장 시 데이터 타입은 'bit'이다.


<br/>
<img src="https://velog.velcdn.com/images/yarogono/post/763b072d-92b1-4793-9afb-ba5dc26c1fb4/image.png">

MySQL에서의 Boolean 저장 시 데이터 타입은 'tinyint' 이다.

결국에 MySQL, MariaDB 둘다 Ture, False가 아니라 전혀 다른 데이터 타입으로 입력된다.
tinyint와 bit로 입력되면
`0 => false`
`1 => true`
이다.


예상했던 방식과는 전혀 다른 값으로 들어가게 되는 것이다.
0은 false로 1은 true라고 약속하고 개발을 진행하면 문제 없지 않을까라는 생각도 했지만,
문제점이 무엇일지 고민하고 자료를 더 찾아봤다.



<br/>

# Boolean 타입으로 저장의 문제점들
-------

- DB마다 저장되는 방식이 다르고 심지어 지원을 안하는 DB도 있다.
    - MySql에서 BOOLEAN 타입은 5버전대부터 사용이 가능하다.
    - Oracle에서는 BOOLEAN 타입이 없다고 한다([참고 링크](https://stackoverflow.com/questions/3726758/is-there-any-boolean-type-in-oracle-databases))


만약에 Boolean 타입을 사용하지 않는 DB를 사용하게 되거나,
MySQL에서 오라클로 변경 한다면 어떻게 될까?

각 DB마다 Boolean 타입의 지원여부와 실제 저장되는 데이터를 알고 있으면 대처가 가능할 것 같다고 생각했다. 하지만 이 내용을 모르고 그냥 사용한다면 상당한 문제가 될 것 같다.


그리고 MySQL의 경우에 insert문을 사용해서 Boolean 타입 컬럼에 0, 1 이 아닌 3을 넣으면,
3으로 저장이 되는 부분도 주의해야 할 부분이다.


<br/>

# Boolean 타입 대신 다른 방법은 없을까?
-------

결론적으로 멘토님이 리뷰해주신 의견인 Enum으로 변경을 했다.

User Entity 코드
```
@Column(nullable = false)
@Enumerated(EnumType.STRING)
private UserState userState;
```


UserState Enum 코드
```
@Getter
@AllArgsConstructor
public enum UserState {
    Enabled("활성화"),
    Disabled("비활성화")
    ;

    private String description;
}
```

<img src="https://velog.velcdn.com/images/yarogono/post/421dcf43-61a0-4dce-b725-63f049f0b3e3/image.png">

위와 같은식으로 데이터가 들어가게 된다.  
Enum으로 처리 시의 이점은 아무래도 0, 1 보다는 더 이해하기 편하고,
원하는 형식으로 데이터를 저장할 수 있다.

그리고 ``@Enumerated(EnumType.STRING)`` 어노테이션을 작성하고 저장하면 문자열 자체가 저장된다.


<br/>

# 느낀점
---

JPA와 같은 ORM을 하면서 추상화된 SQL, DB를 등한시하면 안되겠다고 느꼈다.
ORM을 사용한다고 해도 결국에는 SQL문이 실행 되어 DB에 저장되는 것이다.
각 DB의 데이터 타입이 어떻게 저장되고 어떻게 처리 되는지 까지도 고려를 해야 하는 것이다.

위 내용을 작성 하면서 고민 했던 부분은 char, varchar의 차이에 대해서도 고민했다.
char는 고정형, varchar는 가변형인 것에 대한 지식 뿐만 아니라,
'DB에 저장 시 어떻게 처리 될까' 라는 고민도 하게 되었다.

사용하는 도구에게 주객전도가 되지 말고, 끊임없이 의문을 가지고 공부하자.


<br/>

# 참고자료
- MariaDB(공식문서) - BOOLEAN => [링크](https://mariadb.com/kb/en/boolean/)
- 당근마켓 기술블로그 - MySQL BOOLEAN 컬럼 => [링크](https://medium.com/daangn/mysql-boolean-%EC%BB%AC%EB%9F%BC-7abd9b35c664)