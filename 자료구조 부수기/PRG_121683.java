import java.util.*;

public class Solution {
    
    public static class Program implements Comparable<Program> {
        int score;
        int calledTime;
        int finishedTime;

        public Program(int score, int calledTime, int finishedTime) {
            this.score = score;
            this.calledTime = calledTime;
            this.finishedTime = finishedTime;
        }

        @Override
        public int compareTo(Program o) {
            if(score == o.score) {
                return calledTime - o.calledTime;
            }
            
            return score - o.score;
        }
    } // End of Program class
    
    public static long[] solution(int[][] programs) {
        int N  = programs.length;
        
        Arrays.sort(programs, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            
            return Integer.compare(o1[1], o2[1]);
        });
        
        PriorityQueue<Program> waitingQue = new PriorityQueue<>();
        long[] ans = new long[11];
        
        long time = -1;
        int run = 0;
        int idx = 0;
        
        for(;;) {
            if(idx == N && waitingQue.isEmpty() && run == 0) {
                break;
            }
            
            time++;
            if(run > 0) {
                run--;
            }
            
            while(idx < N && programs[idx][1] == time) {
                waitingQue.offer(new Program(programs[idx][0], programs[idx][1], programs[idx][2] ));
                idx++;
            }
            
            if(run == 0 && !waitingQue.isEmpty()) {
                Program current = waitingQue.poll();
                
                run += current.finishedTime;
                ans[current.score] += time - current.calledTime;
            }   
        }
        
        ans[0] = time;
        
        return ans;
    } // End of solution()
} // End of Solution class
