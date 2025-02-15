with MAX_LENGTH_INFO as (
    select FISH_TYPE, max(LENGTH) as LENGTH
    from FISH_INFO
    group by FISH_TYPE
)

select ID, FISH_NAME, FISH_INFO.LENGTH
from FISH_INFO
    inner join FISH_NAME_INFO on FISH_INFO.FISH_TYPE = FISH_NAME_INFO.FISH_TYPE
    inner join MAX_LENGTH_INFO on FISH_INFO.FISH_TYPE = MAX_LENGTH_INFO.FISH_TYPE
where FISH_INFO.LENGTH = MAX_LENGTH_INFO.LENGTH
order by ID