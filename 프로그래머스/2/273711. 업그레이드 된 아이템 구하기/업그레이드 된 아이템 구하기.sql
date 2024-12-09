select item_info.item_id, item_info.item_name, item_info.rarity
from item_info
    inner join item_tree
    on item_info.item_id = item_tree.item_id
where item_tree.parent_item_id in (select item_id from item_info where rarity = 'RARE')
order by item_info.item_id desc