import java.util.*;
import java.io.*;

public class Main_15651_N과M3 {
	static int arr[];
	static int M, N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15651.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		DFS(0);
		System.out.println(sb);
	} // End of main
	
	private static void DFS(int depth) {
		
		// 재귀 탈출조건
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(' ');
			}
			
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) {
			arr[depth] = i;
			DFS(depth + 1);
		}
		
	} // End of DFDS
} // End of Main class