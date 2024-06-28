import java.util.*;

// https://leetcode.com/problems/unique-paths-ii/description/
class Solution {
    private static int[][] map, memo;
    private static int N, M;    

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        N = obstacleGrid.length;
        M = obstacleGrid[0].length;
        map = obstacleGrid;
        memo = new int[N][M];
        for(int i=0; i<N; i++) {
            Arrays.fill(memo[i], -1);
        }

        int ret = topDown(N - 1, M - 1);

        return ret;        
    } // End of uniquePathsWithObstacles()

    private int topDown(int n, int m) {
        if(n < 0 || m < 0) return 0;
        else if(map[n][m] == 1) return 0;
        else if(n == 0 && m == 0) return 1;

        if(memo[n][m] != -1) return memo[n][m];

        memo[n][m] = topDown(n - 1, m) + topDown(n, m - 1);

        return memo[n][m];
    } // End of topDown()
} // End of Solution class
