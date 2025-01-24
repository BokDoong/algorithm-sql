with FRONT_END as (
    select *
    from SKILLCODES
    where CATEGORY like 'Front%'
)

select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
    inner join FRONT_END on DEVELOPERS.SKILL_CODE & FRONT_END.CODE > 0
order by ID