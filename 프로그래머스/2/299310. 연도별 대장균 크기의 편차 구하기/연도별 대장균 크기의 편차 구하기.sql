select year(ecoli_data.differentiation_date) as YEAR, (max_size - size_of_colony) as YEAR_DEV, ID
from ecoli_data
    inner join (
        select year(differentiation_date) as year, max(size_of_colony) as max_size
        from ecoli_data
        group by year(differentiation_date)        
    ) as max_size_info on year(ecoli_data.differentiation_date) = max_size_info.year
order by YEAR, YEAR_DEV