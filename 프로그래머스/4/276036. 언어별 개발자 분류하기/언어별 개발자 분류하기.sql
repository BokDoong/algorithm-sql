with 프론트엔드_기술 as (
    select sum(CODE) as CODE
    from SKILLCODES
        where CATEGORY = 'Front End'
), 파이썬 as (
    select CODE
    from SKILLCODES
        where NAME = 'Python'
), 씨 as (
    select CODE
    from SKILLCODES
        where NAME = 'C#'
), 등급표 as (
    select 
        case
            when SKILL_CODE & (select CODE from 프론트엔드_기술) > 0 
                and SKILL_CODE & (select CODE from 파이썬) > 0 then 'A'
            when SKILL_CODE & (select CODE from 씨) > 0 then 'B'
            when SKILL_CODE & (select CODE from 프론트엔드_기술) > 0 then 'C'
        end as GRADE, ID
    from DEVELOPERS
)

select GRADE, DEVELOPERS.ID, EMAIL
from DEVELOPERS
    inner join 등급표 on DEVELOPERS.ID = 등급표.ID
where GRADE is not null
order by GRADE, ID