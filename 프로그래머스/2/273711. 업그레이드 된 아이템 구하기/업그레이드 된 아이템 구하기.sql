-- 코드를 작성해주세요
SELECT item_tree.item_id, item_info.item_name, item_info.rarity
FROM item_tree
    INNER JOIN item_info
    ON item_tree.item_id = item_info.item_id
WHERE item_tree.parent_item_id IN (SELECT item_id FROM item_info WHERE rarity = 'RARE')
ORDER BY item_info.item_id DESC