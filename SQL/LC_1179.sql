
SELECT
    ID,
    MAX(CASE WHEN MONTH = 'Jan' THEN REVENUE END) AS Jan_Revenue,
    MAX(CASE WHEN MONTH = 'Feb' THEN REVENUE END) AS Feb_Revenue,
    MAX(CASE WHEN MONTH = 'Mar' THEN REVENUE END) AS Mar_Revenue,
    MAX(CASE WHEN MONTH = 'Apr' THEN REVENUE END) AS Apr_Revenue,
    MAX(CASE WHEN MONTH = 'May' THEN REVENUE END) AS May_Revenue,
    MAX(CASE WHEN MONTH = 'Jun' THEN REVENUE END) AS Jun_Revenue,
    MAX(CASE WHEN MONTH = 'Jul' THEN REVENUE END) AS Jul_Revenue,
    MAX(CASE WHEN MONTH = 'Aug' THEN REVENUE END) AS Aug_Revenue,
    MAX(CASE WHEN MONTH = 'Sep' THEN REVENUE END) AS Sep_Revenue,
    MAX(CASE WHEN MONTH = 'Oct' THEN REVENUE END) AS Oct_Revenue,
    MAX(CASE WHEN MONTH = 'Nov' THEN REVENUE END) AS Nov_Revenue,
    MAX(CASE WHEN MONTH = 'Dec' THEN REVENUE END) AS Dec_Revenue
FROM DEPARTMENT
GROUP BY ID;



-- | ID | Jan_Revenue | Feb_Revenue | Mar_Revenue | Apr_Revenue | May_Revenue | Jun_Revenue | Jul_Revenue | Aug_Revenue | Sep_Revenue | Oct_Revenue | Nov_Revenue | Dec_Revenue |
-- | -- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
-- | 1  | 8000        | 7000        | 6000        | null        | null        | null        | null        | null        | null        | null        | null        | null        |
-- | 2  | 9000        | null        | null        | null        | null        | null        | null        | null        | null        | null        | null        | null        |
-- | 3  | null        | 10000       | null        | null        | null        | null        | null        | null        | null        | null        | null        | null        |
