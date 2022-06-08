import java.util.*;

// 목표 : 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 
// 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

public class Main_PM_Hash_위장 {
	static HashMap<String, Integer> map = new HashMap<>();
	static int count;
	
	public int solution(String[][] clothes) {
		StringTokenizer st = null;
		count = 1;
		
		for(String[] clothe : clothes) {
			String type = clothe[1];
			map.put(type, map.getOrDefault(type,  0) + 1);
		}
		
		Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
        	// Iterator에서 Integer형 이기 때문에 산술 연산을 하기 위해 intValue()를 사용함.
        	// 입지 않는 경우 None도 추가해줘야 하기 때문에 + 1을 해준다.
            count *= it.next().intValue() + 1; 
        }
                
        
        // 마지막 None 끼리의 조합을 제거하기 위해 - 1을 해준다.
        // 적어도 하나는 입어야함.
        return count - 1;
	}
	

	public static void main(String[] args) {
		Main_PM_Hash_위장 s = new Main_PM_Hash_위장();
		
		String clothes[][] = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},
				{"green_turban", "headgear"}};
		
		System.out.println(s.solution(clothes));
	}

}
