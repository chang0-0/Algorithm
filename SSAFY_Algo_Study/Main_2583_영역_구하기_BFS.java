import java.util.*;
import java.io.*;

public class Main_2583_영역_구하기_BFS {
	static int arr[][];
	static boolean visit[][];
	static List<Integer> resultList = new ArrayList<>();
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {1, -1, 0, 0};
	
	static int N, M;
	static int nowX, nowY;
	static int areaCount = 0;
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // End of Node class
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2583.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=x1; i<x2; i++) {
				for(int j=y1; j<y2; j++) {
					arr[i][j] = 1;
				}
			}			
 		}
		

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visit[i][j] && arr[i][j] == 0) {
					areaCount = 1;
					BFS(i, j);
					resultList.add(areaCount);
				}
			}
		}
		
		Collections.sort(resultList);
		sb.append(resultList.size()).append('\n');
		for(int num : resultList) {
			sb.append(num).append(' ');
		}
		
		bw.write(sb.toString()); bw.close();
	} // End of main
	
	private static void BFS(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		visit[x][y] = true;
		que.offer(new Node(x,y));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i=0; i<4; i++) {
				nowX = dirX[i] + node.x;
				nowY = dirY[i] + node.y;

				if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 0) {
					que.offer(new Node(nowX, nowY));
					visit[nowX][nowY] = true;
					areaCount++;
				}
			}
		}
	} // End of BFS
	
	private static boolean range_check() {
		return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M;
	} // End of range_check
} // End of Main class