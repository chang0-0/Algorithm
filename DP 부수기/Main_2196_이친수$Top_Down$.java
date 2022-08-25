import java.io.*;

public class Main_2196_이친수$Top_Down$ {
	static Long memo[] = new Long[91];
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2196.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		System.out.println(DP(N));
	} // End of main

	// Bottom-Up
	private static long DP(int N) {
	
		if (N == 1) {
			return 1;
		} else if (N == 2) {
			return 1;
		} else if (memo[N] == null) {
			memo[N] = DP(N - 1) + DP(N - 2);
		}

		return memo[N];
	} // End of DP
} // End of Main class