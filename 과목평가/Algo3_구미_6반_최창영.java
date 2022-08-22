import java.util.*;
import java.io.*;

public class Algo3_구미_6반_최창영 {
	static int dirX[] = { 0, 0, -1, 1 };
	static int dirY[] = { 1, -1, 0, 0 };
	static int arr[][];
	static int N;
	static int min;

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // End of Node class

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/solution3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			min = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 출발지를 만나면 -> 2를 만나면 출발
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 2) {
						BFS(i, j);
					}
				}
			}

	
			sb.append(min).append('\n');
		}

		bw.write(sb.toString());
		bw.close();
	} // End of main

	// 최솟값탐색 = BFS
	private static void BFS(int x, int y) {
		Queue<Node> que = new LinkedList<Node>();
		boolean isVisited[][] = new boolean[N][N];
		isVisited[x][y] = true;
		que.offer(new Node(x, y));

		while (!que.isEmpty()) {
			Node node = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nowX = dirX[i] + node.x;
				int nowY = dirY[i] + node.y;
				
				if(rangeCheck(nowX, nowY) && arr[nowX][nowY] == 3) {
					min = min + 1;
					return;
				}

				if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && (arr[nowX][nowY] == 0)) {
					min = min + 1;
					
					isVisited[nowX][nowY] = true;
					que.offer(new Node(nowX, nowY));
				}
			}
		}

	} // End of BFS;

	private static boolean rangeCheck(int nowX, int nowY) {
		return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
	} // End of rangeCheck
} // End of Algo1_구미_6반_최창영 class