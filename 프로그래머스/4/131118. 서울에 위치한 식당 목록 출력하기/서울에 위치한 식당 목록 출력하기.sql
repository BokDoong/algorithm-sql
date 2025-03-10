select REST_INFO.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE),2) as SCORE
from REST_INFO
    inner join REST_REVIEW on REST_INFO.REST_ID = REST_REVIEW.REST_ID
where ADDRESS like '서울%'
group by REST_INFO.REST_ID
order by SCORE desc, FAVORITES desc