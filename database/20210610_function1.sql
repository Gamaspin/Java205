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





