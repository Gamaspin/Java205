-- 210617

-- INDEX : 검색을 빠르게 하기 위한 객체
-- 물리적인 저장 공간이 필요
-- 생성 시간이 필요
-- 많은 index는 DML 작업이 많은 경우 성능 저하가 오게 된다!!


-- create index 인덱스이름
-- on 테이블이름 (칼럼이름)
-- ;



-- emp01 테이블을 복사 -> 로우들을 계속 복사

drop table emp01;
create table emp01
as select * from emp;
select * from emp01;

-- 데이터가 2배씩 증가
insert into emp01 select * from emp01;


insert into emp01 (empno, ename) values (7777, 'LUCKY') ;


select * from emp01 where ename = 'LUCKY';
select * from emp01 where ename = 'SCOTT';


-- emp01 테이블에 ename 컬럼을 index 설정
create index index_emp01_ename
on emp01(ename)
;





