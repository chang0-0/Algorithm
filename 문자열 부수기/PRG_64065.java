import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        
        // 튜플에서 원소의 개수로 정렬을 해서
        // 먼저들어온 값이 해당 자리로 간다.
        
        // 중복되는 원소가 없다.
        
        // {2} -> 첫 번째 자리는 2다.
        // {2, 1} -> 두 번째 자리는 1이다
        // {2, 3, 1} -> 세 번째자리는 3이다.
        // {4, 2, 3, 1} -> 네 번째 자리는 4이다.
        
        int n = s.length();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> list = new ArrayList<>();
        list = new ArrayList<>();
        
        for(int i=1; i<n-1; i++) {
            char ch = s.charAt(i);
            
            if(ch == '{') {
                flag = true;
                continue;
            } else if(ch == '}') {
                flag = false;
                StringTokenizer st = new StringTokenizer(sb.toString(), ",");
                
                List<Integer> tempList = new ArrayList<>();
                while(st.hasMoreTokens()) {
                    int temp = Integer.parseInt(st.nextToken());
                    tempList.add(temp);
                }

                list.add(tempList);
                sb = new StringBuilder();
            }
            
            
            if(flag) {
                sb.append(ch);
            }
        }
        
        Collections.sort(list, (o1, o2) -> o1.size() - o2.size());
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ansList = new ArrayList<>();
        for(List<Integer> temp : list) {
            int size = temp.size();
            
            for(int i=0; i<size; i++) {
                if(set.add(temp.get(i))) {
                    ansList.add(temp.get(i));
                    break;
                }
            }
        }
                
        
        return ansList;
    } // End of solution()
} // End of Solution class