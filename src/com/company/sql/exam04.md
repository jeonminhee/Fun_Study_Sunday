# TCL(Transaction Control Language)

1. COMMIT
-- 트렌잭션 작업이 완료 되었을 때 결과값을 저장하는 명령어
    > COMMIT;


2. ROLLBACK
-- 트랜젝션 작업이 완료되지 않았을 때 이전 결과로 되돌리는 명령어
    > ROLLBACK;

3. SAVEPOINT
-- 트랜젝션 작업 중간에 책갈피처럼 저장할 수 있는 명령어
    > SAVEPOINT 별칭;
    - 예제
        > update student set kor=100 where name='김큐엘';
        > SAVEPOINT kor;
        > update student set eng=100 where name='김큐엘';
        > SAVEPOINT eng;
        > update student set math=100 where name='김큐엘';
        > SAVEPOINT math;

        -- 영어점수를 바꾼 직후로 변경
        > ROLLBACK to eng

