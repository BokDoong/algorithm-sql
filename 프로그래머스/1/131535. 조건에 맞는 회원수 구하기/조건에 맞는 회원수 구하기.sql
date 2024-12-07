-- 코드를 입력하세요
# SELECT COUNT(*) as USERS
SELECT COUNT(*) as USERS
FROM user_info
WHERE YEAR(joined) = 2021 AND (age BETWEEN 20 AND 29)