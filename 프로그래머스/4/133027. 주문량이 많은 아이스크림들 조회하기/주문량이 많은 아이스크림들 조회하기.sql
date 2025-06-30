select FLAVOR
from (
    select *
    from FIRST_HALF
    union all
    select *
    from JULY
) as TOTAL_ICECREAM
group by FLAVOR
order by sum(TOTAL_ORDER) desc
limit 3