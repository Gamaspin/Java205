-- 2021.06.10
-- function : 단일행 함수, 집합(다중행) 함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
-- 다중행(집합) 함수 : 여러 행의 특정 컬럼값들을 대상으로 연산하고 반환


select * from dual;

-- 숫자 함수
select abs(10), abs(-10)
from dual
;

select floor(15.7)      -- 소수점 절사
from dual
;

select round(15.193, 1), round(15.193, -1)      -- round ( n, x) : x번째 자리에서 반올림
from dual
;

select trunc(15.193, 1), trunc(15.193)      -- 단위 절사
from dual
;

select MOD(11,1)        -- mod(n, x) n을 x로 나누고 나머지 값을 출력
from dual
;

-- 사원들 급여의 20% 금액을 표현
select ename, sal, sal*0.2
from emp 
where mod(sal, 2) = 0
;


-- 문자 함수
-- concat (문자, 문자) -> '' || ''

select concat('abc', 'efg'), 'abc' || 'efg'
from dual
;

-- substr : 문자열 추출
-- substr (문자열, 시작 위치, 길이)
select substr('University Student', 1, 4)
from dual
;

select substr('University Student', -4)     -- 뒤에서부터 추출하기
from dual
;


-- replace : 특정 문자열(패턴) 다른 문자열(패턴)으로 변경
select REPLACE('JACK and JUE','J','BL')
from dual
;


----------------------------------------------------------
-- 2021.06.11
----------------------------------------------------------

-- 형변환 함수
-- 날짜 -> 문자, 숫자 -> 문자
-- to_char(날짜 데이터, '패턴'), to_char(숫자, '패턴')

select sysdate, to_char(sysdate, 'YYYY.MM.dd. hh24:mi:ss')
from dual;

select ename, hiredate, to_char(hiredate, 'yyyy.mm.dd.')
from emp
;

select * from orders;
select orderid, orderdate, to_char(orderdate, 'yyyy.mm.dd')
from orders;



select to_char(123456, '0,000,000,000'), to_char(123456,'L9,999,999,999')
from dual;

select to_char(saleprice, 'L999,999')
from orders
where custid = 1
;

select ename, sal, to_char(sal*1100, 'L999,999,999')
from emp;

select ename, sal, to_char(sal, '$999,999')
from emp;



-- 문자 -> 숫자,
-- to_number(문자열)
select TO_NUMBER('100.00', '9G999D99')
from dual;
select TO_NUMBER('1,000,000', '9,999,999'),
        to_number('1,000,000', '9,999,999')+10000
from dual;


-- 문자-날짜
-- to-date(문자열, 패턴)
select to_date('2012.05.17', 'yyyy.mm.dd'),
                trunc(sysdate - to_date('2012.05.17', 'yyyy.mm.dd'))/365
from dual;



-- decode : 분기를 위해 switch case문 처럼 쓰임. 여러 가지 경우에 대한 선택
-- decode(컬럼, 조건1 값, 조건1가 참일 때 사용할 값
--            , 조건2 값, 조건2가 참일 때 사용할 값
--             , .....)
select ename, deptno, decode(deptno, 10, 'Accounting', 20, 'Research'
                            , 30, 'Sales', 40, 'Operations') as dName
from emp
order by dname;

-- 직급에 따라 급여를 인상하도록 하자.
-- 직급이 'ANALYST' 인 사원은 5%,
--      'SALESMAN' 인 사원은 10%,
--      'MANAGER' 인 사원은 15%,
--      'CLERK' 인 사원은 20% 인상한다.
select ename, job, sal,
decode(job, 'ANALYST', sal*1.05     --5% 인상
            , 'SALESMAN', sal*1.1   --10% 인상
            , 'MANAGER', sal*1.15   --15% 인상
            , 'CLERK', sal*1.2       --20% 인상
) as promotedSal
from emp
order by sal;



-- CASE 함수도 분기할 때 사용
-- case when 조건1 then 참일 때 값(결과)1
select ename, deptno,
    case when deptno=10 then 'Accounting'
        when deptno=20 then 'Research'
        when deptno=30 then 'Sales'
        when deptno=40 then 'Operations'
        end as deptname
from emp
order by deptno desc;








