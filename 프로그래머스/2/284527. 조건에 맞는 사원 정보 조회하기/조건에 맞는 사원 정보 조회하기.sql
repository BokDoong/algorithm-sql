with 최고_점수 as (
    select EMP_NO, YEAR, sum(SCORE) as SCORE
    from HR_GRADE
    group by EMP_NO, YEAR
        having YEAR = 2022
    order by SCORE desc
    limit 1
)

select 최고_점수.SCORE, HR_EMPLOYEES.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES
inner join 최고_점수 on HR_EMPLOYEES.EMP_NO = 최고_점수.EMP_NO