-- 코드를 입력하세요
SELECT car_id from CAR_RENTAL_COMPANY_CAR r where r.car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where START_DATE >= "2022-10-01 00:00:00") and car_type like "세단" order by car_id desc;


-- select * from CAR_RENTAL_COMPANY_CAR where car_id in (3, 4, 6, 8, 10, 12, 13, 15, 18, 20, 21, 23, 30) and car_type like "세단";