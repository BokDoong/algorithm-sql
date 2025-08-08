with approved_transactions as (
    select 
        date_format(trans_date, '%Y-%m') as month, 
        country, 
        count(id) as approved_count, 
        sum(amount) as approved_total_amount
    from Transactions
    where state = 'approved'
    group by date_format(trans_date, '%Y-%m'), country
), 
total_transactions as (
    select 
        date_format(trans_date, '%Y-%m') as month, 
        country, 
        count(id) as trans_count, 
        sum(amount) as trans_total_amount
    from Transactions
    group by date_format(trans_date, '%Y-%m'), country
)

select 
    total_transactions.month, 
    total_transactions.country, 
    trans_count, 
    ifnull(approved_count, 0) as approved_count,
    trans_total_amount,
    ifnull(approved_total_amount, 0) as approved_total_amount
from total_transactions
left join approved_transactions on total_transactions.month = approved_transactions.month and total_transactions.country <=> approved_transactions.country
