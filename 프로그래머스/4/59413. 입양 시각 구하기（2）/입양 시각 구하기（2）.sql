set @hour := -1;
select (@hour := @hour + 1) as HOUR,
    (select count(*)
    from ANIMAL_OUTS where hour(DATETIME) = @hour) as HOUR
from ANIMAL_OUTS
where @hour < 23