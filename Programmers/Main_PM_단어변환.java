
public class Main_PM_단어변환 {
	static String words[];
	static boolean visit[];
	static int result = Integer.MAX_VALUE / 16;
	
	public static void main(String[] args) {
		Main_PM_단어변환 s = new Main_PM_단어변환();
		
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		System.out.println(s.solution(begin, target, words));
	} // End of main
	
    public int solution(String begin, String target, String[] words) {
        this.words = words;    	
        visit = new boolean[words.length];
        DFS(begin, target, 0);
        
        if(result == Integer.MAX_VALUE / 16) {
        	return 0;
        }
    	
    	return result;
    } // End of solution
	
    static void DFS(String begin, String target, int count) {
    	
    	if(begin == target) {
    		result = Math.min(result, count);
    		return;
    	}
    	
    	int len = words.length; 
    	for(int i=0; i<len; i++) {
    		
    		if( !visit[i] && check(begin, words[i])) {
    			visit[i] = true;
    			DFS(words[i], target, count + 1);
    			visit[i] = false;
    		}
    	}
    } // End of DFS
    
    static boolean check(String begin, String str) {
    	int count = 0;
    	
    	for(int i=0; i<begin.length(); i++) {
    		if(begin.charAt(i) == str.charAt(i)) {
    			count++;
    		}
    	}
    	
    	if(count >= begin.length() - 1) {
    		return true;
    	}
    	
    	return false;
    } // End of check

} // End of class