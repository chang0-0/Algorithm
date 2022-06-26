import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2665
// 0 = 검은방 1 = 흰방
// 최소한의 검은 방을 흰방으로 바꾸어 도착지에 도달

public class Main_2665_미로만들기 {
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int arr[][];	
	static int dist[][];
	static int dirX[] = {0, 0, -1 ,1}; // 상 하 좌 우
	static int dirY[] = {-1, 1, 0, 0}; // 상 하 좌 우
	static int nowX = 0, nowY = 0;
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2665.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dist = new int[N][N];
		
		for(int i=0; i<N; i++) {
			char ch[] = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				arr[i][j] = Character.getNumericValue(ch[j]);
				dist[i][j] = INF;
			}
		}
		
		BFS(0, 0);
		System.out.println(dist[N-1][N-1]);
	} // End of main
	
	static void BFS(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y));
		dist[0][0] = 0;
		
		while( !que.isEmpty() ) {
			Node node = que.poll();
			
			for(int i=0; i<4; i++) {
				nowX = dirX[i] + node.x;
				nowY = dirY[i] + node.y;
				
				if(!rangeCheck()) continue;
				
				if(dist[nowX][nowY] > dist[node.x][node.y]) {
					if(arr[nowX][nowY] == 1) {
						dist[nowX][nowY] = dist[node.x][node.y];
					}
					else {
						dist[nowX][nowY] = dist[node.x][node.y] + 1;
					}
					que.offer(new Node(nowX, nowY));
				}
			}
		}
	} // End of BFS
	
	private static boolean rangeCheck() {
		return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
	} // End of rangeCheck
	
} // End of Main