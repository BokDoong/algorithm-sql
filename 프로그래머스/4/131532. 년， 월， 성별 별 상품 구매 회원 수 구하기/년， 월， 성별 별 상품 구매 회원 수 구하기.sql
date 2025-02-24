with 성별정보_있는_회원 as (
    select USER_ID, GENDER
    from USER_INFO
        where GENDER = 1 or GENDER = 0
)

select year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, GENDER, count(distinct ONLINE_SALE.USER_ID) as USERS
from ONLINE_SALE
    inner join 성별정보_있는_회원 on ONLINE_SALE.USER_ID = 성별정보_있는_회원.USER_ID
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER