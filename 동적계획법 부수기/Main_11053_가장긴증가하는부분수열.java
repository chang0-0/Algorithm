import java.util.*;
import java.io.*;

public class Main_11053_가장긴증가하는부분수열 {
	static Integer memo[];
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/11053.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine()); 
		memo = new Integer[A];
		arr = new int[A];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		for(int i=0; i<A; i++) {
			DP(i);
		}
		
		int max = memo[0];
		for(int i=1; i<A; i++) {
			max = Math.max(max,  memo[i]);
		}
		
		System.out.print(max);
	} // End of main

	private static int DP(int N) {

		if(memo[N] == null) {
			memo[N] = 1;
			
			for(int i=N-1; i>=0; i--) {
				// 현재의 값이 이전의 값 보다 클 경우,
				if(arr[i] < arr[N]) {
					// 이전의 값에 +1을 함
					memo[N] = Math.max(memo[N], DP(i)+1);					
				}
			}
		}
		
		return memo[N];
	} // End of DP
	
} // End of Main class