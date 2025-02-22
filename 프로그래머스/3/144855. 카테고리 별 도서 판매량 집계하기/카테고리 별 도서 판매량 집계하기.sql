with 1월_판매_도서 as (
    select BOOK_ID, sum(SALES) as SALES
    from BOOK_SALES
        where SALES_DATE like '2022-01%'
    group by BOOK_ID
)

select CATEGORY, sum(SALES) as TOTAL_SALES
from 1월_판매_도서
    inner join BOOK on 1월_판매_도서.BOOK_ID = BOOK.BOOK_ID
group by CATEGORY
order by CATEGORY