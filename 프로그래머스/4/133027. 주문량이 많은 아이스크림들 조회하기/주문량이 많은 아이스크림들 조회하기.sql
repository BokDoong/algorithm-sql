select FIRST_HALF.FLAVOR
from FIRST_HALF
inner join (
    select FLAVOR, sum(TOTAL_ORDER) as JULY_ORDER
    from JULY
    group by FLAVOR
) as JULY_ORDER on FIRST_HALF.FLAVOR = JULY_ORDER.FLAVOR
order by TOTAL_ORDER+JULY_ORDER desc
limit 3