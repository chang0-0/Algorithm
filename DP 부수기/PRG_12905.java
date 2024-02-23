import java.util.*;

class Solution {
    public static int[][] memo;
    
    public int solution(int [][]board) {
        int ans = 0;

        // 1의 각 정보를 가지고 있고 -> 정렬
        int n = board.length;
        int m = board[0].length;
        memo = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1) {
                    ans = Math.max(ans, topDown(board, i, j));
                }
            }
        }

        return ans * ans;
    } // End of solution()
    
    public int topDown(int[][] board, int x, int y) {
        if(x < 0 || y < 0 || board[x][y] == 0) return 0;
        if(memo[x][y] != -1) return memo[x][y];
        
        memo[x][y] = Math.min( Math.min(topDown(board, x - 1, y), topDown(board, x, y - 1)), topDown(board, x - 1, y - 1)) + 1;
        
        return memo[x][y];
    } // End of topDown()
} // End of Solution class