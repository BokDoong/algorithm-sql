select count(*) as FISH_COUNT, FISH_NAME
from fish_info
inner join fish_name_info on fish_info.fish_type = fish_name_info.fish_type
group by fish_name
order by FISH_COUNT desc