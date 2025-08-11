select round(count(*) / (select count(distinct player_id) from Activity), 2) as fraction
from Activity
inner join (
    select player_id, min(event_date) as first_login_date
    from Activity
    group by player_id ) as FirstLoginInfo on Activity.player_id = FirstLoginInfo.player_id
where datediff(event_date, first_login_date) = 1
