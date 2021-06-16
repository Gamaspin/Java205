-- 2021.06.16

-- VIEW
-- 자주 사용하는 sql문을 매번 입력하기 보다 빠르고 편하게 사용하기 위해서


-- create or replace view
-- force : 기존 테이블의 존재 여부에 상관없이 뷰를 생성한다
-- 


-- 뷰 생성
create or replace view emp_view30
as
select empno, ename, deptno
from emp
where deptno = 30
;

-- 뷰 활용
select * from emp_view30
where ename = 'JAMES'
;

-- 뷰 삭제
drop view emp_view30;


-- 인라인 뷰를 이용한 TOP 3 구하기
select rownum, ename  -- rownum이 뒤죽박죽임
from emp
order by hiredate
;


select rownum, ename
from (select * from emp order by ename)
;

-- 입사일이 빠른 사람 5명만 (TOP N)을 얻어오기
select rownum, ename, hiredate
from (select * from emp order by hiredate)
where rownum < 6
;


select * from emp order by hiredate;

-- 뷰 생성 및 활용
create or replace view view_HIRE
as
select * from emp order by hiredate
;

select rownum, ename, hiredate
from view_HIRE
;
select rownum, ename, hiredate
from view_HIRE
where rownum < 6
order by ename
;



-- Sequence : 번호 재생기
create sequence pi_idx_pk;

select pi_idx_pk.nextval
from dual;

select pi_idx_pk.currval
from dual;