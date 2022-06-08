import java.util.*;
import java.io.*;

// 문제 : https://www.acmicpc.net/problem/1261
// (0,0)에서 (N,M)으로 가기위해서는 최소 몇개의 벽을 부숴야 하나?

public class Main_1261_알고스팟 {
	static int arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1}; // 상 하 좌 우
	static int dirY[] = {-1, 1, 0, 0}; // 상 하 좌 우
	static int nowX, nowY, N, M;
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int wall;
		
		public Node(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall =wall;
		}

		@Override
		public int compareTo(Node o) {	
			return wall - o.wall;
		}
	} // End of Node class
	 
	public static void main(String[] args) throws Exception {	
		System.setIn(new FileInputStream("res/input_bj_1261.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로
		
		arr = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String temp = br.readLine();
			for(int j=1; j<=M; j++) {
				arr[i][j] = temp.charAt(j-1) - '0';
			}
		}
		
		int result = BFS(1, 1);
		System.out.println(result);		
	} // End of main
	
	static int BFS(int x, int y) {
		PriorityQueue<Node> pque = new PriorityQueue<>();
		pque.offer(new Node(x, y, 0));
		visit[x][y] = true;
		
		while( !pque.isEmpty() ) {
			Node node = pque.poll();
			
			if(node.x == N && node.y == M) {
				return node.wall;
			}
			
			for(int i=0; i<4; i++) {
				nowX = node.x + dirX[i];
				nowY = node.y + dirY[i];
				
				if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
					visit[nowX][nowY] = true;
					pque.offer(new Node(nowX, nowY, node.wall + 1));
				}
				else if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 0) {
					visit[nowX][nowY] = true;
					pque.offer(new Node(nowX, nowY, node.wall));
				}
			}
		}
		
		return 0;
	} // End of BFS;

	static boolean range_check() {
		return (nowX >= 1 && nowY >= 1 && nowX < N+1 && nowY < M+1);
	}
	
} // End of Main class