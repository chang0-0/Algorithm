import java.util.*;
import java.io.*;

public class Main_1012_유기농배추_DFS {
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static int map[][];
	static boolean visit[][];
	
	static int now_x, now_y;
	static int M, N, K;
	static int count = 1;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		// 테스트 케이스 전체 반복
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			// 배추가 있는 지도 생성
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			count = 0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[j][k] == 1 && visit[j][k] == false) {
						count++;
						DFS(k, j);
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
	} // End Main
	
	public static void DFS(int x, int y) {
		visit[y][x] = true;
		
		for(int i=0; i<4; i++) {
			now_x = x + dirX[i];
			now_y = y + dirY[i];
			
			if(Range_check() && visit[now_y][now_x] == false && map[now_y][now_x] == 1) {
				DFS(now_x, now_y);
			}
			// 범위에 들어오지만 0을 마주치거나, 방문한적이 있는 곳일 경우 하나의 재귀가 천천히 종료됨

		}
	}
	
	static boolean Range_check() {
		return (now_y < N && now_y >= 0 && now_x < M && now_x >= 0);
	}
	
}
