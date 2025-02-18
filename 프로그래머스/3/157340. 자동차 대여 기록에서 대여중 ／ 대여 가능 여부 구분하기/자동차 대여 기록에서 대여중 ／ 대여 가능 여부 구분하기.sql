with 대여중인_자동차 as (
    select distinct CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE <= '2022-10-16' and END_DATE >= '2022-10-16'
)

select distinct CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID, 
    case
        when 대여중인_자동차.CAR_ID is null then '대여 가능'
        else '대여중'
    end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    left join 대여중인_자동차 on CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID = 대여중인_자동차.CAR_ID
order by CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID desc