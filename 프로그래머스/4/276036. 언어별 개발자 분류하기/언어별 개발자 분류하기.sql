WITH 개발자_등급표 as (
    SELECT
        CASE
            WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') > 0 
                AND SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python') > 0 THEN 'A'
            WHEN SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') > 0 THEN 'B'
            WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') > 0 THEN 'C'
            ELSE NULL
        END AS GRADE, ID, EMAIL
    FROM DEVELOPERS
)

select *
from 개발자_등급표
where GRADE is not null
order by GRADE, ID