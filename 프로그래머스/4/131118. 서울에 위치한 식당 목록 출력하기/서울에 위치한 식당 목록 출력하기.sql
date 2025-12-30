select REST_INFO.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, SCORE
from REST_INFO
inner join (
    select REST_ID, round(avg(REVIEW_SCORE), 2) as SCORE 
    from REST_REVIEW
    group by REST_ID
) as REST_REVIEW_AVG on REST_REVIEW_AVG.REST_ID = REST_INFO.REST_ID
where ADDRESS like '서울%'
order by SCORE desc, FAVORITES desc