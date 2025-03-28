select USER_ID, NICKNAME, sum(PRICE) as TOTAL_SALES
from USED_GOODS_BOARD
inner join USED_GOODS_USER on WRITER_ID = USER_ID
where STATUS like 'DONE'
group by USER_ID having sum(PRICE) >= 700000
order by TOTAL_SALES