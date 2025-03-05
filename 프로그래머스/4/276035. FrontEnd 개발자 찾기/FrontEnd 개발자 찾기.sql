with 프론트엔드_개발자 as (
    select sum(CODE) as CODE
    from SKILLCODES
    where CATEGORY like 'Front%'
)

select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
    where SKILL_CODE & (select CODE from 프론트엔드_개발자) > 0
order by ID