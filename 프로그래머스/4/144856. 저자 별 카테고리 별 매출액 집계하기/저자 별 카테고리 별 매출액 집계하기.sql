with 1월_도서_판매량 as (
    select BOOK_ID, sum(SALES) as SALES
    from BOOK_SALES
        where SALES_DATE like '2022-01%'
    group by BOOK_ID
), 1월_도서_판매액 as (
    select 1월_도서_판매량.BOOK_ID, SALES*BOOK.PRICE as TOTAL_PRICE, AUTHOR_ID, CATEGORY
    from 1월_도서_판매량
        inner join BOOK on 1월_도서_판매량.BOOK_ID = BOOK.BOOK_ID
)

select AUTHOR.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(TOTAL_PRICE) as TOTAL_PRICE
from 1월_도서_판매액
    inner join AUTHOR on 1월_도서_판매액.AUTHOR_ID = AUTHOR.AUTHOR_ID
group by AUTHOR_ID, AUTHOR_NAME, CATEGORY
order by AUTHOR_ID asc, CATEGORY desc