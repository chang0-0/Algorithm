import java.util.*;

class Solution {
    public static PriorityQueue<Time> pQue;
    
    public static class Time implements Comparable<Time> {
        int start;
        int end;
        
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Time o) {
            if(end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
        
        @Override
        public String toString() {
            return "Time{" + start + ", " + end + "} \n";
        } // End of toString() 
    } // End of Time class
    
    public int solution(String[][] book_time) {
        
        // 정렬 -> 끝나는 시간을 기준으로 정렬
        input(book_time);
        int ans = 0;
        
        while(!pQue.isEmpty()) {
            System.out.println(pQue.poll());
        }

        
        
        return ans;
    } // End of solution()
    
    public void input(String[][] book_time) {
        pQue = new PriorityQueue<>();
        
        for(int i=0; i<book_time.length; i++) {
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
            pQue.offer(new Time(startTime, endTime));
        } 
    } // End of input()
} // End of Solution 