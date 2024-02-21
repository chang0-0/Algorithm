import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int n = dartResult.length();
        int ans = 0;
        boolean flag = false;    
        StringBuilder sb = new StringBuilder();
        int[] scores = new int[3];
        int idx = 0;
        int bonus = 1;
        
        for(int i=0; i<n; i++) {
            int a = dartResult.charAt(i) - '0';
                        
            if(a >= 0 && a <= 9) {
                 sb.append(a);
                if(flag) {
                    flag = false;
                    idx++;
                }
            } else if(a < 0) {
                // 누적되는거 고려해야 함
                int score = 0;
                
                if(a == -6) {
                    // 스타상은 바로 직전점수를 포함하여 2배로 만든다.
                    int temp = idx;
                    if(temp == 0) {
                        temp = 1;
                    }
                    
                    for(int j=temp - 1; j<=temp; j++) {
                        scores[j] *= 2;    
                    }
                } else {       
                    // 아차상은 해당 점수 -1
                    scores[idx] *= -1;
                }
            } else if(a > 10) {
                int score = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                
                if(a == 35) {
                    ans += score;
                } else if(a == 20) {
                    ans += Math.pow(score, 2);
                } else if(a == 36) {
                    ans += Math.pow(score, 3);
                }  
                
                scores[idx] = ans;
                ans = 0;
                flag = true;
            }
        }
                
        for(int t : scores) {
            ans += t;
        }
        
        
        return ans;
    } // End of solution()
} // End of Solution class