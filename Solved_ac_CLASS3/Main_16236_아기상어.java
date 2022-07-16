import java.util.*;
import java.io.*;

public class Main_16236_아기상어 {
	static int N;
	static int startX; static int startY;
	static int sharkSize = 2;
	static int result = 0;
	
	static int dirX[] = {-1, 0, 0, 1}; // 상 하 좌 우  ( 상 -> 좌 -> 우 -> 하)
	static int dirY[] = {0, -1, 1, 0};
	static int arr[][];
	static int nowX, nowY;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dist;
		
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Main_16236_아기상어.Node o) {
			return dist - o.dist;
		}
	} // End of Node
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				
				if(num == 9) {
					startX = i; 
					startY = j;
				}
			}
		}
		
		// 처음에는 1부터 2까지를 무조건 찾는다.
		for(int i=1; i<=9; i++) {
			if(sharkSize < i) break;
			BFS(startX, startY, i);
		}
		
		System.out.println(result);
	} // End of main
	
	private static void BFS(int x, int y, int fishSize) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		boolean visit[][] = new boolean[N][N];
		que.offer(new Node(x, y, 0));
		visit[x][y] = true;
		
		while(!que.isEmpty()) {
			Node node = que.poll();

			for(int i=0; i<4; i++) {
				nowX = dirX[i] + node.x;
				nowY = dirY[i] + node.y;
				
				//System.out.println("(" + nowX + ", " + nowY + node.dist + ")");
				if(!range_check() || visit[nowX][nowY] ) continue;
				
				// 먹을 수 있는 크기보다 크거나 0 일 경우,
				if( arr[nowX][nowY] > fishSize || arr[nowX][nowY] == 0 ) {
					que.offer(new Node(nowX, nowY, node.dist+1));
					visit[nowX][nowY] = true;
				}
				else if(arr[nowX][nowY] <= fishSize) { // 먹이를 먹을 수 있을 때					
					if(i == sharkSize) sharkSize++;
					arr[nowX][nowY] = 0;
					visit[nowX][nowY] = true;
					
					result += node.dist + 1;
					startX = nowX;
					startY = nowY;
					
					que.offer(new Node(nowX, nowY, node.dist + 1));
				}
			}	
		}

	} // End of BFS

	private static boolean range_check() {
		return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
	} // End of range_check
} // End of Main class