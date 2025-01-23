select ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.ANIMAL_TYPE, ANIMAL_OUTS.NAME
from ANIMAL_OUTS
    inner join ANIMAL_INS on ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
where (ANIMAL_OUTS.SEX_UPON_OUTCOME like 'Neutered%' or ANIMAL_OUTS.SEX_UPON_OUTCOME like 'Spayed%') and ANIMAL_INS.SEX_UPON_INTAKE like 'Intact%'
order by ANIMAL_OUTS.ANIMAL_ID