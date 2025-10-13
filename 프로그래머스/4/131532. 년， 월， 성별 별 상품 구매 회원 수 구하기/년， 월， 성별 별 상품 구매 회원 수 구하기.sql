select year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, GENDER, count(distinct ONLINE_SALE.USER_ID) as SALES_AMOUNT
from ONLINE_SALE
join USER_INFO
    on ONLINE_SALE.USER_ID = USER_INFO.USER_ID
group by year(SALES_DATE), month(SALES_DATE), GENDER
    having GENDER is not null
order by YEAR, MONTH, GENDER