// 문제 : 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 
// 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

public class Main_PM_단어변환 {
	static String words[];
	static boolean visit[];
	static int result = Integer.MAX_VALUE;
	static String target;
	
	public static void main(String[] args) throws Exception  {
		Main_PM_단어변환 s = new Main_PM_단어변환();
		
		String begin = "hit";
		String target = "cog";
		String words[] = { "hot", "dot", "dog", "lot", "log", "cog" };
		
		System.out.println(s.solution(begin, target, words));
	} // End of main

    public int solution(String begin, String target, String[] words) {
    	this.target = target;
    	this.words = words;
    	visit = new boolean[words.length];
    	
    	DFS(begin, 0);
    	if(result == Integer.MAX_VALUE) {
    		return 0;
    	}
    	
        return result;
    } // End of solution
	
    static void DFS(String begin, int count) {
    	
    	// 탈출조건
    	if( begin.equals(target) ) {
    		result = Math.min(result, count);
    		return;
    	}
    	
    	int len = words.length;
    	for(int i=count; i<len; i++) {
    		
    		if(visit[i]) continue;
    		
    		if( check(begin, words[i])) {
    			visit[i] = true;
    			DFS(words[i], count + 1);
    			visit[i] = false;
    		}
    	}
    } // End of DFS
    
    // 단어가 한 글자만 건너갈 수 있음
    static boolean check(String begin, String word) {
    	int count = 0;
    	
    	for(int i=0; i<begin.length(); i++) {
    		char ch = begin.charAt(i);
    		char ch2 = word.charAt(i);
    		
    		if(ch == ch2) {
    			count ++;
    		}
    	}
    	
    	// begin단어와 비교해서 한글자만 다르거나 모두 같을경우
    	if(count == begin.length()-1) {
    		return true;
    	}
    	
    	return false;
    } // End of check
    
} // End of Main class