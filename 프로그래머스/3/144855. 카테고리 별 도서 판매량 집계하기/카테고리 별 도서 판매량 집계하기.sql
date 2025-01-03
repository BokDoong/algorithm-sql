# select CATEGORY, count(*) as TOTAL_SALES
# from BOOK_SALES
# inner join BOOK on BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
#     where YEAR(SALES_DATE) = 2022 and MONTH(SALES_DATE) = 1
# group by CATEGORY
# order by CATEGORY

select CATEGORY, sum(sales)
from BOOK_SALES
inner join BOOK on BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
    where YEAR(SALES_DATE) = 2022 and MONTH(SALES_DATE) = 1
group by CATEGORY
order by CATEGORY