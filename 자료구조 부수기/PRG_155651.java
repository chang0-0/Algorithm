import java.util.*;

class Solution {
    public static class Time {
        int startTime;
        int endTime;
        
        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        @Override
        public String toString() {
            return "Time{" + startTime + ", " + endTime + "} \n";
        }
    } // End of Time class
    
    public int solution(String[][] book_time) {        
        int N = book_time.length;
        Time[] times = new Time[N];
        
        for(int i=0; i<N; i++) {
            int currentStart = changeTime(book_time[i][0]) - 10;
            int currentEnd = changeTime(book_time[i][1]);
            times[i] = new Time(currentStart, currentEnd);
        }
        
        // 시작 시간 순으로 정렬
        Arrays.sort(times, Comparator.comparingInt(t -> t.startTime));
        
                
        // pque에서 peek() 해서 나온 값이 다음 입실 하려는 예약자 보다 늦을 경우 방이 하나 더 필요하다는 의미임
        PriorityQueue<Time> pque = new PriorityQueue<>(new Comparator<Time> () {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.endTime - o2.endTime;
            }
        });
        

        int roomCount = 1;
        for(int i=0; i<N; i++) {
            Time t = times[i];

            // pque에서 peek해서 가장 먼저 끝나는 곳에 입실 한다 그런 방이 없을 경우 방사이즈를 늘리고 pque에 넣으면 됨
            // 있으면 poll()하고 offer()
            if(!pque.isEmpty() && pque.peek().endTime > t.startTime) {
                roomCount++;
                pque.offer(t);
            } else if(!pque.isEmpty() && pque.peek().endTime <= t.startTime) {
                pque.poll();
                pque.offer(t);
            } else if(pque.isEmpty()) {
                pque.offer(t);
            }
        }
        
        
        return roomCount;
    } // End of solution
    
    
    public int changeTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        m += h * 60;
        m += 10;
        return m;
    } // End of changeTime()
} // End of Solution class