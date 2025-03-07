set @total := (select count(USER_ID) from USER_INFO where year(JOINED) = 2021);

select year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH,
    count(distinct ONLINE_SALE.USER_ID) as PURCHASED_USERS, round(count(distinct ONLINE_SALE.USER_ID)/@total,1) as PUCHASED_RATIO
from ONLINE_SALE
    inner join USER_INFO on ONLINE_SALE.USER_ID = USER_INFO.USER_ID
where year(USER_INFO.JOINED) = 2021
group by year(SALES_DATE), month(SALES_DATE)
order by YEAR, MONTH