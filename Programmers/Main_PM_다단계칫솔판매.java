import java.util.Arrays;
import java.util.HashMap;

// 문제 : https://programmers.co.kr/learn/courses/30/lessons/77486?language=java
// 판매원에게 배분된 이익금의 총합을 계산하여(정수형으로), 입력으로 주어진 enroll에 이름이 포함된 순서대로 나열

public class Main_PM_다단계칫솔판매 {
	static HashMap<String, String> memberMap = new HashMap<>(); // 자식 key, 부모 value
	static HashMap<String, Integer> result = new HashMap<>();
	
	public static void main(String[] args) {
		Main_PM_다단계칫솔판매 s = new Main_PM_다단계칫솔판매();
		
		String enroll[] = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String referral[] = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String seller[] = {"young", "john", "tod", "emily", "mary"};
		int amount[] = {12, 4, 2, 5, 10};
		
		System.out.println( Arrays.toString(s.solution(enroll, referral, seller, amount))  );
	} // End of main
	
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    	int len = enroll.length;
    	for(int i=0; i<len; i++) {
    		memberMap.put(enroll[i], referral[i]);
    		result.put(enroll[i], 0);
    	}
    	
    	len = amount.length;
    	for(int i=0; i<len; i++) {
    		distribution(seller[i], amount[i]*100);
    	}
    	
    	len = result.size();
    	int[] answer = new int[len];
    	for(int i=0; i<len; i++) {
    		answer[i] = result.get(enroll[i]);
    	}
    	
        return answer;
    } // End of solution
    
    // 자식의 부모를 찾고, 또 다시 해당 부모가 자식이 되어 부모를 찾는 방식
    // 마지막에 value가 '-'일 경우 return 
    static void distribution(String name, int amount) {

    	// 판매한 본인이 먼저 값을 가져감
    	String par = "";
    	int rest = amount / 10;
    	int pay =  amount - rest;
    	if(result.containsKey(name)) {
    		result.put(name, result.get(name) + pay); 
    		par = memberMap.get(name);
    	}
    
    	while( !par.equals("-") ) {

    		int total = rest;
    		if(total < 1) {
    			return;
    		}
    		
        	rest = total / 10;
        	pay =  total - rest;
    		result.put(par, result.get(par) + pay);
    		par = memberMap.get(par); 
    	} 
    	
    } // End of distribution
	
} // End of Main class