with RANKS_INFO as (
    select ID, SIZE_OF_COLONY, ntile(4) over(order by SIZE_OF_COLONY desc) SIZE_RANKS
    from ECOLI_DATA
)

select ID,
    case
        when SIZE_RANKS = 1 then 'CRITICAL'
        when SIZE_RANKS = 2 then 'HIGH'
        when SIZE_RANKS = 3 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from RANKS_INFO
order by ID