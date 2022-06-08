import java.util.*;
import java.io.*;

public class Main_1303_전쟁_전투_DFS {
	static int N; // 가로
	static int M; // 세로
	static int white_count = 0;
	static int black_count = 0;
	static int now_x;
	static int now_y;
	static int count;
	
	static int dirY[] = {-1, 1, 0, 0}; // 상 하 체크
	static int dirX[] = {0, 0, -1, 1}; // 좌 우 체크
	static char map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_bj_1303.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로 
		M = Integer.parseInt(st.nextToken()); // 세로
		
		// 1. 지도와 방문여부를 체크하는 배열 초기화 및 생성
		map = new char[M][N];
		visit = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch; 
			}
		}

		// 2. 2차원 배열 순환 -> DFS 탐색
		for(int i=0; i<M; i++) { // 세로
			for(int j=0; j<N; j++) { // 가로
				
				if(visit[i][j] == false) {
					char color = map[i][j];
					count = 0;
					DFS(j, i, color);
					
					if(color == 'W') {
						white_count += count * count;
					}
					else {
						black_count += count * count;
					}
				}
			}
		}
		
		System.out.println(white_count + " " + black_count);
	}
	
	static void DFS(int x, int y, char color) {
		visit[y][x] = true;
		
		// DFS 특성상 재귀함수를 고려해서 여기서 count를 합해줘서 누적값을 계산한다. 또한 초기화를 할 필요가 없다.
		// BFS의 경우 Queue가 비어있으면 BFS가 종료되기 때문에 count를 바깥에서 계산한다.
		// BFS가 끝나고 count를 계산하고 초기화 시켜준다.
		
		count += 1;

		for(int i=0; i<4; i++) {
			now_y = y + dirY[i];
			now_x = x + dirX[i];
			
			if(Range_check() == true && map[now_y][now_x]==color && visit[now_y][now_x] == false) {
				DFS(now_x, now_y, map[now_y][now_x]);
			}

		}
	}// End of DFS		
	
	static boolean Range_check() {
		return (now_x >= 0 && now_x < M && now_y >= 0 && now_y < N);
	}
	
}
