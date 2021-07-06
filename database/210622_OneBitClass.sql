-- 20210622
-- One bit Class 테이블 생성
drop table classmember;
drop table bitclass;
drop table classorder;

create table classmember (   -- 회원 정보 저장
    mno number(4) constraint classmember_mno_pk primary key, -- 회원번호
    mid varchar2(20) not null,      -- ID
    mpw varchar2(20) not null,      -- 비밀번호
    mname varchar2(20) not null,    -- 이름
    mdate date,                     -- 생년월일 
    mloc varchar2(20),              -- 선호 지역
    mpoint integer                  -- 보유 포인트
);

create table bitclass (             -- 강좌 정보 저장     
    cno number(4) constraint bitclass_cno__pk primary key, -- 강좌 번호
    mno number(4) constraint bitclass_mno_fk references classmember(mno), -- 강사 번호
    title varchar2(50) not null,
    cloc varchar2(20) not null, -- 강좌 지역
    startdate date not null, -- 강좌 시작일
    enddate date not null, -- 강좌 종료일
    fee integer not null, -- 수강료
    discount integer, -- 할인 가격
    rate number(2), -- 평점
    numpeople number(2) not null -- 수강 인원
);

create table classorder ( -- 수강 신청 
    orderno number(4) constraint classorder_on_pk primary key, -- 신청번호
    mno number(4) constraint classorder_mno_fk references classmember(mno), -- 회원 번호
    cno number(4) constraint classorder_cno_fk references bitclass(cno), -- 강좌 번호
    orderdate date default sysdate -- 신청일
);

create sequence classmember_mno_seq
start with 1
increment by 1
;

create sequence bitclass_cno_seq
start with 1
increment by 1
;

create sequence classorder_orderno_seq
start with 1
increment by 1
;

insert into classmember (mno, mid, mpw, mname, mloc)
    values (classmember_mno_seq.nextval, 'jongwon', '123456', '성종원', '서울');  
insert into bitclass (cno, title, cloc, fee, startdate, enddate, numpeople)
    values (bitclass_cno_seq.nextval, '요리교실', '용산', 50000, '21/06/22',
            '21/07/22', 10); 


select * from classmember;
select * from bitclass;
select * from classorder;

commit;

select * from bitclass;
select * from classmember;
select * from bitclass natural join classmember where mno = 4 order by cno;