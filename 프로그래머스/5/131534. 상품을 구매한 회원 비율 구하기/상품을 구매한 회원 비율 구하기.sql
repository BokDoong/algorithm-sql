with 2021_USERS as (
    select USER_ID
    from USER_INFO
    where JOINED like '2021%'
)

select year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, 
        count(distinct USER_ID) as PURCHASED_USERS, round(count(distinct USER_ID) / (select count(*) from 2021_USERS), 1) as PUCHASED_RATIO
from ONLINE_SALE
where USER_ID in (
    select USER_ID
    from 2021_USERS
)
group by YEAR, MONTH
order by YEAR, MONTH