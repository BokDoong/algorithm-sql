select ID, 
    case
        when percent_rank() over(order by size_of_colony desc) <= 0.25 then 'CRITICAL'
        when percent_rank() over(order by size_of_colony desc) <= 0.5 then 'HIGH'
        when percent_rank() over(order by size_of_colony desc) <= 0.75 then 'MEDIUM'
        else 'LOW'
    end 'COLONY_NAME'
from ecoli_data
order by ID