import java.util.*;
import java.io.*;

public class Main_9663_N_Queen {
	static boolean visit[][];
	static int arr[][];
	static int N, result = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9663.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		DFS(0);
		
		System.out.println(result);
		
	} // End of main
	
	static void DFS(int x) {
		
		if(x == N) {
			result++;
			return;
		}
		
		for(int j=0; j<N; j++) {
			if( !visit[x][j] ) {
				visit[x][j] = true;
				arr[x][j] = 1;
				
				// 퀸의 공격방향 체크
				check(x, j);
				
				DFS(x + 1);
				
				arr[x][j] = 0;
				init_visit(); // 방문 초기화
			}
		}
		
		
	} // End of DFS
	
	// 공격 방향성 체크
	static void check(int x, int y) {
		
		// 수직 아래 방향
		for(int i=x; i<N; i++) {
			visit[i][y] = true; 
		}
		
		// 왼쪽 대각선 아래
		int tempX = x;
		int tempY = y;


		// 오른쪽 대각선 아래
		while((0 <= x && x < N & (0 <= y && y < N))) {
			visit[x++][y++] = true;
		}
	}
	
	static void init_visit() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visit[i][j] = false;
			}
		}
	}

} // End of Main class