import java.util.*;

class Solution {
	// https://school.programmers.co.kr/learn/courses/15009/lessons/121689

    public static class Order implements Comparable<Order> {
        int inTime;
        int outTime;
        
        public Order(int inTime, int outTime) {
            this.inTime = inTime;
            this.outTime = outTime;
        }
        
        @Override
        public int compareTo(Order o) {
            return inTime - o.inTime;
        }
    } // End of Order class
    
    public int solution(int[] menu, int[] order, int k) {
        int ans = 0;
        
        // 백트래킹은 아니고 완탐, 또는 자료구조 문제?
        int n = menu.length;
        int m = order.length;
        PriorityQueue<Order> pque = new PriorityQueue<>();
            int lastOutTime = 0;

        for(int i=0; i<m; i++) {
            int orderMenu = order[i];
            int nowTime = i * k;
            
            // 앞의 주문이 먼저 끝난 후에 다음 주문이 시작된다.
            while(!pque.isEmpty() && pque.peek().outTime <= nowTime) {
                pque.poll();
            }
            
            int outTime = 0;
            if(!pque.isEmpty()) {
                outTime = lastOutTime + menu[orderMenu];
            } else {
                outTime = nowTime + menu[orderMenu];
            }
            
            pque.offer(new Order(nowTime, outTime));
            ans = Math.max(ans, pque.size());            
            lastOutTime = outTime;
        }
        
        ans = Math.max(ans, pque.size());
        
        return ans;
    } // End of solution()
} // End of Solution class