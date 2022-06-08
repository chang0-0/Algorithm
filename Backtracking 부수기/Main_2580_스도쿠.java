import java.util.*;
import java.io.*;

public class Main_2580_스도쿠 {
	static int N = 9;
	static int arr[][] = new int[N][N];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2580.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sdoku(0, 0);
	} // End of main
	
	static void sdoku(int x, int y) {
		// 열이 9일경우 다음 줄로 넘어가기위해 행을 1증가시킴.
		if(y == 9) {
			sdoku(x + 1, 0);
			return;
		}
		
		// 행이 9에 도달해서 마지막 줄 까지 왔을 때, 종료
		if(x == 9) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
			
		// 스도쿠배열에서 빈칸인 0을 만났을 때,
		if(arr[x][y] == 0) {
			for(int i=1; i<=N; i++) {
				
				// 1~9까지 모든 숫자를 value로 넣어서
				// 행에서 겹치는 숫자가 있는지, 열에서 겹치는 숫자인지,
				// 3*3작은 배열에서 겹치는 숫자인지
				// 3가지 경우를 check를 함
				if(check(x, y, i)) {
					arr[x][y] = i;
					sdoku(x, y + 1);
				}
			}
			
			arr[x][y] = 0;
			return;
		}
		
		sdoku(x, y + 1);
	} // End of DFS
	
	static boolean check(int x, int y, int value) {
		
		// 열에 value가 있으면, false를 반환
		for(int i=0; i<N; i++) {
			if(arr[x][i] == value) {
				return false;
			}
  		}
		
		// 행도 검사를 해서 행에 value가 있으면 false를 반환
		for(int i=0; i<N; i++) {
			if(arr[i][y] == value) {
				return false;
			}
		}
		
		// x,y를 기준으로 있는 3*3배열에서 겹치는 값이 있는지 체크
		int setX = (x/3) * 3;
		int setY = (y/3) * 3;
		
		// 3*3배열로 잘라서 탐색.
		for(int i=setX; i<setX + 3; i++) {
			for(int j=setY; j<setY + 3; j++) {
				if(arr[i][j] == value) {
					return false;
				}
			}
		}
		
		// 모든 조건을 통과하면 true를 반환
		return true;
	} // End of check

} // End of Main class