import java.io.*;

public class Main_1788_피보나치_수의_확장 {
	private static final int mod = 1000000000;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1788.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		//첫째줄에 n이 양수이면 1, 0이면 0, 음수이면 -1을 출력한다.
		if(N > 0) {
			System.out.println(1);
		}
		else if(N < 0) {
			N = Math.abs(N);
			if(N % 2 == 0) {
				System.out.println(-1);
			}
			else {
				System.out.println(1);
			}
		}
		else {
			System.out.println(0);
		}
		
		System.out.println(DP(N));
	} // End of main
	
	private static int DP(int N) {
		if(N<=1) return N;
		
		int memo[] = new int[N+1];
		memo[0] = 0;
		memo[1] = 1;
		for(int i=2; i<=N; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % mod;
		}
		
		return memo[N];
	} // End of DP
} // End of Main class