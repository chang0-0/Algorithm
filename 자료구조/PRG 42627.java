import java.util.*;

class Solution {
    // https://school.programmers.co.kr/learn/courses/30/lessons/42627?language=java
    public static class Job implements Comparable<Job> {
        int requestTime;
        int requiredTime;
        
        public Job(int requestTime, int requiredTime) {
            this.requestTime = requestTime;
            this.requiredTime = requiredTime;
        }
        
        @Override
        public int compareTo(Job o) {
            return requiredTime - o.requiredTime;
        }
    } // End of Job class
    
    public int solution(int[][] jobs) {        
        
        PriorityQueue<Job> pque = new PriorityQueue<>();
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        int sum = 0;
        int n = jobs.length;
        int ans = 0;
        int nowTime = 0;
        int jobsIdx = 0;
        int count = 0;

        while(count < n) {
            
            // 요청시간이 현재 시간보다 크면 큐에서 대기
            while(jobsIdx < n && jobs[jobsIdx][0] <= nowTime) {
                pque.offer(new Job(jobs[jobsIdx][0], jobs[jobsIdx++][1] ));
            }    
            
            
            if(pque.isEmpty()) {
                nowTime = jobs[jobsIdx][0]; // 요청시간이 현재 시간이 된다.
            } else {
                Job temp = pque.poll();
                ans += temp.requiredTime + nowTime - temp.requestTime;
                nowTime += temp.requiredTime;
                count++;
            }
        }
    
        
        return ans / n;
    } // End of solution()
} // End of Solution class
