import java.util.*;

class Solution {
    // https://school.programmers.co.kr/learn/courses/30/lessons/92341
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        LinkedList<Integer> list = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<String, Integer> totalTime = new TreeMap<>();
        
        int N = records.length;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            
            String time = st.nextToken();
            String carNum = st.nextToken();
            String func = st.nextToken();
            
            int calcTime = changeTime(time);
            
            if(func.equals("IN")) {
                map.put(carNum, calcTime);
            } else {
                int t = map.get(carNum);
                int outTime = changeTime(time);
                                
                map.remove(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + (outTime - t));
            }
        }
        
        for(String s : map.keySet()) {
            int t = map.get(s);
            int outTime = changeTime("23:59");
            
            totalTime.put(s, totalTime.getOrDefault(s, 0) + (outTime - t));
        } 
         
        answer = new int[totalTime.size()];
        int idx = 0;
        for(String s : totalTime.keySet()) {
            int time = totalTime.get(s);
            answer[idx] += fees[1];
            time -= fees[0];
            
            if(time > 0) {
                answer[idx] += ( time / fees[2] ) * fees[3];
                
                int mod = (time % fees[2]);
                if(mod >= 1) {
                    answer[idx] += fees[3];
                }
            }
                   
            idx++;
        }
        
        return answer;
    } // End of solution()
    
    public int changeTime(String time) {
        int min = 0;
        StringTokenizer st = new StringTokenizer(time, ":");
        
        min += Integer.parseInt(st.nextToken()) * 60;
        min += Integer.parseInt(st.nextToken());
        
       return min; 
    } // End of changeTime()
} // End of Solutino class