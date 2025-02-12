import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        
        for(Map.Entry<Integer, Integer> entry : list) {
            int v = entry.getValue();

            k -= v;
            answer++;
            if(k <= 0) {
                break;
            }  
        }
        
        
        return answer;
    } // End of solution()
} // End of Solution class