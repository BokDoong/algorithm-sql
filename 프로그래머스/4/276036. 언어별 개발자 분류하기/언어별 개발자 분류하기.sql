select
    case
        when SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY like 'Front%') > 0 and SKILL_CODE & (select CODE from SKILLCODES where NAME = 'Python') > 0 then 'A'
        when SKILL_CODE & (select CODE from SKILLCODES where NAME = 'C#') > 0 then 'B'
        when SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY like 'Front%') > 0 then 'C'
        else null
    end as GRADE,
    ID, EMAIL
from DEVELOPERS
group by GRADE, ID, EMAIL
having GRADE is not null
order by GRADE, ID