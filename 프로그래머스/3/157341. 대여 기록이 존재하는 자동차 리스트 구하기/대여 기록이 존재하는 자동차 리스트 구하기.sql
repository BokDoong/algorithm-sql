select distinct CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE like '2022-10%' 
    and CAR_ID in (select CAR_ID from CAR_RENTAL_COMPANY_CAR where CAR_TYPE = '세단')
order by CAR_ID desc