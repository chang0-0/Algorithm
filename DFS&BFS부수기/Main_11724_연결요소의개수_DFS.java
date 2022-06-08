import java.util.*;
import java.io.*;

public class Main_11724_연결요소의개수_DFS {
	static int arr[][];
	static boolean node[];
	static int N, count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11724.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		// 무방향 그래프
		// 노드의 개수만큼 배열 생성.
		arr = new int[N+1][N+1];
		node = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 무방향 그래프 특성.
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		count = 0;
		for(int i=1; i<=N; i++) {	
			
			// 연결되 있는 노드는 확인 할 필요 없음
			if(node[i] == false) {
				DFS(i);				
				count++;
			}
		}
		
		System.out.println(count);
	} // End of main
	
	static void DFS(int value) {
		
		if(node[value] == true) {
			return;
		}

		node[value] = true;
		for(int i=1; i<=N; i++) {
			if(arr[value][i] == 1) {
				DFS(i);
			}
		}
	}
	
} // End of class