import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        
        int N = skill.length();
        int M = skill_trees.length;
        char[] skillArr = skill.toCharArray();
        List<Character> skillList = IntStream.range(0, N).mapToObj(i -> skillArr[i]).collect(Collectors.toList());
                
        for(int i=0; i<M; i++) {
            char[] chArr = skill_trees[i].toCharArray();
            int len = chArr.length;
            int idx = 0;
            boolean flag = false;
            
            for(int j=0; j<len; j++) {
                char ch = chArr[j];
                
                if(skillList.contains(ch) && skillList.get(idx) != ch )  {
                    flag = true;
                    break;   
                } else if(skillList.contains(ch) && skillList.get(idx) == ch) {
                    idx++;
                }
            }
            
            if(!flag) {
                ans++;
            }
        }
        
        
        
        return ans;
    } // End of solution()
} // End of Solution class