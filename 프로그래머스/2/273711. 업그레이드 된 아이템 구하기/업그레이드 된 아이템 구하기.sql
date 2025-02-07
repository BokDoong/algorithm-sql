with RARE_ITEMS as (
    select *
    from ITEM_INFO
    where RARITY = 'RARE'
)

select ITEM_TREE.ITEM_ID, ITEM_NAME, RARITY
from ITEM_TREE
    inner join ITEM_INFO on ITEM_TREE.ITEM_ID = ITEM_INFO.ITEM_ID
where PARENT_ITEM_ID in (select ITEM_ID from RARE_ITEMS)
order by ITEM_TREE.ITEM_ID desc