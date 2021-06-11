-- 2021.06.11

-- 그룹함수
-- 여러 행을 묶어 처리하는 함수
-- sum, avg, count, max, min

select *
from emp
;


-- 사원 테이블에서 1. 사원의 수, 2. 사원의 급여 총합 3. 급여 평균, 4. 최대 급여, 5. 최소 급여
select count(*) as "사원의 수", sum(sal) as "급여의총합", round(avg(sal),2) as "급여 평균", max(sal), min(sal) as "minimum salary"
from emp
;

select count(distinct job)
from emp
;
select count(distinct publisher)
from book
order by publisher
;



-- 그룹 함수 : 특정 칼럼을 이용해서 그룹핑하기 -> group by

-- select 칼럼명, 그룹함수
-- from 테이블명
-- where 조건(연산자)
-- group by 그룹핑할 기준의 칼럼명;









