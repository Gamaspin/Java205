select *
from emp
;


CREATE TABLE SALGRADE
(GRADE NUMBER,
LOSAL NUMBER,
HISAL NUMBER);

INSERT INTO SALGRADE VALUES (1, 700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);

commit;

select *
from salgrade
;


select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal) > 2900
;



-- 이름 : emp, 부서명 : dept
select e.ename, d.dname, d.deptno
from emp e, dept d
where e.deptno = d.deptno   --and enmae = 'SCOTT'
order by d.dname, e.ename
;


select distinct e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
--where e.sal >= s.losal and e.sal <= s.hisal
where sal between s.losal and s.hisal
order by e.ename
;
-- 동등 비교가 아닌 크다 작다와 같은 비교로 조인의 조건을 작성


-- ansi cross join
select *
from emp cross join dept
;


select ename, dname
from emp inner join dept
on emp.deptno = dept.deptno
where ename = 'SCOTT'
;


select * from orders;
select * from customer;
select * from book;

select *
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order by o.orderid
;


-- ansi -> inner join
-- 오라클  EQUI JOIN


-- 비교하는 컬럼의 이름이 같을 때
-- on 절을 생략하고 using (칼럼명) 사용 가능
select *
from emp e inner join dept d
--on e.deptno = d.deptno
using (deptno)
where e.ename = 'SCOTT' 
;



-- self JOIN : 자기 자신을 조인 (참조)
-- emp -> mgr 칼럼이 emp.empno 참조
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+)
;

select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+) --> 표현하고자 하는 컬럼이 테이블의 반대쪽, null 값을 가지는 위치
;

-- [left | right | full] outer join 
select e.ename, e.mgr, m.ename
--from emp e left outer join emp m
from emp m right outer join emp e
on e.mgr = m.empno
;


-- 회원별 구매 내역 출력
select c.name, count(o.orderid) as "구매횟수" , avg(saleprice)
from orders o, customer c
where o.custid(+) = c.custid
group by c.name
order by c.name

;
