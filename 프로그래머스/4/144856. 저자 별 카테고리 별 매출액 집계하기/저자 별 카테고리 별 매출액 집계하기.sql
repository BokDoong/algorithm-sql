select BOOK.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(SALES*PRICE) as TOTAL_SALES
from BOOK
    inner join (
        select BOOK_ID, SALES, SALES_DATE
        from BOOK_SALES
        where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
    ) as JAN_BOOK on BOOK.BOOK_ID = JAN_BOOK.BOOK_ID
    inner join AUTHOR on BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
group by BOOK.AUTHOR_ID, CATEGORY
order by AUTHOR_ID, CATEGORY desc