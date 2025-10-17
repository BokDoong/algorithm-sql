select 
    year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, 
    count(distinct ONLINE_SALE.USER_ID) as PURCHASED_USERS, round((count(distinct ONLINE_SALE.USER_ID) / (select count(USER_ID) from USER_INFO where year(JOINED) = 2021)), 1) as PUCHASED_RATIO
from ONLINE_SALE
inner join (
    select USER_ID
    from USER_INFO
    where year(JOINED) = 2021
) as 2021_가입자수 on ONLINE_SALE.USER_ID = 2021_가입자수.USER_ID
group by year(SALES_DATE), month(SALES_DATE)
order by YEAR, MONTH