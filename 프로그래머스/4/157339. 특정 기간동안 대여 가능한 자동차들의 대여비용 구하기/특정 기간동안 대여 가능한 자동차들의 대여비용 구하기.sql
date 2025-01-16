with RENTAL_BANNED_CARS as (
    select *
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where '2022-11-01' between START_DATE and END_DATE or '2022-11-30' between START_DATE and END_DATE
), THIRTY_DAYS_DISCOUNT_PLAN as (
    select *
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where DURATION_TYPE = '30일 이상'
), CALCULATED_CARS as (
    select CAR_ID, CAR_RENTAL_COMPANY_CAR.CAR_TYPE, round(DAILY_FEE * 30 * (100-DISCOUNT_RATE) * 0.01) as FEE
    from CAR_RENTAL_COMPANY_CAR
        join THIRTY_DAYS_DISCOUNT_PLAN on CAR_RENTAL_COMPANY_CAR.CAR_TYPE = THIRTY_DAYS_DISCOUNT_PLAN.CAR_TYPE
        where CAR_ID not in (
            select CAR_ID
            from RENTAL_BANNED_CARS
        )
    order by FEE desc, CAR_RENTAL_COMPANY_CAR.CAR_TYPE asc, CAR_ID desc
)

 # and (
 #        CAR_RENTAL_COMPANY_CAR.CAR_TYPE = '세단' or CAR_RENTAL_COMPANY_CAR.CAR_TYPE = 'SUV'
 #    ) and (FEE >= 500000 and FEE < 2000000)

select *
from CALCULATED_CARS
    where (CAR_TYPE = '세단' or CAR_TYPE = 'SUV') and (FEE >= 500000 and FEE < 2000000)
order by FEE desc, CAR_TYPE asc, CAR_ID desc