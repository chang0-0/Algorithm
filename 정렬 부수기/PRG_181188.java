import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));
        // 뒤의 끝 좌표를 기준으로 정렬한다.
        
        int len = targets.length;
        int prev = -1;
        
        for(int i=0; i<len; i++) {
            int x1 = targets[i][0];
            int x2 = targets[i][1];
            
            if(prev <= x1) {
                prev = x2;
                answer++;
            }
        }
        
        
        return answer;
    } // End of solution()
} // End of Solution class