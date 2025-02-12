with FIRST_GEN as (
    select *
    from ECOLI_DATA
    where PARENT_ID is null
), SECOND_GEN as (
    select *
    from ECOLI_DATA
    where PARENT_ID in (
        select ID
        from FIRST_GEN
    )
)

select ID
from ECOLI_DATA
where PARENT_ID in  (
    select ID
    from SECOND_GEN
)
order by ID asc