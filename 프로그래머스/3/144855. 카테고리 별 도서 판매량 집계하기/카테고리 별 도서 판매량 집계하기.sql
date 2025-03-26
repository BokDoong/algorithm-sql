select CATEGORY, sum(SALES)
from BOOK_SALES
inner join BOOK on BOOK_SALES.BOOK_ID = BOOK.BOOK_ID
    where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
group by CATEGORY
order by CATEGORY