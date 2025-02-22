with 음식별_최대_즐겨찾기수 as (
    select FOOD_TYPE, max(FAVORITES) as MAX_FAVORITES
    from REST_INFO
    group by FOOD_TYPE
)

select REST_INFO.FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO
    inner join 음식별_최대_즐겨찾기수 on REST_INFO.FOOD_TYPE = 음식별_최대_즐겨찾기수.FOOD_TYPE
where FAVORITES = MAX_FAVORITES
order by REST_INFO.FOOD_TYPE desc