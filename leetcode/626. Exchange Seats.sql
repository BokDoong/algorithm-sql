with switch_seat as (
    select 
        id,
        case
            when mod(id, 2) = 1 then (select student from Seat as ComparisionSeat where ComparisionSeat.id = OriginalSeat.id+1)
            when mod(id, 2) = 0 then (select student from Seat as ComparisionSeat where ComparisionSeat.id = OriginalSeat.id-1)
        end as student
    from Seat as OriginalSeat
)

select id, ifnull(student, (select student from Seat order by id desc limit 1)) as student
from switch_seat
order by id
