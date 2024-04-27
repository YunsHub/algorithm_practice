-- 월별 잡은 물고기의 수와 월을 출력하는 SQL문을 작성해주세요.
-- 잡은 물고기 수 컬럼명은 FISH_COUNT, 월 컬럼명은 MONTH로 해주세요.
-- 월을 기준으로 오름차순 정렬해주세요.

SELECT COUNT(*) AS FISH_COUNT, MONTH(TIME) AS MONTH FROM FISH_INFO
GROUP BY MONTH(TIME)
ORDER BY MONTH(TIME)