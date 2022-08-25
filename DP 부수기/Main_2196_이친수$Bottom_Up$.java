import java.io.*;

public class Main_2196_이친수$Bottom_Up$ {
	static long memo[] = new long[91];
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2196.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;

		DP(N);
		System.out.println(memo[N]);
	} // End of main
	
	// Bottom-Up
	private static void DP(int N) { 
		for (int i = 3; i <= N; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
	} // End of DP
} // End of Main class