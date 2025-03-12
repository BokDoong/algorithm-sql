with 자식_정보 as (
    select PARENT_ID, count(ID) as CHILD_COUNT
    from ECOLI_DATA
    where PARENT_ID is not null
    group by PARENT_ID
)

select ECOLI_DATA.ID, ifnull(CHILD_COUNT, 0) as CHILD_COUNT
from ECOLI_DATA
    left join 자식_정보 on ECOLI_DATA.ID = 자식_정보.PARENT_ID
order by ECOLI_DATA.ID