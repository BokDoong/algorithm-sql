-- 코드를 작성해주세요
SELECT YEAR(differentiation_date) AS YEAR, (MAX_VALUES.MAX_VALUE-SIZE_OF_COLONY) AS YEAR_DEV, id AS ID
FROM ecoli_data
    INNER JOIN (SELECT YEAR(differentiation_date) AS Y, MAX(size_of_colony) AS MAX_VALUE
               FROM ecoli_data
               GROUP BY YEAR(differentiation_date)) AS MAX_VALUES
    ON Y = YEAR(differentiation_date)
ORDER BY YEAR(differentiation_date) ASC, YEAR_DEV ASC