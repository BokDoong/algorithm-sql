with prefix_sum as (
    select *, sum(weight) over (order by turn ) as total_weight
    from Queue
)

select person_name
from prefix_sum
where total_weight <= 1000
order by total_weight desc
limit 1
