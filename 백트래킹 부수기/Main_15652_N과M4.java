import java.util.*;
import java.io.*;

// 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
// 수열은 사전 순으로 증가하는 순서로 출력해야 한다.

public class Main_15652_N과M4 {
	static int N, M;
	static int arr[];
	static int ans[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15652.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = new int[M];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1; 
		}
		
		// 다른 백트래킹과 별개로 visit 배열이 없음
		DFS(0, 0);
		System.out.println(sb);
	} // End of main
	
	static void DFS(int index, int depth) {
		
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=index; i<N; i++) {
			ans[depth] = arr[i];
			
			// 핵심 : 중복을 받지 않기 위해서 for문에서 i를 index 매개변수 부터 시작하지만
			// index는 증가하지 않고, i부터 계속 시작함
			DFS(i, depth+1);
		}
	} // End of DFS
	
} // End of Main class