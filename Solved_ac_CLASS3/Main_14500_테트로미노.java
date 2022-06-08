import java.util.*;
import java.io.*;

public class Main_14500_테트로미노 {
	static int arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static int tet[][][] = { 
			{{0, 0}, {1, -1}, {1, 0}, {1,1}},
			{{0, 0}, {-1, -1}, {0, -1}, {1, -1}},
			{{0, 0}, {-1, 1}, {0, 1}, {1, 1}},
			{{0, 0}, {-1, -1}, {-1, 0}, {-1, 1}}};
	
	static int N, M;
	static int nowX, nowY;
	static int result = Integer.MIN_VALUE / 4;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14500.txt"));
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

		// 백트래킹 탐색
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				visit[i][j] = true;
				DFS(i, j, 0, 0);
				visit[i][j]	 = false;
				
				check_other(i, j);
			}
		}
		
		System.out.println(result);
	} // End of main
	
	static void DFS(int x, int y, int depth, int sum) {

		//재귀 탈출 조건
		if(depth == 4) {
			//최대값 갱신
			result = Math.max(result, sum);
			return;
		}
		
		sum += arr[x][y];

		for(int i=0; i<4; i++) {
			nowX = x + dirX[i];
			nowY = y + dirY[i];


			if( range_check() && !visit[nowX][nowY] ) {
				visit[nowX][nowY] = true;
				DFS(nowX, nowY, depth + 1, sum);
				visit[nowX][nowY] = false;				
			}
			
					
		}
		
	} // End of DFS
	
	static void check_other(int x, int y) {
		
		for(int i=0; i<4; i++) {
			int temp[][] = tet[i];
			int score = 0;
			
			for(int j=0; j<4; j++) {
				int nowX = x + temp[j][0];
				int nowY = y + temp[j][1];
				
				if( range_check()) break;
				
				score += arr[nowX][nowY];
			}
			
			result = Math.max(result, score);
		}
		
	} // End of check_other
	
	private static boolean range_check() {
		return ( nowX >= 0 && nowX < N && nowY >= 0 && nowY < N );
	} // End of range_check
} // End of Main class