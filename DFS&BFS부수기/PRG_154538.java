import java.util.*;

class Solution {
    
    public static class Number implements Comparable<Number> {
        int num;
        int count;
        
        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
        
        @Override
        public int compareTo(Number o) {
            return count - o.count;
        }
    } // End of Number class
    
    public int solution(int x, int y, int n) {
        return BFS(x, y, n);
    } // End of solution()
    
    
    public int BFS(int x, int y, int n) {
        PriorityQueue<Number> que = new PriorityQueue<>();
        boolean[] isVisited = new boolean[y * 3];
        
        que.offer(new Number(x, 0));
        isVisited[x] = true;
       
        while(!que.isEmpty()) {
            Number cur = que.poll();
            
            if(cur.num == y) {
                return cur.count;
            } 
            
            int[] op = {cur.num + n, cur.num * 2, cur.num * 3};
            
            for(int nextNum : op) {
                if(isVisited[nextNum] || nextNum > y) continue;
                
                que.offer(new Number(nextNum, cur.count + 1));
                isVisited[nextNum] = true;
            }       
        }
        
        return -1;
    } // End of BFS()
} // End of Solution class
