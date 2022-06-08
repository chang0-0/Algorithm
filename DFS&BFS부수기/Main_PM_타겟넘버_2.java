
public class Main_PM_타겟넘버_2 {
	static int numbers[];
	static int target;
	static int answer;
	static int length;
	
    public int solution(int[] numbers, int target) {
    	this.numbers = numbers;
    	this.target = target;
    	length = numbers.length;
    	
    	DFS(0, 0);
    	
        return answer;
    }
    
    static void DFS(int index, int sum) {
    	System.out.println("DFS(" + index + ", " + sum + ")");
    	
    	// 탈출 조건
    	if(index == length) {
    		if(sum == target) {
    			answer++; 
        		System.out.println("증가 =>DFS(" + index + ", " + sum + ")");
    		}
    		return;
    	}
    	
    	// 수행 동작
    	DFS(index + 1, sum + numbers[index]);
    	DFS(index + 1, sum - numbers[index]);  
    }
	
	public static void main(String[] args) {
		Main_PM_타겟넘버_2 s = new Main_PM_타겟넘버_2();
		
		int[] numbers = {1, 1, 1};
		int target = 1;
		
		System.out.println(s.solution(numbers, target));
	}
}
