# 🔗 참고자료

---

- Clustered Index & Non-Clustered Index ⇒ [**링크**](https://velog.io/@gillog/SQL-Clustered-Index-Non-Clustered-Index)
- [MySQL] 인덱스(index), 클러스터/보조인덱스 ⇒ [**링크**](https://jie0025.tistory.com/107)

# ✏공부 내용 정리

---

## **Clustered Index**

- 테이블 생성 시 하나의 열에 Primary Key 를 지정하면 자동으로 Clustered Index가 생성된다.
- 클러스터형 인덱스는 데이터가 알파벳순으로 정렬되는 사전과 동일합니다.
- 테이블의 데이터를 정렬해서 저장되는 순서를 정의한다.
- 테이블당 하나만 생성 가능하다.

![Clustered_Index.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/3e944e20-4ce1-41ed-93eb-a04e51ca8de0/Clustered_Index.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142628Z&X-Amz-Expires=86400&X-Amz-Signature=a6cb53624968643be84922a7799a59866b929602eafeee2e264baa4d86e90391&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Clustered_Index.jpg%22&x-id=GetObject)

위와 같이 클러스터형 인덱스에서 인덱스는 블록에 대한 포인터를 포함하지만,
직접 데이터는 포함하지 않는다.

```sql
create table Student
( Roll_No int primary key, 
Name varchar(50), 
Gender varchar(30), 
Mob_No bigint );

insert into Student
values (4, 'ankita', 'female', 9876543210 );

insert into Student 
values (3, 'anita', 'female', 9675432890 );

insert into Student 
values (5, 'mahima', 'female', 8976453201 );
```

위 예시 SQL 문에서는 Roll_No가 Primary Key이며, 자동으로 클러스터형 인덱스로 작동한다.

## **Non Clustered Index**

![색인.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d0c3cff7-d1bb-49c6-9c00-0984366e23e0/%EC%83%89%EC%9D%B8.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142615Z&X-Amz-Expires=86400&X-Amz-Signature=fadf38d806e6de6d8f1e6a3a6c07b156b5809f507aa5365ee93b806452a7bcc3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EC%2583%2589%25EC%259D%25B8.jpg%22&x-id=GetObject)

- UNIQUE KEY
- 테이블당 여러 개 생성 가능하다.
- 책의 색인과 유사합니다.
    - 책의 색인은 장 이름과 페이지 번호로 구성되며, 어떤 주제나 장을 읽으려면 해당 책의 색인을 사용하여 해당 페이지로 바로 이동할 수 있습니다.
    - 책의 모든 페이지를 훑어 볼 필요가 없습니다.
- 데이터는 한 곳에 저장되고 인덱스는 다른 곳에 저장됩니다.
- 데이터와 비클러스터형 인덱스는 별도로 저장되므로 테이블에 여러 개의 비클러스터형 인덱스를 가질 수 있습니다.
- 인덱스는 해당 데이터의 위치에 대한 포인터를 포함하고 있다.

![Non-clustered_Index.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/3b317d1d-8339-4509-9409-1ee38f77bcab/Non-clustered_Index.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142604Z&X-Amz-Expires=86400&X-Amz-Signature=6db1c1014f41610697db48d3ad6059360b3f2e15369f16d9508f1b2c025bb230&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Non-clustered_Index.jpg%22&x-id=GetObject)

```sql
create table Student
( Roll_No int primary key, 
Name varchar(50), 
Gender varchar(30), 
Mob_No bigint );

insert into Student 
values (4, 'afzal', 'male', 9876543210 );

insert into Student 
values (3, 'sudhir', 'male', 9675432890 );

insert into Student 
values (5, 'zoya', 'female', 8976453201 );

/* Microsoft SQL Server의 SQL문 */
create nonclustered index NIX_FTE_Name
on Student (Name ASC);

/* Mysql의 SQL문 */
create unique index NIX_FTE_Name on Student (Name ASC);
```

- 위 예시는 Microsoft SQL Server의 SQL 문이다.