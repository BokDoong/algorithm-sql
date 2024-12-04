-- 코드를 입력하세요
# 전체 조회
# SELECT * FROM CAR_RENTAL_COMPANY_CAR
SELECT ROUND(AVG(daily_fee)) AS AVERAGE_FEE
    FROM car_rental_company_car
    WHERE car_type = 'SUV'