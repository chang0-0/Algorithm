import java.util.*;
import java.io.*;

/**
 * @see https://www.acmicpc.net/problem/1520
 * DP, DFS
 */

public class Main_1520_내리막길 {
	static int arr[][];
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static Integer memo[][];
	
	static int nowX = 0; static int nowY = 0;
	static int N, M;
	static int H = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1520.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		arr = new int[M][N];
		memo = new Integer[M][N]; // 아직 모른다 or 갈 수 없다 = null, 갈 수 있다 != null
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.print(DFS(0, 0)); // 출발은 (0, 0)
	} // End of main
	
	static int DFS(int x, int y) {
		
		if(x == M-1 && y == N-1) {
			return 1;
		}
		
		// null이 아닐 경우, 방문 했음을 의미함
		if(memo[x][y] != null) {
			return memo[x][y];
		}
		
		memo[x][y] = 0;
		for(int i=0; i<4; i++) {
			nowX = x + dirX[i];
			nowY = y + dirY[i];
			
			if(!range_check()) continue;
			
			if(arr[x][y] > arr[nowX][nowY]) {
				memo[x][y] += DFS(nowX, nowY);		
			}
		}
		
		return memo[x][y];
	} // End of DFS
	
	static boolean range_check() {
		return nowX < M && nowX >= 0 && nowY < N && nowY >= 0;
	} // End of range_check
} // End of Main class