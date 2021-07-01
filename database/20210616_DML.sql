-- 2021.06.16

-- DML 

-- 데이터 입력 : 행 단위 입력
-- insert into 테이블명 (컬럼명, ..., ...) values (데이터, 데이터, 데이터);
-- 입력하고자 하는 컬럼과 입력 데이터의 개수는 일치해야 함
-- 컬럼의 도메인과 입력 데이터의 타입 또한 일치해야 함
-- 기본키(Primary key)와 같이 not null인 경우 컬럼을 생략하면 안됨 (개체무결성 위반)




-- 테스트 테이블 생성
create table dept01
as
select * from dept where 1=0
;
desc dept01;
select * from dept01;

-- 1번 부서 개발팀 서울 위치
insert into dept01 (deptno, dname, loc) 
            values (10, '개발팀', '서울')
;


-- 데이터 저장할 컬럼 기술을 생략 가능함
-- -> 모든 컬럼의 데이터를 입력할 때
-- values 절의 데이터 순서를 -> 테이블이 생성될 때 정의된 컬럼의 순서 : desc (테이블이름) 으로 순서 확인
desc dept01;
insert into dept01 values (20, '마케팅', '부산')
;



rollback;

desc orders;

insert into orders(orderid, custid, bookid) values (11, 6, 11);





-- 데이터를 변경 : 행 단위로 선택하고 변경하고자 하는 컬럼을 기술
-- update (테이블명) SET (컬럼이름 = 새 데이터, 컬럼이름2 = 새 데이터2, ...)
--                    WHERE (행을 선택하는 조건)

-- 기본 설정
create table dept03
as
select * from dept
;
select * from dept03;

-- 모든 부서의 위치를 SEOUL로 이동
update dept03
set loc = 'SEOUL'
--where loc
;

-- 10번 부서의 위치를 PUSAN으로 이동, 부서명을 DEV로 변경
update dept03
set loc = 'PUSAN', dname = 'DEV' -- null 값 입력 가능
where deptno = 10
;


-- emp01 새롭게 생성하고 update
drop table emp01;

create table emp01
as select * from emp;

select * from emp01;

-- 모든 사원의 부서번호를 30번으로 수정합시다.
update emp01
set deptno = 30
;

-- 모든 사원의 급여를 10% 인상시키기
update emp01
set sal = sal * 1.1
;

-- 모든 사원의 입사일을 오늘로 수정
update emp01
set hiredate = sysdate  --'21.06.16'
;

rollback;
select * from emp01;

-- 부서 번호가 10번인 사원의
-- 부서 번호를 30번으로 수정하기
update emp01
set deptno = 30
where deptno = 10
;

-- 급여가 3000 이상인 사원만 급여를 10% 인상시키기
update emp01
set sal = sal * 1.1
where sal >= 3000
;

-- 1981년에 입사한 사원의 입사일을 오늘로 바꾸기
update emp01
set hiredate = sysdate
where substr(hiredate, 1, 2) = '81'
--where hiredate like '81%'
;

-- SCOTT 사원의 부서 번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하기
update emp01
set deptno = 20, job = 'MANAGER'
where ename = 'SCOTT'
;

-- SCOTT 사원의 입사일을 오늘로, 급여를 50으로, 커미션을 4000으로 수정하기
update emp01
set hiredate = sysdate, sal = 50, comm = 4000
where ename = 'SCOTT'
;

select * from emp01;



---------------------------------
-- 서브 쿼리를 이용한 데이터 수정하기

-- dept01 새롭게 생성하고 update
drop table dept01;

create table dept01
as select * from dept;

select * from dept01;

rollback;

-- 20번 부서의 지역명을
-- 40번 부서의 지역명으로 변경하기 (서브 쿼리 이용)
update dept01
set loc = (select loc from dept01 where deptno = 40)
where deptno = '20'
;
-- 40번 부서의 지역명 구하는 쿼리
select loc from dept01 where deptno = 40
;

-- 서브쿼리를 이용해 한번에 두 개의 컬럼값 변경하기 (단일행의 값으로부터만 변경 가능함)
update dept01
set (dname, loc) = (select dname, loc from dept01 where deptno = 10)
where deptno = 20
;



-- 데이터의 삭제 : 행단위 삭제 (truncate 삭제 시 롤백 안되므로 매우 주의!!)
-- DELETE from (테이블이름) where (조건) ;

-- dept01 테이블의 모든 데이터를 삭제하자
delete from dept01
;

-- 이름이 SCOTT인 사원을 삭제하기
delete from emp01 where ename = 'SCOTT'
;

select * from emp01 ;


-- 사원 테이블에서 부서명이 SALES인 사원을 모두 삭제하기
    -- 부서번호를 통해 SALES 부서의 사원들 삭제하기
delete from emp01 where deptno = (
                    select deptno from dept where dname = 'SALES')
;

    -- 부서명이 SALES인 부서의 부서번호 찾기
select deptno from dept where dname = 'SALES'
;

