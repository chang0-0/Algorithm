
public class Solution2_배열사용 {
	public static void main(String[] args) {
		Solution2_배열사용 s = new Solution2_배열사용();

		int topping[] = { 1, 2, 1, 3, 1, 4, 1, 2 };
		System.out.println(s.solution(topping));
	} // End of main

	public int solution(int[] topping) {
		int len = topping.length;
		int result = 0;
		int cheolsuArr[] = new int[len+1];
		int brotherArr[] = new int[len+1];

		int cheolsuCount = 0;
		int brotherCount = 0;
		for (int i = 0; i < len; i++) {
			if(cheolsuArr[topping[i]] == 0) {
				cheolsuCount++;
			}
			cheolsuArr[topping[i]]++;
		}
	
		
		for(int i=0; i<len; i++) {
			if(brotherArr[topping[i]] == 0) {
				brotherCount++;
			}
			brotherArr[topping[i]]++;
			cheolsuArr[topping[i]]--;
			
			if(cheolsuArr[topping[i]] == 0) {
				cheolsuCount--;
			}
			if(cheolsuCount == brotherCount) result++;
		}
		
		return result;
	} // End of solution
} // End of Main class