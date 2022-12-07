import java.util.*;
import java.io.*;

public class Main_4485_녹색옷입은애가젤다지 {
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static boolean visit[][];
	static int map[][];
	static int size[][];
	 
	private static final int INF = Integer.MAX_VALUE / 4; // 오버플로우 방지
	static int N, nowX, nowY;
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int size;
		
		// (alt + shift + s) + o
		public Node(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Node o) {
			return size - o.size;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_4485.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		int count = 1;
		
		String temp = "";
		while( !(temp = br.readLine()).isEmpty()  ) {
			N = Integer.parseInt(temp);
			if(N == 0) {
				break;
			}
			
			map = new int[N][N];
			visit = new boolean[N][N];
			size = new int[N][N];
	
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
						
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	
					size[i][j] = INF;
				}
			}
			
			BFS(0, 0, map[0][0]);
			sb.append("Problem " + count + ": " + size[N-1][N-1]).append('\n');
			count++;
		}
		
		System.out.println(sb);
		
	} // End of main
	
	private static void BFS(int x, int y, int roopy) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		visit[x][y] = true;
		que.offer(new Node(x, y, roopy));
		
		
		while( !que.isEmpty() ) {
			
			Node node = que.poll();
			
			for(int i=0; i<4; i++) {
				nowX = node.x + dirX[i];
				nowY = node.y + dirY[i];
				
				if( range_check() && !visit[nowX][nowY] && size[nowX][nowY] > (map[nowX][nowY] + node.size) ) {
					size[nowX][nowY] = map[nowX][nowY] + node.size;
					visit[nowX][nowY] = true;
					que.offer( new Node( nowX, nowY, size[nowX][nowY] ));
				}
				
			}
		}
		
	} // End of BFS
	
	private static boolean range_check() {
		return (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N);
	} // End of range_check

} // End of main