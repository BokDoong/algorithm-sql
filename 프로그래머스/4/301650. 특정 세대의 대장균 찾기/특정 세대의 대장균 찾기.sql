with 1ST_GEN as (
    select *
    from ECOLI_DATA
    where PARENT_ID is null
), 2ND_GEN as (
    select *
    from ECOLI_DATA
    where PARENT_ID in (select ID from 1ST_GEN)
)

select ID
from ECOLI_DATA
where PARENT_ID in (select ID from 2ND_GEN)
order by ID