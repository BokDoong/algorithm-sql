-- 코드를 작성해주세요
SELECT count(*) AS FISH_COUNT
FROM fish_info
    INNER JOIN fish_name_info
    ON fish_info.fish_type = fish_name_info.fish_type
WHERE fish_name_info.fish_name = 'BASS' OR fish_name_info.fish_name = 'SNAPPER'