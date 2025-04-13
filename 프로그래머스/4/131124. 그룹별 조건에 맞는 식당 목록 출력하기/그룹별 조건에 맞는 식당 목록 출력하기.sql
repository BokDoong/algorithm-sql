with 최대_회원_리뷰 as (
    select REST_REVIEW.MEMBER_ID, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
    from REST_REVIEW
    inner join (
        select MEMBER_ID
        from REST_REVIEW
        group by MEMBER_ID
        order by count(REVIEW_ID) desc
        limit 1
    ) as 최대_회원 on REST_REVIEW.MEMBER_ID = 최대_회원.MEMBER_ID
)

select MEMBER_NAME, REVIEW_TEXT, REVIEW_DATE
from 최대_회원_리뷰
inner join MEMBER_PROFILE on 최대_회원_리뷰.MEMBER_ID = MEMBER_PROFILE.MEMBER_ID
order by REVIEW_DATE, REVIEW_TEXT