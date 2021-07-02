--2021.06.15

-- DDL : 데이터 정의어


-- 테이블 생성 : create table
-- 테이블 수정 : alter table
-- 테이블 삭제 : drop table

-- 칼럼 추가 : add column   (테이블 맨 마지막에 추가됨. 이는 고정이므로 원하는 위치에 추가 불가능함)
-- 칼럼 수정 : modify column
-- 칼럼 삭제 : drop column








-- 서브 쿼리를 이용해서 기존 테이블의 구조를 복사하고 해당 튜플도 복사
   --내용은 가져오나, 제약 조건은 가져오지 않음. -> 추후 제약 조건을 따로 가져와주어야 함
   --백업용으로 주로 쓰임
create table emp02
as
select * from emp
;
select * from emp02 ;

create table emp03
as
select empno, ename, sal from emp
;
select * from emp03 ;

create table emp04
as
select * from emp where deptno = 30
;
select * from emp04 ;

-- 구조만 가져오고자 할 때 (일부러 false 값을 대입함)
create table emp05
as
select * from emp where 1 = 2
;
select * from emp05 ;






------------------------------------------------------------------

-- alter table {테이블 이름} drop

-- emp01 테이블에 job 칼럼을 추가해보자
alter table emp01
add( job varchar2(9) )
;
desc emp01;

-- emp01 테이블의 job 칼럼의 사이즈를 수정 9->30
alter table emp01
--modify( job varchar2(30) )
modify( job varchar2(130) not null )
;


-- emp01 테이블의 job 칼럼을 삭제
alter table emp01
drop column job
;

drop table emp05;


-- 모든 행을 삭제 : 주의)롤백이 안된다.
truncate table emp02;


-- 테이블의 이름 변경
-- rename (old_name) to (new_name) ;
rename emp01 to emp99;
desc emp99;



------------------------------------------------------------------


create table emp02
as
select empno, ename, sal, job from emp where 1=0
;
desc emp02;
drop table emp02;

insert into emp02(empno, ename, sal, job, deptno) 
            values(1000, 'SON', 2300, 'CHEIF', 20);
insert into emp02(empno, ename, sal) values(1000, 'SON', 2300);
--insert into emp02 values(null, null, 10000, 'CHEIF');


create table emp02 (
            empno number(4) primary key, --not null unique,
            ename varchar2(20) not null,
            sal number(6,2) check (sal > 500 and sal < 5000),
            job varchar(20) default '미지정',
            deptno number references dept(deptno)
);

select * from emp02;








