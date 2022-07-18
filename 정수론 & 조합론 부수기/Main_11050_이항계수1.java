import java.util.*;
import java.io.*;

public class Main_11050_이항계수1 {
	static int memo[][] = new int[11][11];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/11050.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		DP(N);
		System.out.print(memo[N][K]);
	} // End of main
	
	private static void DP(int N) {
		for(int i=0; i<=N; i++) {
			memo[i][0] = 1;
			for(int j=1; j<=i; j++) memo[i][j] = (memo[i-1][j-1] + memo[i-1][j]);
		}
	} // End of DP
} // End of Main class