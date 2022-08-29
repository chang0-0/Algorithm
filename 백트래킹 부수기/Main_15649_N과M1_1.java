import java.util.*;
import java.io.*;

// https://www.acmicpc.net/step/34
// 백트래킹 문제.

public class Main_15649_N과M1_1 {
	static int N, M;
	
	static int arr[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15649.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		DFS(0);
		
		// 결과 출력
		System.out.println(sb);
	}
	
	static void DFS(int depth) {
		
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				DFS(depth + 1);
				visit[i] = false;
			}
		}	
		
	} // End of DFS
	
} // End of Main class