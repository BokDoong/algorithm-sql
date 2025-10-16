with CAN_RENT_CAR_ID as (
    select CAR_ID
    from CAR_RENTAL_COMPANY_CAR
    where CAR_ID not in (
        select distinct CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
    )
), 30_DAYS_RENT_FEE as (
    select CAR_ID, CAR_RENTAL_COMPANY_CAR.CAR_TYPE, round(30*DAILY_FEE*(100-DISCOUNT_RATE)*0.01, 0) as FEE
    from CAR_RENTAL_COMPANY_CAR
    inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        on CAR_RENTAL_COMPANY_CAR.CAR_TYPE = CAR_RENTAL_COMPANY_DISCOUNT_PLAN.CAR_TYPE and DURATION_TYPE = '30일 이상'
)

select CAR_ID, CAR_TYPE, FEE
from 30_DAYS_RENT_FEE
where FEE between 500000 and 2000000 and CAR_ID in (select CAR_ID from CAN_RENT_CAR_ID) and CAR_TYPE in ('세단', 'SUV')
order by FEE desc, CAR_TYPE asc, CAR_ID desc