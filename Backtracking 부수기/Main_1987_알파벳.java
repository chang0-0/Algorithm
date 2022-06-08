import java.util.*;
import java.io.*;

public class Main_1987_알파벳 {
	static int dirX[] = {0, 0, -1, 1}; // 상 하 좌 우
	static int dirY[] = {-1, 1, 0, 0};
	static char arr[][]; 
	static boolean alp[] = new boolean[26];
	
	static int nowX, nowY;
	static int R, C;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1987.txt"));	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String temp = br.readLine();
			
			for(int j=0; j<C; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		
		DFS(0, 0, 0);
		System.out.println(result);
	} // End of main
	
	private static void DFS( int x, int y, int count) {
		
		if(alp[arr[x][y]-65]) {
			result = Math.max(result, count);
			return;
		}
		else {
			alp[arr[x][y]-65] = true;
			
			for(int i=0; i<4; i++) {
				nowX = dirX[i] + x;
				nowY = dirY[i] + y;
				
				if( range_check() ) {
					DFS(nowX, nowY, count + 1);
				}
			}
			
			alp[arr[x][y] - 65] = false;
		}
		
	} // End of DFS
	
	private static boolean range_check() {
		return (nowX >= 0 && nowX < R && nowY >= 0 && nowY < C);
	} // End of range_check
	
} // End of Main class