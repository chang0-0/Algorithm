import java.util.*;

// 목표 : 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
// 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.

public class Main_PM_입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        
        // n명 기준으로 times의 시간으로 가장 마지막까지 가는 경우
    	long max = (long) times[times.length-1]*n;
    	long mid = 0;
    	long answer = max;
    	
    	while(min <= max) {
    		int sum = 0;
    		mid = (min + max) / 2;

    		for(int time : times) {
    			// 한명의 심사관이 mid라는 시간동안 심사한 사람의 수
    			// 각 심사관의 시간을 전체 반복해서 심사한 사람들의 수의
    			// 전체 합은 모든 심사원들이 mid라는 시간동안 심사한 사람의 수가 됨.
    			sum += mid / time;
    		}
    		
    		// mid라는 시간동안 심사한 사람의 수가 n과 같거나 클 경우.
    		// 최소 조건. mid라는 값으로 n보다는 심사할 수 있는 인원이 커야됨.
    		if(sum >= n) {
    			answer = mid;
				max = mid - 1;
    		}
    		else {
    			min = mid + 1;
    		}

    	}
        
        return answer;
    } // End of solution
	
	public static void main(String[] args) {
		Main_PM_입국심사 s = new Main_PM_입국심사();
		
		int n = 6;
		int times[] = {7,10};
		
		System.out.println(s.solution(n, times));
	}
} // End of clas
