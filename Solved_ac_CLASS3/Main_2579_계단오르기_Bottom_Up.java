import java.io.*;

// https://www.acmicpc.net/problem/2579
// 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
// 2. 연속된 세 개의 계단을 모두 밟아서는 안된다.
// 3. 마지막 도착 계단은 반드시 밟아야 한다.

public class Main_2579_계단오르기_Bottom_Up {
	static int N;
	static int memo[];
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2579.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];
		arr = new int[N + 1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		memo[0] = arr[0];
		memo[1] = arr[1];
		
		if(N >= 2) {
			memo[2] = arr[1] + arr[2];
		}
		
		for(int i=3; i<=N; i++) {
			memo[i] = Math.max(memo[i-2], memo[i-3] + arr[i-1]) + arr[i];
		}
		
		System.out.print(memo[N]);
	} // End of main
} // End of Class