with caclulated_customer as (
    select 
        visited_on,
        sum(amount) over(order by visited_on rows between 6 preceding and current row) as 'amount',
        round(sum(amount) over(order by visited_on rows between 6 preceding and current row) / 7 , 2) as 'average_amount'
    from (
        select visited_on, sum(amount) as amount
        from Customer
        group by visited_on
    ) as cus
    order by visited_on
)

select *
from caclulated_customer
where visited_on >= (
    select min(visited_on) + 6
    from caclulated_customer
)
