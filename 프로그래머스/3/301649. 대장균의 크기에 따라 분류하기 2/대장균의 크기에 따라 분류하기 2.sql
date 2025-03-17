with 크기_순위 as (
    select ID, SIZE_OF_COLONY,
        ntile(4) over (
            order by SIZE_OF_COLONY desc
        ) as SIZE_RANK
    from ECOLI_DATA
)

select ID,
    case
        when SIZE_RANK = 1 then 'CRITICAL'
        when SIZE_RANK = 2 then 'HIGH'
        when SIZE_RANK = 3 then 'MEDIUM'
        when SIZE_RANK = 4 then 'LOW'
    end as COLONY_NAME
from 크기_순위
order by ID