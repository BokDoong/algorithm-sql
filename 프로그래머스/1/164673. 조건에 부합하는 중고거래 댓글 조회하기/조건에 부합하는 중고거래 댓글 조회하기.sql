select title, board.board_id as BOARD_ID, reply_id, reply.writer_id as WRITER_ID, reply.contents as CONTENTS, date_format(reply.created_date, '%Y-%m-%d') as CREATE_DATE
from used_goods_board as board
    inner join used_goods_reply as reply
    on board.board_id = reply.board_id
where year(board.created_date) = 2022 and month(board.created_date) = 10
order by reply.created_date, board.title