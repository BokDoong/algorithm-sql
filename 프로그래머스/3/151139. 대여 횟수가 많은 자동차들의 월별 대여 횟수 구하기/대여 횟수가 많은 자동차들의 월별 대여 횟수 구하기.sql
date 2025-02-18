with CARS_INFO as (
    select CAR_ID, count(HISTORY_ID) as RECORDS
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where '2022-08-01' <= START_DATE and START_DATE < "2022-11-01"
    group by CAR_ID
        having count(HISTORY_ID) >= 5
)

select month(START_DATE) as MONTH, CAR_ID, count(HISTORY_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where CAR_ID in (select CAR_ID from CARS_INFO) and '2022-08-01' <= START_DATE and START_DATE < "2022-11-01"
group by MONTH, CAR_ID
    having RECORDS > 0 
order by MONTH asc, CAR_ID desc