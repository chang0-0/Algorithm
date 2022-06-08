import java.util.*;
import java.io.*;

public class Main_15663_N과M9 {
	static int N, M;
	static int arr[];
	static int ans[];
	static boolean visit[];
	static HashSet<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/15663.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = new int[M];
		visit = new boolean[N];
		
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
			StringBuilder temp = new StringBuilder();
			for(int i=0; i<M; i++) {
				temp.append(ans[i]).append(' ');
			}
			
			if(!set.contains(temp.toString())) {
				sb.append(temp).append('\n');
				set.add(temp.toString());
			}
			return;
		}
		
		for(int i=0; i<N; i++) {	
			if(visit[i]) continue;
			visit[i] = true;
			ans[depth] = arr[i];
			DFS(depth+1);
			visit[i] = false;
		}
		
	} // End of DFS
} // End of Main class