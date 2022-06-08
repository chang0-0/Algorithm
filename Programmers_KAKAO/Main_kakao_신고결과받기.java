import java.util.*;
import java.io.*;

public class Main_kakao_신고결과받기 {
	StringTokenizer st = null;
	static HashMap<String, Integer> reportMap = new HashMap<>();
	static List<String> ban = new ArrayList<>();

	
	// 결과 처리를 받은 메일 숫자를 출력
    public int[] solution(String[] id_list, String[] report, int k) {
    	int size = report.length;
    	
    	for(int i=0; i<size; i++) {
    		String str = report[i];
    		st = new StringTokenizer(str);
    		st.nextToken();
    		String name = st.nextToken();
    		reportMap.put(name, reportMap.getOrDefault(name, 0) +1);
    	}
    	
    	Set<String> keySet = reportMap.keySet();
    	for(String key : keySet) {
    		if(reportMap.get(key) >= 2) {
    			ban.add(key);
    		}
    	}
    	
    	reportMap.clear();

    	for(int i=0; i<size; i++) {
    		String str = report[i];
    		st = new StringTokenizer(str);
     		String name1 = st.nextToken();
    		String name2 = st.nextToken();
    		
    		for(String ban_name : ban) {
    			if(ban_name.equals(name2)) {
    				reportMap.put(name1, reportMap.getOrDefault(name1, 0)+1);
    			}
    		}
    	}
    	
    	System.out.println(reportMap);

    	
    	
        int[] answer = {};
        return answer;
    }
	
	public static void main(String[] args) {
		Main_kakao_신고결과받기 s = new Main_kakao_신고결과받기();
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
	
		System.out.println( Arrays.toString(s.solution(id_list, report, k)));
		
	}
}
