select ANIMAL_TYPE, count(*) as count
from ANIMAL_INS
group by ANIMAL_TYPE
having ANIMAL_TYPE = 'Dog' or ANIMAL_TYPE = 'Cat'
order by ANIMAL_TYPE