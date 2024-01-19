import java.util.*;

class Solution {
    public static PriorityQueue<Time> pQue;
    public static Time[] times;
    
    public static class Time implements Comparable<Time> {
        int start;
        int end;
        
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Time o) {
            return end - o.end;
        }
    } // End of Time class
    
    public int solution(String[][] book_time) {
        
        input(book_time);
        int ans = 0;
    
        Arrays.sort(times, Comparator.comparingInt(o -> o.start));
        
        for(Time time : times) {
            if(!pQue.isEmpty() && time.start >= pQue.peek().end) {
                pQue.poll();
            } else {
                ans++;
            }
            pQue.offer(time);
        }

        return ans;
    } // End of solution()
    
    public void input(String[][] book_time) {
        pQue = new PriorityQueue<>();
        int N = book_time.length;
        times = new Time[N];
        
        for(int i=0; i<N; i++) {
            int startTime = 0;
            int endTime = 0;
            
            for(int j=0; j<2; j++) {
                String time = book_time[i][j];
                
                StringTokenizer st = new StringTokenizer(time, ":");
                StringBuilder sb = new StringBuilder();
          
                if(j == 0) { 
                    sb.append(st.nextToken()).append(st.nextToken());
                    startTime = Integer.parseInt(sb.toString());
                } else {
                    int H = Integer.parseInt(st.nextToken());
                    int M = Integer.parseInt(st.nextToken());
                    
                    M += 10;
                    if(M >= 60) {
                        H++;
                        M = M % 60;               
                        sb.append(H).append("0").append(M);
                    } else {
                        sb.append(H).append(M);
                    }       

                    endTime = Integer.parseInt(sb.toString());
                }
            }
            times[i] = new Time(startTime, endTime);
        } 
    } // End of input()
} // End of Solution 