with 프론트엔드_코드 as (
    select sum(CODE) as SKILL_CODE
    from SKILLCODES
    where CATEGORY like 'Front%'
)

select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where SKILL_CODE & (select SKILL_CODE from 프론트엔드_코드) > 0
order by ID