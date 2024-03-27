import java.util.*;

class Solution {
    public String solution(String input_string) {        
        char[] chArr = input_string.toCharArray();
        int n = chArr.length;
        
        TreeMap<Character, Integer> map = new TreeMap<>();
                
        boolean flag = false;
        char ch = ' ';
        for(int i=0; i<n - 1; i++) {
            ch = chArr[i];
            
            if(flag && chArr[i + 1] != ch) {
                flag = false;
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } else if(!flag && chArr[i + 1] != ch) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
             
            if(ch == chArr[i + 1]) {
                flag = true;
            }
        }
        
        if(ch != chArr[n - 1]) {    
            map.put(chArr[n - 1], map.getOrDefault(chArr[n - 1], 0) + 1);
        } else {
            map.put(ch, map.getOrDefault(ch, 0) + 1);           
        }

        StringBuilder sb = new StringBuilder();
        for(char c : map.keySet()) {
            if(map.get(c) >= 2) {
                sb.append(c);
            }
        }
        
        if(sb.length() == 0) {
            sb.append("N");
        }
                
        return sb.toString();
    } // End of solution()
} // End of Solution class