select product_code AS PRODUCT_CODE, sum(sales_amount * price) AS SALES
from product
    inner join offline_sale
    on product.product_id = offline_sale.product_id
group by product_code
order by SALES desc, PRODUCT_CODE asc