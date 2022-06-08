import java.util.*;
import java.io.*;

public class Main_4963_섬의개수_BFS {
	static int arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1 ,1, -1, 1, -1, 1}; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
	static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1}; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
	
	static int w, h, nowX, nowY, island_count;
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_4963.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = " ";
		while( !(str = br.readLine()).equals("0 0") ) {
			st = new StringTokenizer(str);
			
			
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			arr = new int[h][w];
			visit = new boolean[h][w];

			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}

			island_count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					
					if(!visit[i][j] && arr[i][j] == 1) {
						BFS(i, j);
						island_count++;
					}
				}
			} 
			
			sb.append(island_count).append('\n');
		}
		
		System.out.println(sb);
	} // End of main
	
	static void BFS(int x, int y) {
		Queue<Node> que = new LinkedList<Node>();
		visit[x][y] = true;
		que.offer(new Node(x, y));
		
		while( !que.isEmpty() ) {
			Node node = que.poll();
			
			for(int i=0; i<8; i++) {
				nowX = dirX[i] + node.x;
				nowY = dirY[i] + node.y;
				
				if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
					visit[nowX][nowY] = true;
					que.offer(new Node(nowX, nowY));
				}
			}
		}
	
	} // End of BFS;
	
	static boolean range_check() {
		return (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w);
	} // End of range_check
	
} // End of Main class