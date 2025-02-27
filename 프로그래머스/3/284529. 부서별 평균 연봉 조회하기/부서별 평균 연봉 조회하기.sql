select HR_DEPARTMENT.DEPT_ID, DEPT_NAME_EN, round(avg(SAL),0) as AVG_SAL
from HR_EMPLOYEES
    inner join HR_DEPARTMENT on HR_EMPLOYEES.DEPT_ID = HR_DEPARTMENT.DEPT_ID
group by HR_DEPARTMENT.DEPT_ID
order by AVG_SAL desc