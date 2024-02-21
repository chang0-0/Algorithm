import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {        
        int n = survey.length;
       
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();        
        map.put('R', 0) ;
        map.put('T', 0) ;
        map.put('C', 0) ;
        map.put('F', 0) ;
        map.put('J', 0) ;
        map.put('M', 0) ;
        map.put('A', 0) ;
        map.put('N', 0) ;

        
        for(int i=0; i<n; i++) {
            char ch1 = survey[i].charAt(0);
            char ch2 = survey[i].charAt(1);
            int num = choices[i];
            
            if(num >= 5) {
                map.put(ch2, map.getOrDefault(ch2, 0) + num - 4);
            } else if(num < 4) {
                if(num == 2) {
                    num = 2;
                } else {
                    num = 3 / num;
                }
                
                map.put(ch1, map.getOrDefault(ch1, 0) + num);
            }
        }
                
        StringBuilder sb = new StringBuilder();
        List<Character> keyList = new ArrayList<>(map.keySet());
        
        int s1 = 0;
        int s2 = 0;
        for(int i=0; i<8; i+=2) {
            char first = keyList.get(i);
            char second = keyList.get(i + 1);
            s1 = map.get(first);
            s2 = map.get(second);
                        
            if(s1 == s2) {
                if(first < second) {
                    sb.append(first);
                } else {
                    sb.append(second);
                }
            } else {
                if(s1 > s2) {
                    sb.append(first);
                } else {
                    sb.append(second);
                }
            }
        }
        
        
        return sb.toString();
    } // End of solution()
} // End of Solution class