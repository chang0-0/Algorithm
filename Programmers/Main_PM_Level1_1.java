
public class Main_PM_Level1_1 {
	public static void main(String[] args) {
		Main_PM_Level1_1 s = new Main_PM_Level1_1();
		
		int a = 3;
		int b = 5;
		
		System.out.println(s.solution(a, b));

	} // End of main
	
    public long solution(int a, int b) {
    	long answer = 0;
    	
    	if(a == b) {
    		return a;
    	}
    	
    	int max = Math.max(a, b);
    	int min = Math.min(a, b);
    	
    	for(int i=min; i<=max; i++) {
    		answer += i;
    	}
    	
        return answer;
    }

} // End of Main class