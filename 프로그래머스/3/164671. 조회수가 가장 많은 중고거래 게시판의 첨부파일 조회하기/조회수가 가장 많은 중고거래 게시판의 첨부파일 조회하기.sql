with 가장_조회수_높은_게시글_ID as (
    select BOARD_ID
    from USED_GOODS_BOARD
    where VIEWS = (
        select max(VIEWS)
        from USED_GOODS_BOARD
    )
)

select concat('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) as FILE_PATH
from USED_GOODS_FILE
where BOARD_ID = (select BOARD_ID from 가장_조회수_높은_게시글_ID)
order by FILE_ID desc