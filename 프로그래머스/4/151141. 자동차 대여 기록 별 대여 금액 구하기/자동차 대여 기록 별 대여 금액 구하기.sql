set @weekDiscount := (select (100-DISCOUNT_RATE)/100 from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where CAR_TYPE = '트럭' and DURATION_TYPE = '7일 이상'),
@monthDiscount := (select (100-DISCOUNT_RATE)/100 from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where CAR_TYPE = '트럭' and DURATION_TYPE = '30일 이상'),
@threeMonthsDiscount := (select (100-DISCOUNT_RATE)/100 from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where CAR_TYPE = '트럭' and DURATION_TYPE = '90일 이상');

with 트럭_대여시간 as (
    select HISTORY_ID, CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID, datediff(END_DATE, START_DATE) + 1 as DURATION, DAILY_FEE
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        inner join CAR_RENTAL_COMPANY_CAR on CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID = CAR_RENTAL_COMPANY_CAR.CAR_ID
    where CAR_TYPE = '트럭'
)

select HISTORY_ID,
    case
        when DURATION >= 90 then round(DURATION*DAILY_FEE*@threeMonthsDiscount,0)
        when DURATION >= 30 then round(DURATION*DAILY_FEE*@monthDiscount, 0)
        when DURATION >= 7 then round(DURATION*DAILY_FEE*@weekDiscount, 0)
        else DURATION*DAILY_FEE
    end as FEE
from 트럭_대여시간
order by FEE desc, HISTORY_ID desc