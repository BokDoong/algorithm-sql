select 
    distinct CAR_ID,
    case 
        when CAR_ID IN (
            select CAR_ID
            from CAR_RENTAL_COMPANY_RENTAL_HISTORY
            where END_DATE >= '2022-10-16' AND START_DATE <= '2022-10-16'        
        ) then '대여중'
        else '대여 가능'
    end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID desc