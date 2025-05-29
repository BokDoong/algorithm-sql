with 크기_랭킹 as (
    select ID,
        rank() over (order by SIZE_OF_COLONY desc) as COLONY_RANK
    from ECOLI_DATA
    order by ID
)

select ID,
    case
        when COLONY_RANK <= (select (1/4)*count(ID) from 크기_랭킹) then 'CRITICAL'
        when COLONY_RANK <= (select (1/2)*count(ID) from 크기_랭킹) then 'HIGH'
        when COLONY_RANK <= (select (3/4)*count(ID) from 크기_랭킹) then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from 크기_랭킹