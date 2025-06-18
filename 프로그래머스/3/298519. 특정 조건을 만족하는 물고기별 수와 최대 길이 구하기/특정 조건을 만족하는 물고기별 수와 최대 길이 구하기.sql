with 물고기_평균_길이 as (
    select ID, FISH_TYPE,
        case
            when LENGTH is null or LENGTH <= 10 then 10
            else LENGTH
        end as LENGTH, TIME
    from FISH_INFO
)

select count(ID) as FISH_COUNT, max(LENGTH) as MAX_LENGTH, FISH_TYPE
from 물고기_평균_길이
group by FISH_TYPE
    having avg(LENGTH) >= 33
order by FISH_TYPE