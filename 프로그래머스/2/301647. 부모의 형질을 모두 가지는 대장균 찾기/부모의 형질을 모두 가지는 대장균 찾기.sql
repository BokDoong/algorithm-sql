-- 코드를 작성해주세요
SELECT s.id, s.genotype, p.genotype AS PARENT_GENOTYPE
FROM ecoli_data AS s
    INNER JOIN ecoli_data AS p
    ON s.parent_id = p.id
WHERE p.genotype & s.genotype >= p.genotype
ORDER BY s.id