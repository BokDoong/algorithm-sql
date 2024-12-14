select ID
from ecoli_data
where parent_id in (
    select id as SECOND_GEN_ID
    from ecoli_data
    where parent_id in (
        select id as FIRST_GEN_ID
        from ecoli_data
        where parent_id is null
    )
)