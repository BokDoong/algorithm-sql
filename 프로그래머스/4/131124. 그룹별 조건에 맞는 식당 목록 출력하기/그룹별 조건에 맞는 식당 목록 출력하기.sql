with 가장_많은_리뷰_회원 as (
    select MEMBER_ID, count(*) as REVIEW_COUNTS
    from REST_REVIEW
    group by MEMBER_ID
    order by REVIEW_COUNTS desc
    limit 1
)

select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE
    inner join REST_REVIEW on MEMBER_PROFILE.MEMBER_ID = REST_REVIEW.MEMBER_ID
where MEMBER_PROFILE.MEMBER_ID = (
    select MEMBER_ID
    from 가장_많은_리뷰_회원
)
order by REVIEW_DATE, REVIEW_TEXT