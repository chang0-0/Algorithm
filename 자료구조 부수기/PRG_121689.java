import java.util.*;

class Solution {    
    
    public int solution(int[] menu, int[] order, int k) {
        // 카페에서 최대 몇명이 머물렀는지 알고 싶다.
        int m = order.length;
        int max = 0;
        int lastOrderEndTime = 0;
        PriorityQueue<Integer> pque = new PriorityQueue<>();        
        
        for(int i=0; i<m; i++) {   
            int nowTime = i * k;

            // 나가는 손님이 먼저 퇴장한 다음 들어오는 손님이 입장한다.
            while(!pque.isEmpty() && pque.peek() <= nowTime) {
                pque.poll();
            }
            
            if(pque.isEmpty()) {
                // 가장 최근에 주문한 끝나는 시간
                lastOrderEndTime = nowTime + menu[order[i]];
            } else {
                lastOrderEndTime += menu[order[i]];
            }
            
            
            pque.offer(lastOrderEndTime);
            max = Math.max(max, pque.size());            
        }
        
        return max;
    } // End of solution()
} // End of Solution class