# Select 쿼리 순서


````
SELECT
FROM
WHERE
GROUP BY
HAVING
ORDER BY
````
위와 같은 순서를 작성 했다고 해서 DB가 내부적으로 위 순서대로 작동 하는 것은 아니다.


# Select문 수행 순서
![select쿼리_수행순서.png](select쿼리_수행순서.png)
1. FROM
    - 어떤 테이블을 액세스 해야되는지 확인
    - FROM 절에서 적혀 있는 테이블들이 정말로 존재하는 테이블인지 확인
    - select권한이 있는지도 체크
    - select, update 권한이 없는데 날리는 경우 DB가 semantic error를 내뱉는다
2. WHERE
    - 테이블에서 where절의 조건에 맞는 로우들을 가져온다.
3. GROUP BY
    - 가져온 로우들을 어떤 방식으로 group by 할 지 체크
4. HAVING
    - group by 한 것 중에서 혹시 버려야 할 데이터들이 있느지 체크
5. SELECT
    - 가져온 로우 중에서 어떤 컬럼들을 출력 해야되는지 체크
6. ORDER BY
    - 필요한 모든 컬럼들까지 다 가지고 왔다라고 했을 때 정렬을 하게 된다.
    - order by 절이 select 절보다 더 늦게 수행이 되기 때문에
      select 절의 컬럼에 alias를 지정해 놨을 경우에 우리가 order by 절에도 사용할 수 있다.  
      => select 절이 먼저 수행되기 때문이다.  
      => group by에서는 순서 상으로 불가능하기 때문에 slecet절의 alias를 사용할 수 없다.





위 수행 순서를 보면 일단 다 가져오고 난 다음에 select 절을 체크하기 때문에  
SELECT * FROM 한 것과  
SELECT 컬럼 FROM 한 것과는 사실상 드는 비용은 같다.  
=> I/O 비용이 같다.  

  
❗❗SELECT 절에 있는 컬럼들이 모두 인덱스에 담겨있다라고 할 때는 조금 다른 문제가 된다.
