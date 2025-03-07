with 프론트엔드_기술 as (
    select sum(CODE) as CODES
    from SKILLCODES
    where category like 'Front%'
)

select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where SKILL_CODE & (
    select CODES
    from 프론트엔드_기술
) > 0
order by ID