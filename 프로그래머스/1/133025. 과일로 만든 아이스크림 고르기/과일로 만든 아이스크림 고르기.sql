-- 코드를 입력하세요
SELECT first_half.flavor
FROM first_half
    INNER JOIN icecream_info
    ON first_half.flavor = icecream_info.flavor
WHERE icecream_info.ingredient_type = 'fruit_based' AND first_half.total_order > 3000
ORDER BY first_half.total_order DESC