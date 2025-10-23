with 트럭_대여기간 as (
    select HISTORY_ID, CAR_ID, datediff(END_DATE, START_DATE)+1 as DURATION
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where CAR_ID in (
        select CAR_ID
        from CAR_RENTAL_COMPANY_CAR
        where CAR_TYPE = '트럭'
    )
)

select HISTORY_ID, 
    case
        when DURATION >= 90 
            then round(DAILY_FEE * DURATION * (100 - (select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE = '90일 이상' and CAR_TYPE = '트럭')) / 100, 0)
        when DURATION >= 30 
            then round(DAILY_FEE * DURATION * (100 - (select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE = '30일 이상' and CAR_TYPE = '트럭')) / 100, 0)
        when DURATION >= 7 
            then round(DAILY_FEE * DURATION * (100 - (select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE = '7일 이상' and CAR_TYPE = '트럭')) / 100, 0)
        else round(DAILY_FEE * DURATION, 0)
    end as FEE
from 트럭_대여기간
inner join CAR_RENTAL_COMPANY_CAR on 트럭_대여기간.CAR_ID = CAR_RENTAL_COMPANY_CAR.CAR_ID
order by FEE desc, HISTORY_ID desc