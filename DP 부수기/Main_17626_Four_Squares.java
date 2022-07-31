import java.io.*;

public class Main_17626_Four_Squares {
	static int memo[];
	static int N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/17626.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memo = new int[N+1];

		memo[1] = 1;
		
		DP();
		System.out.print(memo[N]);
	} // End of main
	
	static void DP() {
		for(int i=2; i<=N; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j * j <= i; j++) min = Math.min(min, memo[i - j * j]);
			memo[i] = min + 1;
		}
	} // End of DP
} // End of Main