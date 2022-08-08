import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 t = new Solution2();
		String want[] = {"banana", "apple", "rice", "pork", "pot"};
		int number[] = {3, 2, 2, 2, 1};
		String discount[] = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		
		System.out.println(t.solution(want, number, discount));
	}// End of main
	
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
        	map.put(want[i], number[i]);
        }
        
        int len = discount.length;
        boolean check = true;
//        for(int i=0; i<len; i++) {
//        	if(map.containsKey(discount[i])) {
//        		// 같은 값이 있을 경우 check = false
//        		check = false;
//        		break;
//        	}
//        }
//        
//        // 같은 값이 없음
//        if(check == true) {
//        	return 0;
//        }

        int sum = 0;
        len = len - 10;
        for(int i=0; i<=len; i++) {
        	HashMap<String, Integer> discountMap = new HashMap<>();
        	for(int j=i; j<i+10; j++) {
        		System.out.print(discount[j] + " ");
        		discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0)+1);
        	}
        	System.out.println(" ");
        	
        	check = true;
    		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
    		while(it.hasNext()) {
    			Entry<String, Integer> entrySet = (Entry<String, Integer>)it.next();
    			String key = entrySet.getKey();
    			int value = entrySet.getValue();
    			
    			//key에 해당하는 값과 한번이라도 다를 경우,
    			if(discountMap.containsKey(key)) {
    				if(discountMap.get(key) != value ) {
        				// 개수가 다르면 곧바로 break;
        				check = false;
        				break;
        			}
    			}
    		}
    		
    		if(check == true) {
    			sum++;
    		}
        }
        
        return sum;
    } // End of solution
} // End of Test2 class