select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE
    inner join REST_REVIEW on MEMBER_PROFILE.MEMBER_ID = REST_REVIEW.MEMBER_ID
where MEMBER_PROFILE.MEMBER_ID in (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
        having count(REVIEW_ID) = (
            select max(REVIEW_IDS_CNT) 
            from (
                select MEMBER_ID, count(REVIEW_ID) as REVIEW_IDS_CNT
                from REST_REVIEW
                group by MEMBER_ID
            ) as REST_REVIEW_CNTS)
)
order by REVIEW_DATE, REVIEW_TEXT