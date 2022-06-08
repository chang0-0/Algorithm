import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1780

// (1) -> 만약 종이가 모두 같은 수로 되어 있다면 그대로 사용한다.
// 모두 같은 수가 아닐 경우, 종이를 같은 크기의 종이 9개로 자르고, 
// 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.

// 목표 : 첫째 줄에 -1로만 채워진 종이의 개수를, 
// 둘째 줄에 0으로만 채워진 종이의 개수를,
// 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.

public class Main_1780_종이의개수 {
	static int arr[][];
	static int minus = 0;
	static int zero = 0; 
	static int one = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1780.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		
		sb.append(minus + "\n");
		sb.append(zero + "\n");
		sb.append(one + "\n");
		
		System.out.println(sb);
		
	} // End of main
	
	static void partition(int x, int y, int size) {
		
		// 전체 사이즈가 같은 색깔인지 체크
		if(check(x, y, size)) {
			if(arr[x][y] == -1) {
				minus ++;
			}
			else if (arr[x][y] == 0) {
				zero ++;
			}
			else {
				one ++;
			}
			
			return;
		}
		
		int newSize = size / 3;
		
		// 색종이 만들기와 다르게 3분할이 되므로 3/1지점, 3/2지점, 3/3지점으로 나눠야 함
		partition(x, y, newSize); 
		partition(x, y + newSize, newSize);
		partition(x, y + (2 * newSize), newSize);
		
		partition(x + newSize, y, newSize);
		partition(x + newSize, y + newSize, newSize);
		partition(x + newSize, y + (2 * newSize), newSize);
		
		partition(x + (2 * newSize), y, newSize);
		partition(x + (2 * newSize), y + newSize, newSize);
		partition(x + (2 * newSize), y + (2 * newSize), newSize);
		
	} // End of partition
	
	static boolean check(int x, int y, int size) {
		int color = arr[x][y];
		
		for(int i=x; i < x + size; i++) {
			for(int j=y; j < y + size; j++) {
				
				if(color != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	} // End of check
	
} // End of class