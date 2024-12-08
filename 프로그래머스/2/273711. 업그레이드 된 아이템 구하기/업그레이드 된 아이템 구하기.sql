SELECT item_tree.item_id, item_name, rarity
FROM item_tree
    INNER JOIN item_info
    ON item_tree.item_id = item_info.item_id
WHERE parent_item_id in (SELECT item_id FROM item_info WHERE rarity = "RARE")
ORDER BY item_id DESC