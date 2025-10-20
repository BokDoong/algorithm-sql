with 프론트엔드_기술스택 as (
    select sum(CODE) as FRONT_CODE
    from SKILLCODES
    where CATEGORY like 'Front%'
)

select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where SKILL_CODE & (select FRONT_CODE from 프론트엔드_기술스택) > 0
order by ID