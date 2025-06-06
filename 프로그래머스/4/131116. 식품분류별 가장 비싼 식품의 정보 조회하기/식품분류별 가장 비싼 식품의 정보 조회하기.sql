with 카테고리별_가장_비싼_가격 as (
    select CATEGORY, max(PRICE) as MAX_PRICE
    from FOOD_PRODUCT
    group by CATEGORY
)

select FOOD_PRODUCT.CATEGORY, MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
inner join 카테고리별_가장_비싼_가격 
    on FOOD_PRODUCT.CATEGORY = 카테고리별_가장_비싼_가격.CATEGORY
    and FOOD_PRODUCT.PRICE = 카테고리별_가장_비싼_가격.MAX_PRICE
where FOOD_PRODUCT.CATEGORY = '과자' or FOOD_PRODUCT.CATEGORY = '국' or FOOD_PRODUCT.CATEGORY = '김치' or FOOD_PRODUCT.CATEGORY = '식용유'
order by MAX_PRICE desc