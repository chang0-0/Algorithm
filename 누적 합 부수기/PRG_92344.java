import java.util.*;

class Solution {
    public static int N, M;
    
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        
        int[][] prefixSum = new int[N + 1][M + 1];
        int len = skill.length;
        for(int i=0; i<len; i++) {
            int[] t = skill[i];
            
            int x1 = t[1];
            int y1 = t[2];
            int x2 = t[3];
            int y2 = t[4];
            int degree = t[5];
            
            if(t[0] == 1) {
                degree *= -1;
            }
            
            // 좌표 범위 표시
            prefixSum[x1][y1] += degree;
            
            // 반대되는 값을 마킹함으로써 0을 만들어냄.
            // 누적 합 계산할 때 이 뒤부터는 0으로 나오게 된다.
            prefixSum[x2 + 1][y1] -= degree;
            prefixSum[x1][y2 + 1] -= degree;
            
            
            prefixSum[x2 + 1][y2 + 1] += degree;
        }
        
        
        // 상하
        for(int i=0; i<=M; i++) {
            for(int j=0; j<N; j++) {
                prefixSum[j + 1][i] += prefixSum[j][i];
            }
        }
        
        // 좌우
        for(int i=0; i<=N; i++) {
            for(int j=0; j<M; j++) {
                prefixSum[i][j + 1] += prefixSum[i][j];
            }
        }
        
        int ans = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                board[i][j] += prefixSum[i][j];
                
                if(board[i][j] > 0) ans++;
            }
        }
        
        
        return ans;
    }
}