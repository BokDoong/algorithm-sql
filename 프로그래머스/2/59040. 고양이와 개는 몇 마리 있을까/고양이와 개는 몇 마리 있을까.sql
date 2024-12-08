-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(*)
FROM animal_ins
WHERE animal_type = 'Cat' OR animal_type = 'Dog'
GROUP BY animal_type
ORDER BY animal_type ASC