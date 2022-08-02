import java.util.*;
import java.io.*;

public class Main_해수면 {
	static int arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1}; // 상 하 좌 우
	static int dirY[] = {1, -1, 0, 0};
	
	static int N;
	static int nowX, nowY;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/해수면.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append('#').append(t).append(' ');
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					arr[i][j] = temp;
				}
			}

			int maxArea = 0;
			for(int h=0; h<=101; h++) {
				visit = new boolean[N][N];
				int area = 0;
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(arr[i][j] > h && !visit[i][j]) {
							DFS(i, j, h);
							area++;
						}
					}
				}
				
				maxArea = Math.max(maxArea, area);
			}
			
			sb.append(maxArea).append('\n');
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
	
	private static void DFS(int x, int y, int height) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			nowX = dirX[i] + x;
			nowY = dirY[i] + y;
			
			if(range_check() && arr[nowX][nowY] > height && !visit[nowX][nowY]) {
				DFS(nowX, nowY, height);
			}
		}		
	} // End of DFS
	
	private static boolean range_check() {
		return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
	} // End of range_check
} // End of Main class