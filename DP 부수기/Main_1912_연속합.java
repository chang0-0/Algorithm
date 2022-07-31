import java.util.*;
import java.io.*;

public class Main_1912_연속합 {
	static Integer memo[];
	static int arr[];
	static int max;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1912.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		memo = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		memo[0] = arr[0];
		max = arr[0];
		
		DP(N-1);

		System.out.println(max);
	} // End of main
	
	private static int DP(int N) {
		
		if(memo[N] == null) {
			memo[N] = Math.max(DP(N-1) + arr[N], arr[N]);
			
			max = Math.max(memo[N], max);
		}
		
		return memo[N];
	} // End of DP
	
} // End of Main class