import java.io.*;
import java.util.*;

public class Main_2108_통계학 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2108.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		
		int loop = Integer.parseInt(br.readLine());
		double sum = 0;
		for(int i=0; i<loop; i++) {
			int temp = Integer.parseInt(br.readLine());
			sum += (double) temp;
			list.add(temp);
		}


		// 중앙값을 찾기 위해 미리 정렬
		Collections.sort(list);
		
		int max = Collections.max(list);
		int min = Collections.min(list);
		
		// 둘다 음수 일 경우
		if(max < 0 && min < 0) {
			min = Math.abs(min);
		}
		// 둘다 양수 일 경우
		else if(max > 0 && min > 0) {
			min = min*-1;
		}
		// min, max서로 부호가 다를 때, 둘중에 하나라도 0일 때
		else {
			max = Math.abs(max);
			min = Math.abs(min);
		}
		
		double dle = sum / loop;
		int Average = (int) Math.round(dle);
		int Median = list.get(loop/2);
		int Mode = 0;
		int Range = max + min;
			
		for(int num : list) {
			// 숫자가 한번 나올 때마다 1이 추가됨.
			hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
		}
		
		int numbers = 0;
		for(int key : hashmap.values()) {
			numbers = Math.max(numbers, key);
		}
		
		// 위에서 사용했던 list를 다시 사용하기 위해 clear 처리
		// 최빈수를 구하기 최빈수와 같은 빈도의 수를 list에 삽입
		list.clear();
		for(int key : hashmap.keySet()) {
			if(hashmap.get(key) == numbers) {
				list.add(key);
			}
		}
		
		// 최빈수가 2개 이상일 경우 2번째로 작은 값을 뽑아내야 하기 때문에 list를 정렬
		Collections.sort(list);
		
		// 최빈수와 빈도수가 같은 수가 2개 이상인경우 index 1의 값을 최빈수로 설정
		// 1개일 경우는 그대로 index 0을 최빈수로 설정
		if(list.size() >= 2) {
			Mode = list.get(1);
		}
		else {
			Mode = list.get(0);
		}
		
		System.out.println(Average);
		System.out.println(Median);
		System.out.println(Mode);
		System.out.println(Range);
	}
}