-- 코드를 작성해주세요
SELECT fish_info.id, fish_name_info.fish_name, fish_info.length
FROM fish_info
    INNER JOIN (SELECT fish_type, MAX(length) AS max_value FROM fish_info GROUP BY fish_type) AS max_values
    ON fish_info.fish_type = max_values.fish_type AND fish_info.length = max_values.max_value
    INNER JOIN fish_name_info
    ON fish_info.fish_type = fish_name_info.fish_type
ORDER BY fish_info.id ASC