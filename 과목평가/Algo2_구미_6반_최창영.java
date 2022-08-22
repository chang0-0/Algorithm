import java.util.*;
import java.io.*;

public class Algo2_구미_6반_최창영 {
	static int dirX[] = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
	static int dirY[] = { -1, 1, 0, 0, 1, 1, -1, -1 }; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
	static int N;
	static int[][] arr;
	static boolean[][] isVisited;
	static int sum;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/solution2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// + 최대값 먼저 구하기

			// DFS에서 델타값을 사용하여 방향 탐색
			int max1 = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					sum = arr[i][j];
					isVisited = new boolean[N][N];
					DFS(i, j, 1);

					isVisited = new boolean[N][N];
					DFS(i, j, 2);

					max1 = Math.max(sum, max1);
				}
			}

			// 대각선
			int max2 = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum = arr[i][j];
					isVisited = new boolean[N][N];
					DFS(i, j, 3);

					isVisited = new boolean[N][N];
					DFS(i, j, 4);
					max2 = Math.max(sum, max2);
				}
			}

			// 결과
			int result = Math.max(max1, max2);
			sb.append(result).append('\n');
		}

		bw.write(sb.toString());
		bw.close();

	} // End of main

	private static void DFS(int x, int y, int fun) {
		isVisited[x][y] = true;

		// 상 하
		if (fun == 1) {
			for (int i = 0; i < 2; i++) {
				int nowX = x + dirX[i];
				int nowY = y + dirY[i];

				if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY]) {
					sum += arr[nowX][nowY];
					DFS(nowX, nowY, fun);
				}
			}
		} else if (fun == 2) { // 좌 우
			for (int i = 2; i < 4; i++) {
				int nowX = x + dirX[i];
				int nowY = y + dirY[i];

				if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY]) {
					sum += arr[nowX][nowY];
					DFS(nowX, nowY, fun);
				}
			}
		} else if (fun == 3) { // 대각선
			for (int i = 4; i < 6; i++) {
				int nowX = x + dirX[i];
				int nowY = y + dirY[i];

				if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY]) {
					sum += arr[nowX][nowY];
					DFS(nowX, nowY, fun);
				}
			}
		} else if (fun == 4) { // 대각선
			for (int i = 6; i < 8; i++) {
				int nowX = x + dirX[i];
				int nowY = y + dirY[i];

				if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY]) {
					sum += arr[nowX][nowY];
					DFS(nowX, nowY, fun);
				}
			}
		}

	} // End of DFS

	// 범위 제한
	private static boolean rangeCheck(int nowX, int nowY) {
		return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
	} // End of rangeCheck
} // End of Algo1_구미_6반_최창영 class