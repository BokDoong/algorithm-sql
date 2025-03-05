with MAX_REVIEW_MEMBER as (
    select MEMBER_ID, count(REVIEW_ID) as REVIEW_COUNT
    from REST_REVIEW
        group by MEMBER_ID
    order by REVIEW_COUNT desc
    limit 1
)

select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE
    inner join REST_REVIEW on MEMBER_PROFILE.MEMBER_ID = REST_REVIEW.MEMBER_ID
where MEMBER_PROFILE.MEMBER_ID = (
    select MEMBER_ID 
    from MAX_REVIEW_MEMBER
)
order by REVIEW_DATE, REVIEW_TEXT