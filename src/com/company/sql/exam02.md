# DML(Data Manipulation Language)

1. INSERT
-- 데이터 삽입

> insert into 테이블명 values(값,....);

> INSERT into student values(김큐엘, 80, 30, 80);

2. UPDATE
-- 데이터 수정

> update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건...;

> update student set kor=100, eng=70 where name='김큐엘';

3. DELETE
-- 데이터 삭제

> delete from 테이블명 where 조건;

> DELETE from student where name='김큐엘';

4. SELECT
-- 데이터 조회

> SELECT 속성이름 
FROM 테이블이름 
(WHERE 검색조건)
(GROUP BY 속성이름)
(HAVING 검색조건)
(ORDER BY 속성이름 (ASC | DESC))

> SELECT name FROM student WHERE kor > 90;

    1. SELECT 속성이름 FROM 테이블이름
        - 데이터 조회의 가장 기본
        - '테이블이름'에 있는 '속성'을 가져오는 명령어

    2. WHERE 검색조건
        - 조건에 맞는 검색을 할 때 사용
        - 조건으로 사용할 수 있는 연산자
            - 비교: =, <, >, <=, >=
            - 범위: BETWEEN
            - 집합: IN, NOT IN
            - 패턴: LIKE
                - "-": 한 글자와 대치(ex. "A-B": "A1B", "A2B"...가능 / "A123B" 불가능)
                - "%": 0개 이상의 글자와 대치(ex. "A%B": "A1B", "A123B"...가능)
            - NULL: IS NULL, IS NOT NULL
            - 복합 조건: AND, OR, NOT

    3. GROUP BY 속성이름
        - 데이터를 원하는 그룹으로 나눌 수 있음
        - GROUP BY 는 반드시 그룹 함수와 함께 쓰이며 결과값은 GROUP BY에 기술된 속성에 의해 결정
        - 집계 함수(그룹 함수): 테이블의 각 열에 대해 계산하는 함수
            - COUNT: 행의 수 계산
            - MAX: 최대값 반환
            - MIN: 최소값 반환
            - AVG: 평균값 산출
            - SUM: 총 합계 계산
        > select sum(kor, eng, math) from student group by name;
        -- 이름별로 학생들의 성적의 총합이 계산됨

    4. HAVING 검색조건
        - GROUP BY와 거의 동일하지만, 속성 이름이 아닌 검색 조건에 그룹 함수만 포함 가능
        - 일반 조건은 WHERE에 기술하지만 그룹함수를 포함한 조건은 HAVING에 기술
        > select sum(kor, eng, math) from student group by name having avg(kor, eng, math) < 70;
        -- 학생들의 성적의 총합 중, 평균 점수가 70점을 초과하는 학생들만 계산됨

    5. ORDER BY 속성이름 (ASC | DESC)
        - 보통 select문을 실행할 때에는 테이블에 입력된 순서대로 출력되지만, 내림차순이나 오름차순으로 정렬된 데이터가 필요할 때 쓰이는 구문
        - 정렬하고자 하는 속성이름에 맞춰 오름차순, 또는 내림차순으로 정렬
        - ASC는 오름차순, DESC는 내림차순 (기본은 ASC)

    6. DISTINCT & ALL
        - ALL 
            - 모든 데이터를 가져올 수 있음 
            - ALL은 생략 가능함
            - ex. select all kor from student; //모든 국어 점수가 보여짐
        - DISTINCT 
            - 조회하려는 칼럼의 중복값을 제거
            - ex. select distinct kor from student //모든 국어 점수들 중 중복되는 점수는 하나로 보여짐

    7. concat & as
        - concat 
            - 여러 문자열을 하나로 합치는 명령어
        - as
            - 출력 라벨명을 지정하는 명령어
            - 라벨명을 지정하지 않으면 컬럼명이 라벨명이 됨
            - ex. select sum(kor, eng) as koreng from student;
            - 공백을 넣고 싶으면 ''를 이용
            - ex. select sum(kor, eng) as 'kor eng' from student;
    
    8. UNION
        - union
            - select 결과를 합치는 명령어
            - 중복 값을 자동으로 제거해줌
            - ex. select kor from student union select eng from student;
        - union all
            - select 결과를 합치는 명령어
            - 중복 값을 제거하지 않음
            - ex. select kor from student union all select eng from student;