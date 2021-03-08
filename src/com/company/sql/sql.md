# SQL

1. SQL 이란?

   - Structured Query Language의 약자
   - SQL은 관계형 데이터베이스에서 데이터를 관리하기 위해 설계된 특수 목적의 프로그래밍 언어
   - SQL 구문은 탐욕스럽기 때문에 WHERE나 LIMIT 구문을 생략하면 가능한 모든 데이터를 끌어와 출력하게 되므로 주의해야 함
   - SQL은 대소문자를 구분하지 않음

2. SQL 명령어

   - SQL 명령어는 크게 4가지 그룹으로 나뉜다
   - DDL(Data Definition Language): 데이터베이스, 테이블을 정의하는 언어

     - CREATE: 데이터베이스, 테이블등을 생성
     - ALTER: 테이블 수정
     - DROP: 데이터베이스, 테이블등을 삭제
     - TRUNCATE: 테이블 초기화

   - DML(Data Manipulation Language): 데이터베이스의 데이터를 조작하는 언어

     - SELECT: 데이터 조회
     - INSERT: 데이터 삽입
     - UPDATE: 데이터 수정
     - DELETE: 데이터 삭제

   - DCL(Data Control Language): 데이터베이스에 접근하거나 객체에 권한을 주는 언어

     - GRANT: 특정 데이터베이스 사용자에게 특정 작업에 대한 수행 권한을 부여
     - REVOKE: 특정 데이터베이스 사용자에게 특정 작업에 대한 수행 권한을 박탈

   - TCL(Transaction Control Language): 트랜젝션을 제어하는 명령어
     - COMMIT: 트렌잭션 작업을 완료한 뒤 명령어를 데이터베이스에 반영
     - ROLLBACK: 트랜잭션 작업이 완료되지 않았을 때 트렌잭션을 취소
     - SAVEPOINT: 하나의 트렌잭션을 작게 분할하여 저장
