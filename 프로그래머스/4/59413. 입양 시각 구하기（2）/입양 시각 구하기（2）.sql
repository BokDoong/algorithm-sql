set @month := -1;

select (@month := @month+1) as HOUR, 
    (select count(*) from ANIMAL_OUTS where hour(DATETIME) = @month) as COUNT
from ANIMAL_OUTS
where @month < 23