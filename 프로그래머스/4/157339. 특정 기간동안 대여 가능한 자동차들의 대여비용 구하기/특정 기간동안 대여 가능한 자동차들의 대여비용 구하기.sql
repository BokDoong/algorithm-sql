with 11월_대여_불가능_자동차 as (
    select distinct CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where END_DATE > '2022-11-01' AND START_DATE < '2022-12-01'
), 자동차별_30일_할인율 as (
    select CAR_TYPE, DISCOUNT_RATE/100 as DISCOUNT_RATE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where DURATION_TYPE = '30일 이상'
), 자동차별_가격표 as (
    select CAR_ID, CAR_RENTAL_COMPANY_CAR.CAR_TYPE, round(DAILY_FEE*30*(1.0 - DISCOUNT_RATE),0) as FEE
    from CAR_RENTAL_COMPANY_CAR
    inner join 자동차별_30일_할인율
        on CAR_RENTAL_COMPANY_CAR.CAR_TYPE = 자동차별_30일_할인율.CAR_TYPE
    where CAR_ID not in (
        select CAR_ID
        from 11월_대여_불가능_자동차
    ) and (CAR_RENTAL_COMPANY_CAR.CAR_TYPE = '세단' or CAR_RENTAL_COMPANY_CAR.CAR_TYPE = 'SUV')
)

select *
from 자동차별_가격표
where FEE >= 500000 and FEE < 2000000
order by FEE desc, CAR_TYPE asc, CAR_ID desc