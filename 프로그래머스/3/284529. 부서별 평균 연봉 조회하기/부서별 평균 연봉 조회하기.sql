select dept.DEPT_ID, DEPT_NAME_EN, round(avg(SAL), 0) as AVG_SAL
from hr_department as dept
inner join hr_employees as em on dept.dept_id = em.dept_id
group by dept.dept_id
order by AVG_SAL desc