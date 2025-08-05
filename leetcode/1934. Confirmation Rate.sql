# Write your MySQL query statement below
select Signups.user_id, ifnull(confirmation_rate, 0) as confirmation_rate
from Signups
    left join (
            select user_id as 유저_ID, round((select count(*) from Confirmations where user_id = 유저_ID and action like 'confirmed') / count(*), 2) as confirmation_rate
            from Confirmations
            group by user_id
    ) as 확인_비율 on Signups.user_id = 확인_비율.유저_ID