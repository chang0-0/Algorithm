import java.util.*;
import java.io.*;

public class Main_15656_N과M7 {
	static StringBuilder sb = new StringBuilder();
	static int N; static int M;
	static int arr[];
	static int ans[];	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/15656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		DFS(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // End of main

	static void DFS(int depth) {
		
		if(depth == M) {			
			for(int i=0; i<M; i++) {
				sb.append(ans[i]).append(' ');
			}
			
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			ans[depth] = arr[i];
			DFS(depth + 1);
		}
	} // End of DFS
} // End of Main class