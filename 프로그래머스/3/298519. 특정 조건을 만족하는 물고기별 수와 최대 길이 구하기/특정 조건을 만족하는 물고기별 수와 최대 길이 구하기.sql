with 33이상_물고기_종류 as (
    select FISH_TYPE, avg(ifnull(LENGTH, 10))
    from FISH_INFO
    group by FISH_TYPE
        having avg(ifnull(LENGTH, 10)) >= 33
)

select count(ID) as FISH_COUNT, max(ifnull(LENGTH, 10)) as MAX_LENGTH, FISH_TYPE
from FISH_INFO
where FISH_TYPE in (select FISH_TYPE from 33이상_물고기_종류)
    group by FISH_TYPE
order by FISH_TYPE