with 1월_도서별_매출액 as (
    select BOOK_SALES.BOOK_ID, CATEGORY, sum(SALES)*PRICE as TOTAL_SALES, AUTHOR_ID
    from BOOK_SALES
        inner join BOOK on BOOK_SALES.BOOK_ID = BOOK.BOOK_ID
    where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
    group by BOOK_SALES.BOOK_ID
)

select AUTHOR.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(TOTAL_SALES) as TOTAL_SALES
from 1월_도서별_매출액
    inner join AUTHOR on AUTHOR.AUTHOR_ID = 1월_도서별_매출액.AUTHOR_ID
group by AUTHOR.AUTHOR_ID, AUTHOR_NAME, CATEGORY
order by AUTHOR.AUTHOR_ID asc, CATEGORY desc