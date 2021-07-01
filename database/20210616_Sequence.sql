-- 20210617

-- 시퀀스 : 숫자를 생성하는 객체
--      설정을 통해 일련번호를 생성 -> 기본키가 대리키인 경우 입력되는 값으로 사용

-- Sequence : 번호 재생기
create sequence pi_idx_pk;

select pi_idx_pk.nextval
from dual;

select pi_idx_pk.currval
from dual;



CREATE SEQUENCE DEPT_DEPTNO_SEQ 
INCREMENT BY 10 
START WITH 10;

-- currval : 현재 값 반환
-- nextval : 현재 시퀀스값의 다음 값을 반환



-- dept 테이블 복사 -> deptno에 들어갈 데이터 시퀀스 생성 -> insert 테스트
drop table dept03;

create table dept03
as select * from dept where 1=0
;

select * from dept03;

create sequence dept_deptno_seq
increment by 10     -- 10씩 증가한다
start with 10       -- 10에서 시작한다.
;

-- dept03에 저장
insert into dept03 values (10, 'DEV', 'Seoul')
;

insert into dept03 values (DEPT_DEPTNO_SEQ.nextval, 'ACC', 'GyeongGi')
;

insert into dept03 values (DEPT_DEPTNO_SEQ.currval, 'MARKETING', 'YongSan')
;

insert into dept03 values (DEPT_DEPTNO_SEQ.nextval, 'SALES', 'GangNam')
;











