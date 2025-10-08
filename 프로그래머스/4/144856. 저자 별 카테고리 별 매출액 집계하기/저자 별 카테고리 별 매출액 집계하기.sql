with 판매량_집계 as(
    select BOOK_SALES.BOOK_ID, CATEGORY, AUTHOR_ID, sum(SALES*PRICE) as SALES_AMOUNT
    from BOOK_SALES
        inner join BOOK on BOOK_SALES.BOOK_ID = BOOK.BOOK_ID    
    where SALES_DATE like '2022-01%'
    group by BOOK_SALES.BOOK_ID
)

select 판매량_집계.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(SALES_AMOUNT) as TOTAL_SALES
from 판매량_집계
    inner join AUTHOR on 판매량_집계.AUTHOR_ID = AUTHOR.AUTHOR_ID
group by 판매량_집계.AUTHOR_ID, CATEGORY
order by 판매량_집계.AUTHOR_ID, CATEGORY desc