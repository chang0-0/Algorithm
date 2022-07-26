import java.util.*;
import java.io.*;

public class Main_17086_아기상어2 {
	static int arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1, -1, 1, 1, -1}; // 상 하 좌 우
	static int dirY[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	
	static int N, M;
	static int nowX, nowY;
	static int max = -1;
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/17086.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					BFS(i, j);
				}
			}
		}
		
	
		
		
		
	} // End of main
	
	private static void BFS(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		visit[x][y] = true;
		que.offer(new Node(x, y));
		
		
		while( !que.isEmpty() ) {
			Node node = que.poll();
			
			for(int i=0; i<8; i++) {
				nowX = dirX[i] + x;
				nowY = dirY[i] + y;
				
				System.out.println(nowX);
			}
			
		}
		
		
		
		
		
		
	} // End of BFS
	
	private static boolean range_check() {
		return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M;
 	} // End of range_check
} // End of Main class