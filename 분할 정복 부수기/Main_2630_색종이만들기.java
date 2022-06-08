import java.io.*;
import java.util.*;

// N = 8 -> 4 -> 2 -> 1

public class Main_2630_색종이만들기 {
	static int arr[][];
	static int white = 0, blue = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2630.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, N);
		
		sb.append(white+"\n");
		sb.append(blue+"\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	} // End of main
	
	static void partition(int x, int y, int size) {
		
		if(check(x, y, size)) {
			if(arr[x][y] == 0) {
				white++;
			}
			else {
				blue++;
			}
			
			return;
		}
		
		int newSize = size / 2;
		
		partition(x, y, newSize); // 2 사분면
		partition(x, y + newSize, newSize); // 1 사분면
		partition(x + newSize, y, newSize); // 3 사분면
		partition(x + newSize, y + newSize, newSize); // 4 사분면
		
	} // End of solution
	
	static boolean check(int x, int y, int size) {
		
		int color = arr[x][y];
		
		for(int i=x; i < x + size; i++) {
			for(int j=y; j < y + size; j++) {
				if(arr[i][j] != color) {
					// 색깔이 다르면 곧 바로 false를 return
					return false;
				}
			}
		}
		
		return true;
	} // End of check
	
} // End of class