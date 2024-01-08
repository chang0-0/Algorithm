import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ans = new int[id_list.length];
        
        // 신고당한 ID, 신고 당한 횟수
        HashMap<String, List<String>> reportMap = new HashMap<>();

        int len = report.length;
        for(int i=0; i<len; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);     
            String temp1 = st.nextToken(); // 신고한 사람
            String temp2 = st.nextToken(); // 신고당한 사람
            
            if(reportMap.get(temp2) == null) {
                List<String> tempList = new ArrayList<>();
                tempList.add(temp1); 
                reportMap.put(temp2, tempList);
            } else {
                List<String> tempList = reportMap.get(temp2);
                
                if(tempList.contains(temp1)) continue;
                
                tempList.add(temp1);
                reportMap.remove(temp2);
                reportMap.put(temp2, tempList);
            }
        }
                
        for(String id : reportMap.keySet()) {
            if(reportMap.get(id).size() < k) continue;
                        
            for(int i=0; i<id_list.length; i++) {
                String name = id_list[i];
                
                if(reportMap.get(id).contains(name)) {
                    ans[i]++;
                }
            }
        }
        
        
        return ans;
    } // End of solution()
} // End of Solution class