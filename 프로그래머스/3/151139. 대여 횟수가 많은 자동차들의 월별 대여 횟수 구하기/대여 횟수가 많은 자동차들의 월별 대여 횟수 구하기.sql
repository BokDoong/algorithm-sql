# select month(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS
select month(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE between date('2022-08-01') and date('2022-11-01')
    group by CAR_ID having count(*) >= 5
) and month(START_DATE) in (8, 9, 10)
group by month(START_DATE), CAR_ID
    having count(*) > 0
order by MONTH, CAR_ID desc