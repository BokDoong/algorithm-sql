select year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, 
    GENDER, count(distinct ONLINE_SALE.USER_ID) as USERS
from ONLINE_SALE
inner join USER_INFO on ONLINE_SALE.USER_ID = USER_INFO.USER_ID
group by YEAR, MONTH, GENDER
having GENDER is not null and USERS is not null
order by YEAR, MONTH, GENDER