with 2021_가입_회원 as (
    select * from USER_INFO where year(JOINED) = 2021
)

select year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH,
    count(distinct 2021_가입_회원.USER_ID) as PURCHASED_USERS, round(count(distinct 2021_가입_회원.USER_ID) / (select count(USER_ID) from 2021_가입_회원), 1) as PUCHASED_RATIO
from ONLINE_SALE
left join 2021_가입_회원 on ONLINE_SALE.USER_ID = 2021_가입_회원.USER_ID
group by year(SALES_DATE), month(SALES_DATE)
order by YEAR, MONTH