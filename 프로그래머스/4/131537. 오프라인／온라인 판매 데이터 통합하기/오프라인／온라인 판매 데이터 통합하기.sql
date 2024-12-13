select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
where date(SALES_DATE) >= '2022-03-01' and date(SALES_DATE) <= '2022-03-31'

union

select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
from OFFLINE_SALE
where date(SALES_DATE) >= '2022-03-01' and date(SALES_DATE) <= '2022-03-31'

order by SALES_DATE, PRODUCT_ID, USER_ID