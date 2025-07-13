select date_format(ONLINE_SALE.SALES_DATE, '%Y') as YEAR,
    date_format(ONLINE_SALE.SALES_DATE, '%m') as MONTH, 
    count(distinct USER_INFO.USER_ID) as PURCHASED_USERS, round(count(distinct USER_INFO.USER_ID)/(select count(*) from USER_INFO where joined like '2021%'), 1) as PURCHASED_RATIO
from USER_INFO
join ONLINE_SALE on USER_INFO.USER_ID = ONLINE_SALE.USER_ID
where USER_INFO.JOINED like '2021%'
group by YEAR, MONTH
order by YEAR, MONTH