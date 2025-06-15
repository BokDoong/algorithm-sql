with 멤버별_등급 as (
    select
        case
            when SKILL_CODE & (
                select sum(CODE)
                from SKILLCODES
                where CATEGORY = 'Front End'
            ) > 0 and SKILL_CODE & (
                select sum(CODE)
                from SKILLCODES
                where NAME = 'Python'
            ) > 0 then 'A'
            when SKILL_CODE & (
                select sum(CODE)
                from SKILLCODES
                where NAME = 'C#'
            ) > 0 then 'B'
            when SKILL_CODE & (
                select sum(CODE)
                from SKILLCODES
                where CATEGORY = 'Front End'
            ) > 0 then 'C'
        end as GRADE, ID
    from DEVELOPERS
)

select GRADE, DEVELOPERS.ID, EMAIL
from DEVELOPERS
inner join 멤버별_등급 on DEVELOPERS.ID = 멤버별_등급.ID
where GRADE is not null
order by GRADE, ID