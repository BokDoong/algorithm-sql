with TOTAL_ICECREAM as (
    select *
    from FIRST_HALF
    union all
    select *
    from JULY
)

select FLAVOR
from TOTAL_ICECREAM
group by FLAVOR
order by sum(TOTAL_ORDER) desc
limit 3