--앞에서 생성한 전화번호부 테이블을 기준으로 DML 을 작성해봅시다.

-- Insert : C reate
-- Select : R ead
-- Update : U pdate
-- Delete : D elete



--1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

desc phoneinfo_basic;

insert into phoneinfo_basic
values (1, 'KING', '010-0000-0000', 'king@bitcamp.com', 'KOREA', sysdate)
--values (pi_idx_pk.nextval, 'KING', '010-0000-0000', 'king@bitcamp.com', 'KOREA', sysdate)
;

select * from phoneinfo_basic;

insert into phoneinfo_basic (idx, fr_name, fr_phonenumber)
values (2, 'SCOTT' ,'010-0000-0001')
--values (pi_idx_pk.nextval, 'SCOTT' ,'010-0000-0001')
;
----
update phoneinfo_basic
set fr_email = 'scott@bitcamp.com', fr_address = 'Incheon'
where idx = 2   -- fr_name = 'SCOTT'
;

update phoneinfo_basic
set fr_address = 'Seoul'
where idx = 1
;
----
delete from phoneinfo_basic
where idx = 1
;


----------
--2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

desc phoneinfo_univ ;

insert into phoneinfo_basic
values (3, 'SON', '010-0000-0002', 'son@bitcamp.com', 'KOREA', sysdate)
--values (pi_u_idx_pk, 'SON', '010-0000-0002', 'son@bitcamp.com', 'KOREA', sysdate)
;
insert into phoneinfo_univ
values (1, 'COMPUTER', 4, 3)
--values (1, 'pi_u_idx_pk', 4, 3)
;

select pb.fr_name, pu.fr_u_major, pu.fr_u_year
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx = pu.fr_ref
;

delete from phoneinfo_univ
where idx = 2
;


--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

desc phoneinfo_com ;
select * from phoneinfo_com ;

insert into phoneinfo_basic
values (4, 'PARK', '010-0000-0003', 'park@bitcamp.com', 'Gangwon', sysdate)
;
insert into phoneinfo_com
values (1, 'NAVER', 4)
;

select pb.fr_name, pu.fr_u_major, pu.fr_u_year, pc.fr_c_company
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx = pc.fr_ref
;
----
update phoneinfo_com
set fr_c_company = 'KAKAO'
--where idx = 1
where fr_ref = 4
;

-- 지울 땐 밑에꺼(자식) 부터
delete from phoneinfo_com
where idx = 1
;
delete from phoneinfo_basic
where idx = 4
;





-- 전체 친구 정보
select *
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx = pu.fr_ref(+) and pb.idx = pc.fr_ref(+)   --outer join
;

-- Sequence : 번호 재생기
create sequence pi_idx_pk;
create sequence pi_u_idx_pk start with 3 increment by 1;
create sequence pi_c_idx_pk start with 3 increment by 1;



