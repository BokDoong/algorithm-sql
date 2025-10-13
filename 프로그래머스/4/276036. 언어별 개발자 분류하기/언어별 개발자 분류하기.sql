with DEVELOPER_INFO as (
    select
        case
            when SKILL_CODE & (select CODE from SKILLCODES where NAME = 'Python') >= 1 
                and SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = 'Front End') >= 1 then 'A'
            when SKILL_CODE & (select CODE from SKILLCODES where NAME = 'C#') >= 1 then 'B'
            when SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = 'Front End') >= 1 then 'C'
        end as GRADE,
        ID, EMAIL
    from DEVELOPERS
)

select *
from DEVELOPER_INFO
where GRADE is not null
order by GRADE, ID