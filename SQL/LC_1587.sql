
# 잔액이 10,000을 초과하는 사용자들의 이름과 잔액을 조회하는 쿼리를 작성하시오.
# 계좌의 잔액은 해당 계좌와 관련된 모든 거래 금액의 합계입니다.

SELECT
    NAME,
    SUM(AMOUNT) AS BALANCE
FROM USERS U
JOIN TRANSACTIONS T
ON U.ACCOUNT = T.ACCOUNT
GROUP BY U.ACCOUNT
HAVING SUM(AMOUNT) > 10000

-- | NAME  | BALANCE |
-- | ----- | ------- |
-- | Alice | 11000   |


