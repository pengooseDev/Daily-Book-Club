# π μ°Έκ³ μλ£

---

- Clustered Index & Non-Clustered Index β [**λ§ν¬**](https://velog.io/@gillog/SQL-Clustered-Index-Non-Clustered-Index)
- [MySQL] μΈλ±μ€(index), ν΄λ¬μ€ν°/λ³΄μ‘°μΈλ±μ€ β [**λ§ν¬**](https://jie0025.tistory.com/107)

# βκ³΅λΆ λ΄μ© μ λ¦¬

---

## **Clustered Index**

- νμ΄λΈ μμ± μ νλμ μ΄μ Primary Key λ₯Ό μ§μ νλ©΄ μλμΌλ‘ Clustered Indexκ° μμ±λλ€.
- ν΄λ¬μ€ν°ν μΈλ±μ€λ λ°μ΄ν°κ° μνλ²³μμΌλ‘ μ λ ¬λλ μ¬μ κ³Ό λμΌν©λλ€.
- νμ΄λΈμ λ°μ΄ν°λ₯Ό μ λ ¬ν΄μ μ μ₯λλ μμλ₯Ό μ μνλ€.
- νμ΄λΈλΉ νλλ§ μμ± κ°λ₯νλ€.

![Clustered_Index.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/3e944e20-4ce1-41ed-93eb-a04e51ca8de0/Clustered_Index.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142628Z&X-Amz-Expires=86400&X-Amz-Signature=a6cb53624968643be84922a7799a59866b929602eafeee2e264baa4d86e90391&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Clustered_Index.jpg%22&x-id=GetObject)

μμ κ°μ΄ ν΄λ¬μ€ν°ν μΈλ±μ€μμ μΈλ±μ€λ λΈλ‘μ λν ν¬μΈν°λ₯Ό ν¬ν¨νμ§λ§,
μ§μ  λ°μ΄ν°λ ν¬ν¨νμ§ μλλ€.

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

μ μμ SQL λ¬Έμμλ Roll_Noκ° Primary Keyμ΄λ©°, μλμΌλ‘ ν΄λ¬μ€ν°ν μΈλ±μ€λ‘ μλνλ€.

## **Non Clustered Index**

![μμΈ.jpg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d0c3cff7-d1bb-49c6-9c00-0984366e23e0/%EC%83%89%EC%9D%B8.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230207%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230207T142615Z&X-Amz-Expires=86400&X-Amz-Signature=fadf38d806e6de6d8f1e6a3a6c07b156b5809f507aa5365ee93b806452a7bcc3&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EC%2583%2589%25EC%259D%25B8.jpg%22&x-id=GetObject)

- UNIQUE KEY
- νμ΄λΈλΉ μ¬λ¬ κ° μμ± κ°λ₯νλ€.
- μ±μ μμΈκ³Ό μ μ¬ν©λλ€.
    - μ±μ μμΈμ μ₯ μ΄λ¦κ³Ό νμ΄μ§ λ²νΈλ‘ κ΅¬μ±λλ©°, μ΄λ€ μ£Όμ λ μ₯μ μ½μΌλ €λ©΄ ν΄λΉ μ±μ μμΈμ μ¬μ©νμ¬ ν΄λΉ νμ΄μ§λ‘ λ°λ‘ μ΄λν  μ μμ΅λλ€.
    - μ±μ λͺ¨λ  νμ΄μ§λ₯Ό νμ΄ λ³Ό νμκ° μμ΅λλ€.
- λ°μ΄ν°λ ν κ³³μ μ μ₯λκ³  μΈλ±μ€λ λ€λ₯Έ κ³³μ μ μ₯λ©λλ€.
- λ°μ΄ν°μ λΉν΄λ¬μ€ν°ν μΈλ±μ€λ λ³λλ‘ μ μ₯λλ―λ‘ νμ΄λΈμ μ¬λ¬ κ°μ λΉν΄λ¬μ€ν°ν μΈλ±μ€λ₯Ό κ°μ§ μ μμ΅λλ€.
- μΈλ±μ€λ ν΄λΉ λ°μ΄ν°μ μμΉμ λν ν¬μΈν°λ₯Ό ν¬ν¨νκ³  μλ€.

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

/* Microsoft SQL Serverμ SQLλ¬Έ */
create nonclustered index NIX_FTE_Name
on Student (Name ASC);

/* Mysqlμ SQLλ¬Έ */
create unique index NIX_FTE_Name on Student (Name ASC);
```

- μ μμλ Microsoft SQL Serverμ SQL λ¬Έμ΄λ€.