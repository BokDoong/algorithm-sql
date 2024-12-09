select animal_outs.animal_id AS ANIMAL_ID, animal_outs.name AS NAME
from animal_outs
    left outer join animal_ins
    on animal_outs.animal_id = animal_ins.animal_id
where animal_ins.animal_id is null