import java.util.*;
import java.io.*;

// 배열을 반시계 방향으로 회전
// N과 M중 작은수가 무조건 짝수가 됨.


public class Main_16929_배열돌리기2 {
	static int arr[][];
	static int dirX[] = {0, 0, -1, 1}; // 상 하 좌 우
	static int dirY[] = {-1, 1, 0, 0};
	static int N, M;
	static int nowX, nowY;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_16929.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// N * M의 회전은 회전을 하지 않은 결과와 같다.
		R = R % (N * M);
		// M의 절반값 까지회전.
		int loop = Math.min(N, M) / 2;

		// 전체 회전 반복
		while(R-->0) {
			rotation(loop);
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	} // End of main

	// 반시계방향 회전
	static void rotation(int loop) {
		
		for(int num[] : arr) {
			System.out.println(Arrays.toString(num));
		}
		
		
		for(int i=0; i<loop; i++) {
			int direction = 0;
			int x = i;
			int y = i;
			
			int temp = arr[x][y];
			while(direction < 4) {
				nowX = x + dirX[direction];
				nowY = y + dirY[direction];
				
				if(nowX < i && nowY < i && nowX >= N-i && nowY >= M-i) {
					arr[x][y] = arr[nowX][nowY];
					x = nowX;
					y = nowY;
				}
				else {
					direction++;
				}
			}
			
			arr[i+1][i] = temp;
		}
		
	} // End of rotation
	
	static boolean range_check(int i) {
		return (nowX >= N-i && nowX < i && nowY >= M-i && nowY < i);
	}
	
} // End of Main class