
public class Main_PM_타겟넘버_1 {
	static int answer = 0;
	static int size;
	
	public int solution(int [] numbers, int target) {
		size = numbers.length;
		DFS(0, 0, numbers, target);
		return answer;	
	}
	
	public static void DFS(int n, int sum, int[] numbers, int target) {
		// 모든 배열의 숫자를 사용했을 경우를 계산하기 위해 n과 size가 갔을 때 검사를 함.
 		if(n == size) {
			if(sum == target) {
				answer ++;	
			}
			// 재귀 함수 종료 -> 이전 단계로 돌아감(변수값 하나씩 감소)
			return;
		}
		
		DFS(n + 1, sum + numbers[n], numbers, target);		
		DFS(n + 1, sum - numbers[n], numbers, target);
	}
	
	public static void main(String[] args) {
		Main_PM_타겟넘버_1 s = new Main_PM_타겟넘버_1();
		
		int numbers[] = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(s.solution(numbers, target));
	}

}
