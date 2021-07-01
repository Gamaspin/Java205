-- 2021.06.15
-- DDL 생성하기


create table phoneInfo_basic ( 
    idx number(6) constraint pi_basic_idx_PK primary key,
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate
    -- , constraint pi_basic_idx_PK primary key(idx)
);

create table phoneInfo_univ (
    idx number(6),
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default '1' not null, -- check (fr_u_year between 1 and 4),
    fr_ref number(6) not null,
    constraint pi_univ_idx_PK primary key (idx),
    constraint chk check (fr_u_year between 1 and 4), -- 테이블 레벨에서 check 제약 설정 
    constraint pi_univ_ref_FK foreign key (fr_ref) references phoneInfo_basic (idx)
);

create table phoneInfo_com (  
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6) not null,
    constraint pi_com_idx_PK primary key(idx),
    constraint pi_com_fr_ref_FK foreign key (fr_ref) references phoneInfo_basic(idx)
);       



-- 전체 친구 정보
select *
from phoneInfo_basic pb, phoneInfo_univ pu, phoneInfo_com pc
where pb.idx = pu.fr_ref(+) and pb.idx = pc.fr_ref(+)
;

-- Sequence : 번호 재생기
create sequence pi_idx_pk;
create sequence pi_u_idx_pk start with 3 increment by 1;
create sequence pi_c_idx_pk start with 3 increment by 1;
















                        
  