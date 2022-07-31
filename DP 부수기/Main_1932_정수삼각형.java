import java.util.*;
import java.io.*;

public class Main_1932_정수삼각형 {
	static int N;
	static int arr[][];
	static Integer memo[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1932.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		memo = new Integer[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) memo[N-1][i] = arr[N-1][i];
		
		System.out.print(DP(0, 0));
	} // End of main 
	
	private static int DP(int depth, int idx) {
		
		if(depth == N-1) return memo[depth][idx];
		
		if(memo[depth][idx] == null) {
			memo[depth][idx] = Math.max( DP(depth + 1, idx), DP(depth + 1, idx + 1)) + arr[depth][idx];      
		}
		
		return memo[depth][idx];
	} // End of DP
	
} // End of Main class