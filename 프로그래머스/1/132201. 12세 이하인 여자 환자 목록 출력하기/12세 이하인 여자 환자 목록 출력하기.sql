select PT_NAME, PT_NO, GEND_CD, AGE,
    case
        when tlno is null then 'NONE'
        else TLNO
    end 'TLNO'
from patient
where age <= 12 and gend_cd = 'W'
order by age desc, pt_name