with 평가등급_정보 as (
    select
        EMP_NO,
        case 
            when avg(SCORE) >= 96 then 'S'
            when avg(SCORE) >= 90 then 'A'
            when avg(SCORE) >= 80 then 'B'
            else 'C'
        end as GRADE
    from HR_GRADE
    group by EMP_NO
)

select HR_EMPLOYEES.EMP_NO, EMP_NAME, GRADE,
    case
        when GRADE = 'S' then SAL*0.2
        when GRADE = 'A' then SAL*0.15
        when GRADE = 'B' then SAL*0.1
        else 0
    end as BONUS
from HR_EMPLOYEES
inner join 평가등급_정보 on HR_EMPLOYEES.EMP_NO = 평가등급_정보.EMP_NO
order by HR_EMPLOYEES.EMP_NO