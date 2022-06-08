import java.util.*;
import java.io.*;

public class Main_10974_모든순열 {
	static int N;
	static int fac;
	static int arr[];
	static int ans[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = new int[N];
		visit = new boolean[N];
		fac = 1;
		for(int i=N; i>=1; i--) {
			fac = fac*i;
		}
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}

		DFS(0);
		System.out.println(sb);
		
	} // End of main

	static void DFS(int depth) {
		
		if(depth == N) {
			
			for(int i=0; i<N; i++) {
				sb.append(ans[i]).append(' ');
			}
			
			sb.append('\n');
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			if(visit[i]) continue;
			
			visit[i] = true;
			ans[depth] = arr[i];
			DFS(depth + 1);
			visit[i] = false;
		}
		
		
		
	} // End of DFS
	
} // End of Main class