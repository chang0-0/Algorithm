import java.util.*;
import java.io.*;

// 이항계수
public class Main_25345_루나의게임세팅 {
	private static final int mod = 1000000007;
	static int memo[][] = new int[2001][2001];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/25345.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		DP(N);
		
		for(int num[] : memo) {
			System.out.println(Arrays.toString(num));
		}
		
		
		int comb = memo[N][K];
		for(int i=1; i<K; i++) comb = comb * 2 % mod;
		System.out.print(comb);
	} // End of main
	
	private static void DP(int N) {
		for(int i=0; i<=N; i++) {
			memo[i][0] = 1;
			for(int j=1; j<=i; j++) {
				memo[i][j] = (memo[i-1][j-1] + memo[i-1][j]) % mod;
			}
		}
	} // End of DP
} // End of Main class