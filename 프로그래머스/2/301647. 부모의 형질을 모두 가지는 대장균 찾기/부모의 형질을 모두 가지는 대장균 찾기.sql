with PARENT_INFO as (
    select ID, GENOTYPE as PARENT_GENOTYPE
    from ECOLI_DATA
    where ID in (
        select PARENT_ID
        from ECOLI_DATA
        where PARENT_ID is not null
    )
)

select ECOLI_DATA.ID, GENOTYPE, PARENT_GENOTYPE
from ECOLI_DATA
inner join PARENT_INFO on ECOLI_DATA.PARENT_ID = PARENT_INFO.ID
where GENOTYPE & PARENT_GENOTYPE >= PARENT_GENOTYPE
order by ID