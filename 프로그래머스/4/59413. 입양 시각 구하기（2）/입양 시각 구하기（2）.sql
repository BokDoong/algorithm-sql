set @hour = -1;

select @hour := @hour+1 as HOUR, (
    select count(ANIMAL_ID)
    from ANIMAL_OUTS
    where hour(DATETIME) = @hour
)
from ANIMAL_OUTS
where @hour < 23