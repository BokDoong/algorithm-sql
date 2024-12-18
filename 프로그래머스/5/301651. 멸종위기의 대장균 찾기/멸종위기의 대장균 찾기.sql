with recursive GenerationCTE as (
    # 초기 데이터
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    # 재귀 데이터
    select e.id, e.parent_id, g.generation + 1 as generation
    from ecoli_data e
    join GenerationCTE as g on e.parent_id = g.id
)
select count(*) as COUNT, generation as GENERATION
from GenerationCTE
where id not in (select distinct parent_id from GenerationCTE where parent_id is not null)
group by generation
order by GENERATION