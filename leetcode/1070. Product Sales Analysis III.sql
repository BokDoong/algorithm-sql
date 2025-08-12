select Sales.product_id, Sales_Frist_Year.first_year, quantity, price
from Sales
inner join (
    select product_id, min(year) as first_year
    from Sales
    group by product_id
) as Sales_Frist_Year
where Sales.product_id = Sales_Frist_Year.product_id and Sales.year = Sales_Frist_Year.first_year
