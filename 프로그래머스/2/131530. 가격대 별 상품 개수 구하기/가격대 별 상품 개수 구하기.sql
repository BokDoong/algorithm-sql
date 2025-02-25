select 
    case
            when PRICE < 10000 then 0
            else truncate(PRICE,-4)
    end as PRICE_GROUP, count(PRODUCT_ID) as PRODUCTS
from PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP