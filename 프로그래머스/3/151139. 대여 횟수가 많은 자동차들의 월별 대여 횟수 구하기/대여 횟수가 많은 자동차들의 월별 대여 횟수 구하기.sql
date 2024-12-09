select month(start_date) as MONTH, car_id as CAR_ID, count(*) as RECORDS
from car_rental_company_rental_history
where start_date >= "2022-08-01" and start_date <= "2022-10-31" and car_id in (
    select car_id as CAR_ID
    from car_rental_company_rental_history
    where "2022-08-01" <= start_date and start_date <= "2022-10-31"
    group by car_id
    having count(*) > 4
)
group by car_id, month(start_date)
having RECORDS >= 1
order by MONTH asc, CAR_ID desc