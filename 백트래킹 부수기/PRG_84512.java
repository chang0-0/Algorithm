import java.util.*;

class Solution {
    // 백트래킹
    private static final char[] chArr = {'A', 'E', 'I', 'O', 'U'};
    private static final int MAX = 5;
    private static boolean flag;
    private static int N, count;
    private static String word;
    
    public int solution(String word) {
        input(word);
        
        DFS(0, 0, "");
        return count;
    } // End of solution() 
    
    public void DFS(int depth, int idx, String str) {
        if(flag) return;
        
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        
        if(depth <= MAX) {            
            if(word.equals(str)) {
                flag = true;
                return;
            }
            count++;
            
            if(depth == MAX) {
                return;
            }
        }
        
        for(int i=idx; i<MAX; i++) {        
            sb.append(chArr[i]);
            DFS(depth + 1, idx, sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }
    } // End of DFS()
    
    public void input(String word) {
        this.word = word;
        N = word.length();
        count = 0;
        flag = false;
    } // End of input()
} // End of Solution class