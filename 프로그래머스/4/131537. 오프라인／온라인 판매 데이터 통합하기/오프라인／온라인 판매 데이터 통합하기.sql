select date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT from (
    select SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT from ONLINE_SALE
    union all
    select SALES_DATE, PRODUCT_ID, null, SALES_AMOUNT from OFFLINE_SALE
) as SALES_DATA
where year(SALES_DATE) = 2022 and month(SALES_DATE) = 3
order by SALES_DATE, PRODUCT_ID, USER_ID