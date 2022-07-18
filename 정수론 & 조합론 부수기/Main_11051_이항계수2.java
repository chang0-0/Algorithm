import java.util.*;
import java.io.*;

public class Main_11051_이항계수2 {
	private static final int mod = 10007;
	static int memo[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/11051.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		memo = new int[N+1][N+1];
		DP(N);
		System.out.print(memo[N][K]);
	} // End of main
	
	private static void DP(int N) {
		for(int i=0; i<=N; i++) {
			memo[i][0] = 1;
			for(int j=1; j<=i; j++) memo[i][j] = (memo[i-1][j-1] + memo[i-1][j]) % mod;
		}
	} // End of DP
} // End of Main class