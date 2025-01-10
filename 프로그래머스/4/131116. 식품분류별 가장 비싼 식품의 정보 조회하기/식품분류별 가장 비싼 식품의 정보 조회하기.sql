with CATEGORY_MAX_PRICES as (
    select CATEGORY, max(PRICE) as MAX_PRICE
    from FOOD_PRODUCT
        where CATEGORY like '국' or CATEGORY like '김치' or CATEGORY like '식용유' or CATEGORY like '과자'
    group by CATEGORY
)

select FP.CATEGORY, CM.MAX_PRICE, FP.PRODUCT_NAME
from FOOD_PRODUCT as FP
    inner join CATEGORY_MAX_PRICES as CM on FP.PRICE = CM.MAX_PRICE and FP.CATEGORY = CM.CATEGORY
order by PRICE desc