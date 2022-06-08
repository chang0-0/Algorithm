import java.util.*;

// 목표 : 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 
// 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 
// solution 함수를 작성해주세요.

// DFS로 전체를 거쳐 마지막에 바꿀 수 있는 값으로 갱신하면서 바꿈.
// 문자열 비교 : 문자열 전체 길이에서 charAt으로 분리해서 다른 단어가 1개 일 때,

// 마지막에 list와 words의 길이가 같을 경우는 return 0
// 길이가 다를 경우 list.size() return

public class Main_PM_단어변환_DFS {
	static boolean visit[];
	static int result = 0;
	
	public int solution(String begin, String target, String[] words) {
        result = 51;
        int length = words.length;
        visit = new boolean[length];
        
        // 1차원 배열이기때문에 반복 없이 한번에 전체 탐색
        System.out.println("DFS(" + begin + "," + target + "," + 0 + ", [] )");
        DFS(begin, target, 0, words);

        // result 값이 그대로 일 경우 0을 출력
        // result 값이 51이 아니다 = result 값 출력
        return result == 51 ? 0 : result;
	}
	
	// 전체를 탐색해서 begin2와 같은 단어가 있는지 체크.
	static void DFS(String word, String target, int count, String[] words) {
		// 최소 값 갱신
		if(word.equals(target)) {
			System.out.println("count : " + count);
			System.out.println("result : " + result);
			result = Math.min(count, result);
			return;
		}
		
		for(int i=0; i<words.length; i++) {
			if(!visit[i] && word_check(word, words[i])) {
				visit[i] = true;
				System.out.println("DFS(" + words[i] + "," + target + "," + (count+1) + ", [] )");
				DFS(words[i], target, count+1, words);
				visit[i] = false;
			}
		}	
	}
	
	// 단어가 같은지 다른질를 체크하는 함수
	static boolean word_check(String str1, String str2) {
		int length = str1.length();
		int wrong_count = 0;
		
		for(int i=0; i<length; i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				wrong_count ++;
			}
		}
		
		if(wrong_count == 1) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Main_PM_단어변환_DFS s = new Main_PM_단어변환_DFS();
		
		String begin = "hit";
		String target = "cog";
		String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(s.solution(begin, target, words));
		
	}
}
