import java.io.*;

// https://www.acmicpc.net/problem/1003
// 목표 : 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

public class Main_1003_피보나치_함수 {
	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 0과 1은 미리 설정
		dp[0][0] = 1; // N이 0일 때, 0 호출 횟수
		dp[0][1] = 0; // N이 0일 때 1 호출 횟수 (불가능)
		dp[1][0] = 0; // N이 1일 때 0 호출 횟수 (불가능)
		dp[1][1] = 1; // N이 1일 때, 1호출 횟수
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
		}

		System.out.println(sb);	
	} // End of main
	
	static Integer[] fibonacci (int num) {
		if(dp[num][0] == null || dp[num][1] == null) {
			dp[num][0] = fibonacci(num - 1)[0] + fibonacci(num - 2)[0];
			dp[num][1] = fibonacci(num - 1)[1] + fibonacci(num - 2)[1];
		}
		
		return dp[num];
		
	} // End of fibonacci
} // End of class
