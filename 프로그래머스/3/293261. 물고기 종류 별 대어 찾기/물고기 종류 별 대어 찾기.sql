select id, fish_name, length
from fish_info
    inner join fish_name_info on fish_name_info.fish_type = fish_info.fish_type
    inner join (
        select fish_type, max(length) as max_length
        from fish_info
        group by fish_type      
    ) as length_info on length_info.fish_type = fish_info.fish_type
where length = max_length
order by id