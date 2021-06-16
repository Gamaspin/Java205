--2021.06.14
--Subquery

-- 스칼라 부속 질의 : select절 이후에 사용
select o.custid, (select customer.name from customer where o.custid = customer.custid) as name
from orders o
;

-- emp 테이블만 사용해서 사원 이름, 부서 이름 출력하기
select e.ename, (select d.dname from dept d where e.deptno = d.deptno) as dname
from emp e
;

select custid,
            (select name from customer c where o.custid = c.custid) as customer
from orders o
group by custid
;




-- 인라인 뷰 : from 절 뒤에 사용되는 부속질의, 가상 테이블 처럼 사용

-- 고객 번호가 2 이하인 -> cystomer
-- 고객의 판매액을 보이시오 -> orders
-- (결과는 고객 이름과 고객별 판매액 출력)
select o.custid, c.name, sum(o.saleprice)
from (select custid, name from customer where custid <= 2) c, orders o
where c.custid = o.custid
group by o.custid, c.name
;



-- 평균 주문 금액 이하 
select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice) from orders)
order by saleprice
;

-- 평균 주문 금액
select avg(saleprice) from orders ;



select *
from orders o1
where saleprice > 
    (select avg(saleprice) from orders o2 where o2.custid = o1.custid)
;
select avg(saleprice) from orders where custid = 1;


-- 다중행 연산자  IN
-- 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원 리스트 출력
select distinct deptno
from emp
where sal >= 3000
;
select *--ename, sal, deptno
from emp
where deptno in 
            (10, 20);
            -- 10, 20 자리에 위 문장 대입

select ename, sal, deptno
from emp
where deptno in 
            (select distinct deptno
            from emp
            where sal >= 3000)
;


select orderid, saleprice
from orders
--where saleprice > (


where saleprice > all (select saleprice from orders where custid = 3)
;

-- 3번 고객이 주문한 도서의 최고 금액
select max(saleprice)
from orders
where custid = 3
;

-- 확인
select saleprice from orders where custid = 3;



