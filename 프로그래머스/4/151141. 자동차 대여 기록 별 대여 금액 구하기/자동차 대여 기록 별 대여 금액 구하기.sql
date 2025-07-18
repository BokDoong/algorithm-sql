with 트럭_대여날짜_일일요금 as (
    select HISTORY_ID, DAILY_FEE, datediff(END_DATE, START_DATE) + 1 as DATE_DIFF
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    inner join CAR_RENTAL_COMPANY_CAR 
        on CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID = CAR_RENTAL_COMPANY_CAR.CAR_ID
    where CAR_TYPE = '트럭'
)

select HISTORY_ID, 
    case
        when DATE_DIFF >= 90
            then round(DAILY_FEE * DATE_DIFF * 
                (select (100-DISCOUNT_RATE)/100 from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                 where DURATION_TYPE = '90일 이상' and CAR_TYPE = '트럭'), 0)
        when DATE_DIFF >= 30
            then round(DAILY_FEE * DATE_DIFF * 
                (select (100-DISCOUNT_RATE)/100 from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                 where DURATION_TYPE = '30일 이상' and CAR_TYPE = '트럭'), 0)
        when DATE_DIFF >= 7
            then round(DAILY_FEE * DATE_DIFF * 
                (select (100-DISCOUNT_RATE)/100 from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                 where DURATION_TYPE = '7일 이상' and CAR_TYPE = '트럭'), 0)
        else DAILY_FEE * DATE_DIFF
    end as FEE
from 트럭_대여날짜_일일요금
order by FEE desc, HISTORY_ID desc