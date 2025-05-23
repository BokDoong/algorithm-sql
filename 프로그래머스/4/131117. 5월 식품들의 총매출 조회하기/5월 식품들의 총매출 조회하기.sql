with 5월_생상품_판매량 as (
    select PRODUCT_ID, sum(AMOUNT) as TOTAL_AMOUNT
    from FOOD_ORDER
    where year(PRODUCE_DATE) = 2022 and month(PRODUCE_DATE) = 5
    group by PRODUCT_ID
)

select FOOD_PRODUCT.PRODUCT_ID, PRODUCT_NAME, PRICE*TOTAL_AMOUNT as TOTAL_SALES
from FOOD_PRODUCT
inner join 5월_생상품_판매량 on FOOD_PRODUCT.PRODUCT_ID = 5월_생상품_판매량.PRODUCT_ID
order by TOTAL_SALES desc, FOOD_PRODUCT.PRODUCT_ID asc