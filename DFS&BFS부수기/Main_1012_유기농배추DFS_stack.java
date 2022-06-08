import java.util.*;
import java.io.*;

public class Main_1012_유기농배추DFS_stack {
	// 스택 구현
	static Stack<Node> stack = new Stack<>();	
	static int map[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	
	static int count = 1;
	static int N, M;
	static int nowX, nowY;
	
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
		while(T--> 0) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			int K = Integer.parseInt(st.nextToken());
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					
					if(visit[i][j] == false && map[i][j] == 1) {
						count ++;			
						DFS(j, i);
					}
				}
			}
			sb.append(count).append('\n');
		} 
		
		System.out.println(sb);
	} // End of main
	
	static void DFS(int x, int y) {
		stack.add(new Node(x, y));
		visit[y][x] = true;
		
		while( !stack.isEmpty() ) {
			Node node = stack.pop();
			
			for(int i=0; i<4; i++) {
				nowX = node.x + dirX[i];
				nowY = node.y + dirY[i];
				
				if( Range_check() && visit[nowY][nowX] == false && map[nowY][nowX] == 1) {
					stack.push(new Node(nowX, nowY));
					visit[nowY][nowX] = true;
				}
			}	
		}
	}
	
	static boolean Range_check() {
		return (nowX < M && nowY < N && nowX >= 0 && nowY >= 0);
	}
	
}
