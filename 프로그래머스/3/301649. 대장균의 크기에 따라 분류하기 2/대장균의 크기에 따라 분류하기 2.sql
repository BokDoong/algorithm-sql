with 크기_순위 as (
    select ID,
        ntile(4) over (
            order by SIZE_OF_COLONY desc
        ) as COLONY_NAME
    from ECOLI_DATA
)

select ID,
    case
        when COLONY_NAME = 1 then 'CRITICAL'
        when COLONY_NAME = 2 then 'HIGH'
        when COLONY_NAME = 3 then 'MEDIUM'
        when COLONY_NAME = 4 then 'LOW'
    end as COLONY_NAME
from 크기_순위
order by ID