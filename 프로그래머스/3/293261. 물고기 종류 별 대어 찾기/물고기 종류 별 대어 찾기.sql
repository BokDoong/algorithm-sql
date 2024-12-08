-- 코드를 작성해주세요
SELECT fish_info.id, fish_name_info.fish_name, fish_info.length
FROM fish_info
    INNER JOIN fish_name_info
    ON fish_info.fish_type = fish_name_info.fish_type
WHERE fish_info.fish_type IN 
(
    SELECT fish_type
    FROM fish_info
    GROUP BY fish_type
    HAVING length = MAX(length)
)
ORDER BY fish_info.id ASC