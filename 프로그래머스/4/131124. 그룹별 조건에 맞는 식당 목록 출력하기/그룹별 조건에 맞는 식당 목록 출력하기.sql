with MAX_RIVIEW_COUNTS as (
    select MEMBER_ID, count(*) as MAX_RIVIEW_COUNTS
    from REST_REVIEW
    group by MEMBER_ID
    order by MAX_RIVIEW_COUNTS desc
    limit 1
), MAX_RIVIEW_MEMBER_IDS as (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
        having COUNT(*) = (select MAX_RIVIEW_COUNTS from MAX_RIVIEW_COUNTS)
)

select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from REST_REVIEW
    inner join MEMBER_PROFILE on REST_REVIEW.MEMBER_ID = MEMBER_PROFILE.MEMBER_ID
where REST_REVIEW.MEMBER_ID in (select MEMBER_ID from MAX_RIVIEW_MEMBER_IDS)
order by REVIEW_DATE, REVIEW_TEXT