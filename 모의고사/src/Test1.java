import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Test1 { 
	public static void main(String[] args) {
		
		Test1 t = new Test1();
		String x = "100";
		String y = "203045";
		
		System.out.println(t.solution(x, y));
	}// End of main
	
    public String solution(String X, String Y) {
    	String answer = "";
    	char c1[] = X.toCharArray();
    	char c2[] = Y.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	
    	HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
    	HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    	List<Character> resultList  = new ArrayList<>();
    	
    	int len1 = c1.length;
    	for(int i=0; i<len1; i++) {
    		map1.put(c1[i], map1.getOrDefault(c1[i], 0)+1);
    	}
    	
    	int len2 = c2.length;
    	for(int i=0; i<len2; i++) {
    		map2.put(c2[i], map2.getOrDefault(c2[i], 0)+1);
    	}
    	
    	// 겹치는 수가 없을 경우, -1을 출력 하기 위해서 check 변수를 통해서 체크
    	boolean check = true;
		Iterator<Entry<Character, Integer>> it = map1.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Character, Integer> entrySet = (Entry<Character, Integer>)it.next();
			char key = entrySet.getKey();
			int value = entrySet.getValue();
			
			if( map2.containsKey(key) ) {
				check = false; 
				
				// 만약 겹치는 수가 있다.
				// 그 키에 해당하는 value를 찾아서 갯수를 비교하고 작은 쪽을 list에 삽입
				int value2 = map2.get(key);
				int min = Math.min(value, value2);
				for(int i=0; i<min; i++) {
					resultList.add(key);
				}	
			}	
		}
   
		if(check == true) {
			answer = "-1";
			return answer;
		}
		
		check = true;
		Collections.sort(resultList, Collections.reverseOrder());		
		for(char c : resultList) {
			sb.append(c);			
		}
		
		if(Integer.parseInt(sb.toString()) == 0) {
			return "0";
		}
    	

        return sb.toString();
    }  // End of solution
} // End of Solution class