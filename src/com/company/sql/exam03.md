# DCL(Data Control Language)

1. GRANT
-- 권한 부여
    > GRANT 권한종류 ON 대상 TO 계정명 IDENTIFIED BY 암호 [WITH GRANT OPTION]
    
    -- 모든 권한을 가진 계정 생성 
    > GRANT ALL ON *.* TO test@localhost IDENTIFIED BY "test1"; 
    
    -- 특정 데이터베이스에 조회권한을 가진 계정 생성 
    > GRANT SELECT ON test.* TO test@localhost IDENTIFIED BY "test1"; 
    
    -- GRANT로 계정 생성 후 아래의 명령어를 실행해야 적용됨 
    > FLUSH privileges;


2. REVOKE
-- 권한 부여 해제
    > REVOKE insert, update, create ON [DB명.테이블명] TO [user@host]; 
    
    -- 전체 권한 해제 명령어 
    > REVOKE ALL ON [DB명.테이블명] TO [user@host];

