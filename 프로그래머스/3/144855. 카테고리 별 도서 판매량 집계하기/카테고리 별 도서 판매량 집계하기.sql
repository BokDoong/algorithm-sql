select CATEGORY, sum(JAN_SALES) as TOTAL_SALES
from BOOK
inner join (
    select BOOK_ID, sum(sales) as JAN_SALES
    from BOOK_SALES
    where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
    group by BOOK_ID
) as 1월_판매량 on BOOK.BOOK_ID = 1월_판매량.BOOK_ID
group by CATEGORY
order by CATEGORY