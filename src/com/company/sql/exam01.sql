# DDL(Data Definition Language)


1. CREATE
-- 테이블 생성

> CREATE table [테이블명]
(컬럼명, 데이터유형(길이) ... ,
컬럼명, 데이터유형(길이) ... ,
컬럼명, 데이터유형(길이) ...) ;

> create table student (
    name varchar(50) not null,
    kor int not null,
    eng int not null,
    math int not null,
    sum int not null,
    aver float
  );

> DESC student // 만들어진 테이블 내용 확인

2. ALTER
-- 테이블 변경

> ALTER table 테이블명
명령어;

> ALTER table student
add sci int not null;

* 명령어 종류
    1. 테이블 형식 변경:
        -Engine : ALTER TABLE 테이블 명 ENGINE=형식;
        -Type: ALTER TABLE 테이블 명 TYPE = 형식;

    2. 테이블 이름 변경
        - ALTER TABLE 테이블 명 RENAME 바꿀이름;
        - RENAME TABLE 테이블 명 TO 바꿀이름;

    3. 칼럼추가
        - 마지막에 추가: ALTER TABLE 테이블 명 ADD COLUMN 칼럼명 타입
        - 지정칼럼뒤에: ALTER TABLE 테이블 명 ADD COLUMN 칼럼명 타입 AFTER 이름
        - 제일 앞에: ALTER TABLE 테이블 명 ADD COLUMN 칼럼명 타입 FIRST

    4. 칼럼삭제
        - ALTER TABLE 테이블 명 DROP COLUMN 칼럼명

    5. 칼럼 변경
        - ALTER TABLE 테이블 명 MODIFY 칼럼이름 새칼럼타입
        - ALTER TABLE 테이블 명 CHANGE 칼럼이름 새칼럼이름 새칼럼타입

    6. 인덱스에 새 항목 추가
        - ALTER TABLE 테이블 명 ADD INDEX(칼럼이름)

    7. 인덱스 삭제
        - ALTER TABLE 테이블 명 DROP INDEX 칼럼이름
        - DROP INDEX 인덱스 이름 ON 테이블명

    8. 기본키(PRIMARY KEY)지정하기
        - ALTER TABLE 테이블 명 ADD PRIMARY KEY(칼럼이름)

    9. 기본키 삭제
        - ALTER TABLE 테이블 명 DROP PRIMARY KEY

3. DROP
-- 테이블 삭제

> DROP table 테이블명 [, 테이블명]

> DROP table student;

4. TRUNCATE
-- 테이블 초기화, 테이블에서 모든 행을 삭제

> TRUNCATE table 테이블명 [, 테이블명]

> TRUNCATE table student;
-- student 테이블만 남고 내부 행은 전부 지워짐