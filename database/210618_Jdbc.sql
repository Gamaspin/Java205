-- JDBC

select * from dept01;

create table dept01
as
select * from dept
where 1=0
;
drop table dept01;

insert into dept01 values (dept01_deptno_seq.nextval, 'dev', 'SEOUL');

-- dept01 deptno에 입력할 일련 번호 -> sequence
create sequence dept01_deptno_seq
increment by 10
start with 10
;

delete from dept01 where deptno = ?
;


update dept01 set dname = ?, loc = ? where deptno = ?
;

