select count(ID) as FISH_COUNT, max(LENGTH) as MAX_LENGTH, FISH_TYPE
from FISH_INFO
group by FISH_TYPE
    having avg(ifnull(LENGTH, 10)) >= 33
order by FISH_TYPE