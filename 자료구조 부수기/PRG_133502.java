import java.util.*;

class Solution {
    // 1 2 3 1 -> 1 3 2 1
    public static final int[] HAM = {1, 3, 2, 1};
    
    public int solution(int[] ingredient) {
        int answer = 0;
        
        LinkedList<Integer> list = new LinkedList<>();
        int n = ingredient.length;
        
        for(int i=0; i<n; i++) {
            int el = ingredient[i];
            list.offerFirst(el);
            
            if(el == 1 && list.size() >= 4) {
                LinkedList<Integer> tempList = new LinkedList<>();
                boolean flag = false;
                
                for(int j=0; j<4; j++) {
                    int v = list.peekFirst();
                    if(HAM[j] != v) {
                        flag = true;
                        break;
                    }
                    
                    tempList.offer(list.pollFirst());
                }
                
                while(flag && !tempList.isEmpty()) {
                    list.offerFirst(tempList.pollLast());
                }
                
                
                if(!flag) {
                    answer++;
                }
            }
        }
        
        
        return answer;
    } // End of solution()
} // End of Solution class