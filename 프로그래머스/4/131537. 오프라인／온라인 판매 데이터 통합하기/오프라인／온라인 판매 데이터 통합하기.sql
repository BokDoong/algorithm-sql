with ALL_DATA as (
    select SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
    from ONLINE_SALE
    union all
    select SALES_DATE, PRODUCT_ID, null, SALES_AMOUNT
    from OFFLINE_SALE
)

select date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ALL_DATA
where SALES_DATE like '2022-03%'
order by SALES_DATE asc, PRODUCT_ID asc, USER_ID asc