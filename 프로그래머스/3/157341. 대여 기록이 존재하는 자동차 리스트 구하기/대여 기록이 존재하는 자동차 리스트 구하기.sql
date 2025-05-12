select distinct CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_CAR
    where CAR_TYPE = '세단'
) and START_DATE like '2022-10%'
order by CAR_ID desc