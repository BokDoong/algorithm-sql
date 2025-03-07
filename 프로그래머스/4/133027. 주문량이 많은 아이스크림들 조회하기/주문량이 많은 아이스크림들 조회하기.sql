with 총합_판매량 as (
    select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
    from (
        select *
        from FIRST_HALF
        union all
        select *
        from JULY
    ) as TOTAL_SALES
    group by FLAVOR
)

select FLAVOR
from 총합_판매량
order by TOTAL_ORDER desc
limit 3