-- 코드를 입력하세요
SELECT ingredient_type, SUM(total_order) AS TOTAL_ORDER
FROM first_half
    INNER JOIN icecream_info
    ON first_half.flavor = icecream_info.flavor
GROUP BY ingredient_type
ORDER BY TOTAL_ORDER ASC