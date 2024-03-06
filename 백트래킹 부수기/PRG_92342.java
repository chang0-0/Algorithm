import java.util.*;

class Solution {
    public static int N, M, max;
    public static boolean[] isVisited;
    public static int[] comb;
    public static int[] ans;
    
    
    public int[] solution(int n, int[] info) {
        input(n, info);
        
        DFS(0, info);
        
        if(max == -1) {
            return new int[] {-1};
        }
        
        return ans;
    } // End of solution()
    
    public void DFS(int depth, int[] info) {
        if(depth == N) {
            int diff = scoreCalc(info);
            if(max <= diff) {
                max = diff;
                ans = comb.clone();
            }
            return;
        }
        
        for(int i=0; i<info.length && comb[i] <= info[i]; i++) {
            comb[i]++;
            DFS(depth + 1, info);
            comb[i]--;
        }
        
    } // End of DFS()
    
    public int scoreCalc(int[] info){
        int lion = 0;
        int apeach = 0;
        
        for(int i=0; i<M; i++) {
            if(info[i] == 0 && comb[i] == 0) continue;
            
            if(info[i] >= comb[i]) apeach += (10 - i);
            else lion += (10 - i);
        }
        
        int diff = lion - apeach;
        if(diff <= 0) return -1;
        return diff;        
    } // End of scoreCalc()
    
    public void input(int n, int[] info) {
        N = n;
        M = info.length;
        max = Integer.MIN_VALUE;
        comb = new int[M];
        ans = new int[M];
    }// End of input()
} // End of Solution class
