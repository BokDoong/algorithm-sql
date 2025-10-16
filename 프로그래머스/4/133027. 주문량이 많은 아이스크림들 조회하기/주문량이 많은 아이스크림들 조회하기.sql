with TOTAL_ORDER as (
    select SHIPMENT_ID, FLAVOR, TOTAL_ORDER
    from FIRST_HALF
    
    union all
    
    select SHIPMENT_ID, FLAVOR, TOTAL_ORDER
    from JULY
), TOP3_TOTAL_ORDER as (
    select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
    from TOTAL_ORDER
    group by FLAVOR
    order by TOTAL_ORDER desc
    limit 3
)

select FLAVOR
from TOP3_TOTAL_ORDER