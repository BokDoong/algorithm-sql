select CATEGORY, sum(SALES) as TOTAL_SALES
from BOOK_SALES
join BOOK
    on BOOK_SALES.BOOK_ID = BOOK.BOOK_ID
where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
group by CATEGORY
order by CATEGORY