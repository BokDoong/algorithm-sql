with 33_이상_물고기 as (
    select FISH_TYPE, avg(ifnull(LENGTH,10)) as AVG_LENGTH
    from FISH_INFO
    group by FISH_TYPE
        having avg(LENGTH) >= 33
)

select count(ID) as FISH_COUNT, max(LENGTH) as MAX_LENGTH, FISH_TYPE
from FISH_INFO
where FISH_TYPE in (select FISH_TYPE from 33_이상_물고기)
group by FISH_TYPE
order by FISH_TYPE