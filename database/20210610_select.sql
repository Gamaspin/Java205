--2021.06.10

-- 특정 데이터 검색 : 행 검색 -> 컬럼 선택

-- 10번 부서의 사원 리스트를 출력
select *
from emp
--where deptno = 10
;

-- 이름이 'SCOTT'인 사원을 출력
select *
from emp
where ename = 'SCOTT'
;
-- 데이터의 대소문자가 다를 시 검색이 안됨
select *
from emp
where ename = 'scott'
;

-- 날짜타입의 데이터 비교 시에도 작은 따옴표를 이용해야 한다
select *
from emp
where hiredate = '96-11-17'     --'96/11/17'
;

-- 논리 연산자 : and / or / not
select *
from emp
where deptno = 10 and job = 'MANAGER'
;
select *
from emp
where deptno = 10 or job = 'MANAGER'
;
select *
from emp
where not deptno = 10       -- 10번 부서서의 직원을 제외한 나머지 직원들을 출력
;

-- 범위 연산을 할 때 -> 논리연산자 이용, between a and b (a 이상 b 이하)

-- 2000이상 3000이하의 급여를 받는 직원의 리스트
select ename, job, sal, sal*1.2 as upsal
from emp
-- 2000이상 3000이하의 급여를 받는 직원의 리스트
-- where sal >= 2000 and sal <= 3000
where sal between 2000 and 3000
;


-- between 연산자는 날짜의 연산도 가능
-- 1977년에 입사한 사원들의 리스트를 출력
select *
from emp
--where hiredate >= '81/01/01' and hiredate <= '81/12/31'
where hiredate between '81/01/01' and '81/12/31'
order by hiredate --desc << 역순(내림차순) || asc << 오름차순
;


-- 연산자 in -> 여러개의 or 연산자 사용 시 대체할 수 있다
-- 커미션이 300 또는 500 또는 1400
select *
from emp
-- where comm = 300 or comm = 500 or comm = 1400
where comm in(300,500,1400)
;

-- 패턴 검색 : 키워드 검색 많이 사용 (게시판)
-- 컬럼 like '%'
-- ename like 'F%' -> F로 시작하는 문자열 검색
-- ename like '%F' -> F로 끝나는 문자열 검색
-- ename like '%F%' -> F를 포함하는 문자열 검색
-- 'java' 단어를 포함하는지 -> title like '%java%'
select *
from emp
where ename like '%A%'
;


-- 자리수 패턴 : 컬럼의 값이 자리수가 정해져있고 값에 패턴이 있는 경우
-- 이름 중에 끝에서 세 번째 문자에 A를 포함하는 사원의 리스트 검색
select *
from emp
where ename like '% A _ _'
;

-- 이름 중에 처음에서 두 번째 문자에 A를 포함하지 않는 모든 사원의 리스트 검색
select *
from emp
where ename not like '_A%'
;

-- comm 컬럼 값 중, null 값이 아닌 사원의 리스트 검색
select *
from emp
where comm is not null
;


-- 결과 행의 정렬 : order by 컬럼 [asc | desc]  <- 대괄호 안을 선택에 따라 기입
select *
from emp
order by sal desc, job, ename asc      -- asc는 생략가능(디폴트. ascending)
;








