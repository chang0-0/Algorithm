import java.io.*;

// https://www.acmicpc.net/problem/1003
// 목표 : 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

public class Main_1003_피보나치_함수2 {
	static int zero, one, zero_plus_one;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			zero = 1;
			one = 0;
			zero_plus_one = 1;
			
			fibonacci(N);
			sb.append(zero + " " + one).append('\n');
		}

		System.out.println(sb);	
	} // End of main
	
	static void fibonacci (int num) {
		
		for(int i=0; i<num; i++) {
			zero = one;
			one = zero_plus_one;
			zero_plus_one = zero + one;
		}

	} // End of fibonacci
} // End of class
