with MAX_VIEWS_BOARDS as (
    select BOARD_ID 
    from USED_GOODS_BOARD 
    where VIEWS = (
        select max(VIEWS) 
        from USED_GOODS_BOARD
    )
)

select concat('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) as FILE_PATH
from USED_GOODS_FILE
    where BOARD_ID in (select BOARD_ID from MAX_VIEWS_BOARDS)
order by FILE_ID desc