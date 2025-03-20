with 종류별_큰_길이 as (
    select FISH_TYPE, max(LENGTH) as MAX_LENGTH
    from FISH_INFO
    group by FISH_TYPE
)

select ID, FISH_NAME, LENGTH
from FISH_INFO
    inner join 종류별_큰_길이 on FISH_INFO.FISH_TYPE = 종류별_큰_길이.FISH_TYPE
    inner join FISH_NAME_INFO on FISH_INFO.FISH_TYPE = FISH_NAME_INFO.FISH_TYPE
where LENGTH = MAX_LENGTH
order by ID