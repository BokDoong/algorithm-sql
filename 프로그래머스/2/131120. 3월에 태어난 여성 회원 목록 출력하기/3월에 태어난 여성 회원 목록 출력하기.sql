-- 코드를 입력하세요
SELECT mp.member_id, mp.member_name, mp.gender, DATE_FORMAT(mp.date_of_birth, '%Y-%m-%d')
FROM member_profile AS mp
WHERE MONTH(mp.date_of_birth) = 3 AND mp.tlno IS NOT NULL AND mp.gender = 'W'
ORDER BY mp.member_id