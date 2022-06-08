import java.util.*;

public class Main_PM_Level1_2 {
	public static void main(String[] args) {
		Main_PM_Level1_2 s = new Main_PM_Level1_2();
		
		int numbers[] = {2, 1, 3, 4, 1};
		System.out.println(Arrays.toString(s.solution(numbers)));
	} // End of main
	
    public int[] solution(int[] numbers) {
    	List<Integer> list = new ArrayList<>();
    	
    	int len = numbers.length;
    	for(int i=0; i<len; i++) {
    		int value1 = numbers[i];
    		
    		for(int j=i+1; j<len; j++) {
    			int value2 = numbers[j];
    			int sum = value1 + value2;
    			
    			if(list.contains(sum)) {
    				continue;
    			}
    			
    			list.add(sum);
    		}
    	}
    	
    	Collections.sort(list);
    	
    	int[] answer = new int[list.size()];
    	for(int i=0; i<list.size(); i++) {
    		answer[i] = list.get(i);
    	}
    	
        return answer;
    }

} // End of Main class