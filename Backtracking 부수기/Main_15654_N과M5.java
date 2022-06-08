import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15654
// 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
// 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
// 수열은 사전 순으로 증가하는 순서로 출력해야 한다.

public class Main_15654_N과M5 {
	static int N, M;
	static int arr[];
	static boolean visit[];
	static int temp[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15654.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new boolean[N];
		temp = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		DFS(0);
		System.out.println(sb);

	} // End of main
	
	static void DFS(int depth) {
		
		if(depth == M) {
            for (int val : temp) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
		}
		
		for(int i=0; i<N; i++) {
			
			if( visit[i] ) continue;
			
			visit[i] = true;
			temp[depth] = arr[i];
			DFS(depth + 1);
			visit[i] = false;
		}
		
	} // End of DFS
	
} // End of Main class