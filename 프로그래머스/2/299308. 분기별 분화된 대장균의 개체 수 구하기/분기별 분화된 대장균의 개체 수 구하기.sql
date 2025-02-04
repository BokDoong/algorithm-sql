select case
        when month(DIFFERENTIATION_DATE) < 4 then '1Q'
        when month(DIFFERENTIATION_DATE) < 7 then '2Q'
        when month(DIFFERENTIATION_DATE) < 10 then '3Q'
        when month(DIFFERENTIATION_DATE) < 13 then '4Q'
    end as QUARTER,
    count(ID) as ECOLI_COUNT
from ECOLI_DATA
group by QUARTER
order by QUARTER