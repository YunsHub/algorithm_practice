-- 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회하려 합니다. 2022년도 평가 점수가 가장 높은 사원들의 점수, 사번, 성명, 직책, 이메일을 조회
-- 2022년도의 평가 점수는 상,하반기 점수의 합을 의미하고, 평가 점수를 나타내는 컬럼의 이름은 SCORE로 조회


SELECT SUM(SCORE) AS SCORE, HG.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL FROM HR_GRADE AS HG JOIN HR_EMPLOYEES AS HE
ON HG.EMP_NO = HE.EMP_NO
GROUP BY EMP_NO
ORDER BY SCORE DESC
LIMIT 1