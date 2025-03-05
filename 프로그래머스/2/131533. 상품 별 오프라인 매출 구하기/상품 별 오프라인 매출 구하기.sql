with 상품별_판매량 as (
    select PRODUCT_ID, SUM(SALES_AMOUNT) as SALES_COUNT
        from OFFLINE_SALE
    group by PRODUCT_ID
)

select PRODUCT_CODE, SALES_COUNT*PRICE as SALES
from 상품별_판매량
    inner join PRODUCT on 상품별_판매량.PRODUCT_ID = PRODUCT.PRODUCT_ID
order by SALES desc, PRODUCT_CODE