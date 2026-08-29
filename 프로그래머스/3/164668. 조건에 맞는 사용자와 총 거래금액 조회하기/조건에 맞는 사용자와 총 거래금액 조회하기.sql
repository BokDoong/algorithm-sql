select ugb.writer_id as USER_ID, NICKNAME, sum(ugb.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD ugb
inner join USED_GOODS_USER ugu on ugb.writer_id = ugu.user_id
where ugb.STATUS = 'DONE'
group by ugb.writer_id having sum(ugb.PRICE) >= 700000
order by TOTAL_SALES