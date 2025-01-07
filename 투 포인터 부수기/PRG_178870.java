import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int N = sequence.length;
        int left = 0;
        int sum = 0;
        int size = N;
        int[] ans = new int[2];
        
        for(int i=0; i<N; i++) {
            sum += sequence[i];
            
            while(i < N && sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k) {
                if(size > i - left) {
                    size = i - left;
                    ans[0] = left;
                    ans[1] = i;
                }
            }
        }
        
        
        return ans;
    } // End of Solution()
} // End of Solution class
