with 5회_이상_자동차 as (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE between '2022-08-01' and '2022-10-31'
    group by CAR_ID
        having count(CAR_ID) >= 5
)

select month(START_DATE) as MONTH, CAR_ID, count(HISTORY_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (
    select CAR_ID
    from 5회_이상_자동차
) and (START_DATE between '2022-08-01' and '2022-10-31')
group by MONTH, CAR_ID
order by MONTH, CAR_ID desc