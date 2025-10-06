with ECOLI_RANK as (
    select ID, PARENT_ID, rank() over (order by SIZE_OF_COLONY desc) as SIZE_RANK
    from ECOLI_DATA
), TOTAL_COUNT as (
    select count(*) as total
    from ECOLI_DATA
)

select 
    ID,
    case
        when SIZE_RANK <= total*0.25 then 'CRITICAL'
        when SIZE_RANK <= total*0.50 then 'HIGH'
        when SIZE_RANK <= total*0.75 then 'MEDIUM'
        else 'LOW'
    end as 'COLONY_NAME'
from ECOLI_RANK, TOTAL_COUNT
order by ID