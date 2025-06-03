select month(START_DATE) as MONTH, CAR_ID, count(HISTORY_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where year(START_DATE) = 2022 and (month(START_DATE) >= 8 and month(START_DATE) <= 10)
    group by CAR_ID having count(HISTORY_ID) >= 5
) and year(START_DATE) = 2022 and (month(START_DATE) >= 8 and month(START_DATE) <= 10)
group by month(START_DATE), CAR_ID
order by MONTH asc, CAR_ID desc