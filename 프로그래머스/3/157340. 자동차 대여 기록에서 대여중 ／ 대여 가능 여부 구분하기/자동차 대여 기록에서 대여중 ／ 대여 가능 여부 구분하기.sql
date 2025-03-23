with 자동차_ID as (
    select distinct CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
), 대여중_자동차 as (
    select distinct CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where '2022-10-16' between START_DATE and END_DATE
)

select 자동차_ID.CAR_ID,
    case
        when 대여중_자동차.CAR_ID is null then '대여 가능'
        else '대여중'
    end as AVAILABILITY
from 자동차_ID
left join 대여중_자동차 on 자동차_ID.CAR_ID = 대여중_자동차.CAR_ID
order by CAR_ID desc