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



















