select rest_info.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE),2) AS SCORE
from rest_info
    inner join rest_review
    on rest_info.rest_id = rest_review.rest_id
where address like '서울%'
group by rest_info.rest_id
order by SCORE desc, FAVORITES desc