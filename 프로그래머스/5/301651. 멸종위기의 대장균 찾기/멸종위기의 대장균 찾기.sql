# 세대별 대장균, 전 세대의 부모 대장균 정보
with recursive generation_infos as (
    # 1세대
    select 1 as generation, id, parent_id
    from ecoli_data
    where parent_id is null
    
    union all
    
    # 다음 세대
    select generation_infos.generation + 1, ecoli_data.id, ecoli_data.parent_id
    from ecoli_data
    join generation_infos on generation_infos.id = ecoli_data.parent_id
)
select count(*) as COUNT, GENERATION
from generation_infos
where id not in (select parent_id from generation_infos where parent_id is not null)
group by generation
order by generation