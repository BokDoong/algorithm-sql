select
    hr_employees.EMP_NO, EMP_NAME,
    case
        when avg(hr_grade.score) >= 96 then 'S'
        when avg(hr_grade.score) >= 90 then 'A'
        when avg(hr_grade.score) >= 80 then 'B'
        else 'C'
    end 'GRADE',
    case
        when avg(hr_grade.score) >= 96 then SAL*0.2
        when avg(hr_grade.score) >= 90 then SAL*0.15
        when avg(hr_grade.score) >= 80 then SAL*0.1
        else 0
    end 'BONUS'
from hr_employees
inner join hr_grade on hr_grade.emp_no = hr_employees.emp_no
group by hr_employees.EMP_NO
order by hr_grade.EMP_NO