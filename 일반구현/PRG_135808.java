import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {        
        int n = score.length;
        int sum = 0;
        Arrays.sort(score);
        
        List<Integer> list;
        for(int i = n - 1; i >= 0; i-=m) {
            list = new ArrayList<>();

            for (int j = i; j > i - m && j >= 0; j--) {
                list.add(score[j]);
            }
            
            if(list.size() == m) {
                sum = sum + Collections.min(list) * m;
            }
        }
        
        
        return sum;
    } // End of solution()
} // End of Solution class