with 
SIZE_RANK as (
    select ID, rank() over (order by SIZE_OF_COLONY desc) as RNK
    from ECOLI_DATA
),
CNT as (
    select count(*) as total from ECOLI_DATA
)

select ID,
       case
         when RNK <= total*0.25 then 'CRITICAL'
         when RNK <= total*0.5  then 'HIGH'
         when RNK <= total*0.75 then 'MEDIUM'
         else 'LOW'
       end as COLONY_NAME
from SIZE_RANK, CNT
order by ID;