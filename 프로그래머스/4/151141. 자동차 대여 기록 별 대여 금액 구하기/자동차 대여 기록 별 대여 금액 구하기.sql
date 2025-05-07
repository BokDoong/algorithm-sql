with 트럭_대여정보 as (
    select HISTORY_ID, datediff(END_DATE, START_DATE)+1 as RENT_DATE, (datediff(END_DATE, START_DATE)+1)*DAILY_FEE as FEE
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    inner join (
        select CAR_ID, DAILY_FEE from CAR_RENTAL_COMPANY_CAR where CAR_TYPE = '트럭'
    ) as 트럭_정보 on CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID = 트럭_정보.CAR_ID
)

select HISTORY_ID,
    case
        when RENT_DATE >= 90 then round(FEE*(1-0.01*(select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where CAR_TYPE = '트럭' and DURATION_TYPE = '90일 이상')), 0)
        when RENT_DATE >= 30 then round(FEE*(1-0.01*(select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where CAR_TYPE = '트럭' and DURATION_TYPE = '30일 이상')), 0)
        when RENT_DATE >= 7 then round(FEE*(1-0.01*(select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where CAR_TYPE = '트럭' and DURATION_TYPE = '7일 이상')), 0)
        else FEE
    end as FEE
from 트럭_대여정보
order by FEE desc, HISTORY_ID desc