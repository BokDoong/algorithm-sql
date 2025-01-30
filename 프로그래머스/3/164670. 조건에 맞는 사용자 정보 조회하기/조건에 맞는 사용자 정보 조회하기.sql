select USER_ID, NICKNAME, concat(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) as 전체주소, 
    concat(substr(TLNO, 1, 3), '-', substr(TLNO, 4, 4), '-', substr(TLNO, 8,4)) as 전화번호
from USED_GOODS_USER
    inner join USED_GOODS_BOARD on USED_GOODS_USER.USER_ID = USED_GOODS_BOARD.WRITER_ID
group by USER_ID
    having count(*) >= 3
order by USER_ID desc