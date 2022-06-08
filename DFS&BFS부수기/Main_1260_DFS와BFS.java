import java.util.*;
import java.io.*;

public class Main_1260_DFS와BFS {
	static int Edge_arr[][];
	static boolean Visited_arr[];
	static int N;
	static int M;
	static int V;
	static int count;
	
	static Queue<Integer> que = new LinkedList<>();
	
	public static void BFS(int start) {
		que.offer(start);	
		Visited_arr[start] = true;
		System.out.print(start + " ");
		
		while( !que.isEmpty() ) {
			start = que.poll();
			
			for(int i=1; i<=N; i++) {
				
				// 조건 : start에서 i로 연결되는 간선이 있으면서, i숫자의 노드가 방문한적이 없는경우(false)
				if(Edge_arr[start][i] == 1 && Visited_arr[i] == false) {
					
					// if문 조건에 걸리는 i값을 que에 삽입
					que.offer(i);
					// 방문 여부를 확인하는 Visited_arr을 true처리
					Visited_arr[i] = true;
					 System.out.print(i + " ");
				}
			}
		}	
	} // End BFS
	
	public static void DFS(int start) {
		// 시작점에서 가장 낮은 숫자를 기준으로 계속 찾아서 들어감
		Visited_arr[start] = true;
		System.out.print(start + " ");
		
		// 재귀를 위한 탐색을 조금이라도 줄이기 위해 만든 count
		if(count == N) {
			return;
		}
		count ++;

		for(int i=1; i<=N; i++) {
			if(Edge_arr[start][i] == 1 && Visited_arr[i] == false) {
				DFS(i);
			}
		}
	} // End DFS
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		V = Integer.parseInt(st.nextToken()); // 시작 노드
		
		//n개의 정점을 갖는 무방향 그래프에서 간선의 최대 수는 n(n-1)/2이다.
		Edge_arr = new int[1001][1001];
		Visited_arr = new boolean[1001];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 양방향(무방향) 그래프이기 때문에 x와 y값을 바꾼 값도 같이 1로 변환해줘야한다.
			Edge_arr[x][y] = Edge_arr[y][x] = 1;
		} // End for(i)
		
		DFS(V);
		System.out.println();
		
		Visited_arr = new boolean[1001];
		BFS(V);
			
	} // End Main
} // End Class
