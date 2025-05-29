with 1세대 as (
    select ID
    from ECOLI_DATA
    where PARENT_ID is null
), 2세대 as (
    select ID
    from ECOLI_DATA
    where PARENT_ID in (
        select ID
        from 1세대
    )
)

select ID
from ECOLI_DATA
where PARENT_ID in (
    select ID
    from 2세대
)
order by ID