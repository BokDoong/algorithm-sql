with PARENT_INFO as (
    select PARENT_ID, count(*) as CHILD_COUNT
    from ECOLI_DATA
    group by PARENT_ID
)

select ID, ifnull(CHILD_COUNT, 0) as CHILD_COUNT
from ECOLI_DATA
    left join PARENT_INFO on ECOLI_DATA.ID = PARENT_INFO.PARENT_ID
order by ID