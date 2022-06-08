import java.util.*;
import java.io.*;

public class Main_2178_미로탐색_DFS {
	static int dirY[] = {-1, 1, 0, 0};
	static int dirX[] = {0, 0, -1, 1};
	static int maze[][];
	static boolean visit[][];
	
	static List<Integer> list = new ArrayList<>();
	static int N;
	static int M;
	static int now_x;
	static int now_y;
	static int count = 1;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_bj_2178.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		maze = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<M; j++) {
				char ch = str.charAt(j);
				maze[i][j] = Character.getNumericValue(ch);
			}
		}
		
		DFS(0, 0);
		System.out.println(list);
	} // End of Main
	
	public static void DFS(int x, int y) {
		visit[y][x] = true;
		
		for(int i=0; i<4; i++) {
			now_x = x + dirX[i]; 
			now_y = y + dirY[i];
			
			if(Range_check() == true && visit[now_y][now_x] == false && maze[now_y][now_x] == 1) {           				
				count++;
				// 가장 먼저 도달되는 값을 list에 삽입
				
				if(now_x == M-1 && now_y == N-1) {
					list.add(count);
				}
				DFS(now_x, now_y);
			
			} // 다시 뒤로 돌아오는 경우

		} // End of Range_check for()
	} // End of DFS
	
	public static boolean Range_check() {
		return (now_x >= 0 && now_x < M && now_y >= 0 && now_y < N);
	} // End of Range_check	
}
