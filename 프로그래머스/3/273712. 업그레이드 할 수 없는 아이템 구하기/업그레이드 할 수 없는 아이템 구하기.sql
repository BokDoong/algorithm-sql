select ITEM_INFO.ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO
    left outer join ITEM_TREE on ITEM_INFO.ITEM_ID = ITEM_TREE.PARENT_ITEM_ID
where ITEM_TREE.ITEM_ID is null
order by ITEM_INFO.ITEM_ID desc