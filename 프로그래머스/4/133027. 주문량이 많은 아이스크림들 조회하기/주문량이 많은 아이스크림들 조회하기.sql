with TOTAL_ORDER as (
    select *
    from FIRST_HALF
    union all
    select *
    from JULY
), TOP3 as (
    select FLAVOR, sum(TOTAL_ORDER) as TOTAL_PRICE
    from TOTAL_ORDER
        group by FLAVOR
    order by TOTAL_PRICE desc
    limit 3
)

select FLAVOR
from TOP3