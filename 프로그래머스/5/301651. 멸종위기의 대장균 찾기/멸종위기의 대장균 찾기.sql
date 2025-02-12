# 재귀쿼리 -> 세대 정보
with recursive GEN_INFO as (
    # 초기 테이블
    select ID, PARENT_ID, 1 as GENERATION
    from ECOLI_DATA
    where PARENT_ID is null
    # 재귀 테이블
    union all
    select RE.ID, RE.PARENT_ID, GEN_INFO.GENERATION+1
    from GEN_INFO
        inner join ECOLI_DATA as RE on GEN_INFO.ID = RE.PARENT_ID
), PARENT_SON_INFO as (
    select PARENT_ID, count(*) as CHILD_COUNT
    from ECOLI_DATA
    group by PARENT_ID
        having PARENT_ID is not null
)

select count(*) as COUNT, GENERATION
from GEN_INFO
    left join PARENT_SON_INFO on GEN_INFO.ID = PARENT_SON_INFO.PARENT_ID
where CHILD_COUNT is null
group by GENERATION
order by GENERATION