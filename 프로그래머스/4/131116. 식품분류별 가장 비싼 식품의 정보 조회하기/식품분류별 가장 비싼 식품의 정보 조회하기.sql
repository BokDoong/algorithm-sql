with 식품별_최대_가격 as (
    select CATEGORY, max(PRICE) as PRICE
    from FOOD_PRODUCT
    group by CATEGORY
)

select FOOD_PRODUCT.CATEGORY, FOOD_PRODUCT.PRICE as MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
    inner join 식품별_최대_가격 on FOOD_PRODUCT.CATEGORY = 식품별_최대_가격.CATEGORY and FOOD_PRODUCT.PRICE = 식품별_최대_가격.PRICE
where FOOD_PRODUCT.CATEGORY in ('과자', '국', '김치', '식용유')
order by MAX_PRICE desc