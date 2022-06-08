import java.util.*;
import java.io.*;

public class Main_1012_유기농배추_BFS {
	static Queue<Node> que = new LinkedList<>();
	static int map[][];
	static boolean visit[][];
	static int dirY[] = {-1, 1, 0, 0};
	static int dirX[] = {0, 0, -1, 1};
	
	static int N,M,K;
	static int now_x, now_y;
	static int count;
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visit = new boolean[N][M];
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			count = 0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					
					// 1인 영역만 탐색하여 값을 뽑아냄
					if(visit[j][k] == false && map[j][k] == 1) {
						count++;
						BFS(k, j);
					}
				}
			}
			
			sb.append(count).append('\n');
		}		
		
		System.out.println(sb);
	}
	
	static void BFS(int x, int y) {
		que.offer(new Node(x, y));
		visit[y][x] = true;

		while( !que.isEmpty() ) {
			Node node = que.poll();
			
			for(int i=0; i<4; i++) {
				now_x = node.x + dirX[i];
				now_y = node.y + dirY[i];
				
				if(Range_check() && visit[now_y][now_x] == false && map[now_y][now_x] == 1) {           
					que.offer(new Node(now_x, now_y));
					visit[now_y][now_x] = true;
				}
				
			}
		}
	}
	
	// 범위 체크
	public static boolean Range_check() {
		return (now_x >= 0 && now_x < M && now_y >= 0 && now_y < N);
	} // End of Range_check	
		
}
