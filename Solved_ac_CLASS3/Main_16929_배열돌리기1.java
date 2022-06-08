import java.util.*;
import java.io.*;

// 배열을 반시계 방향으로 회전
// N과 M중 작은수가 무조건 짝수가 됨.


public class Main_16929_배열돌리기1 {
	static int arr[][];
	static int temp[][];
	static int N, M;
	
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
		temp = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// M의 절반값 까지회전.
		int loop = Math.min(N, M) / 2;
		int node[][] = new int[loop][4];
		
		// 내부회전 좌표 생성
		for(int i=0; i<loop; i++) {
			node[i][0] = i; // x1 
			node[i][1]= i; // y1
			node[i][2] = (N-1)-i; // x2 
			node[i][3] = (M-1)-i; // y2
		}	
		
		// 전체 회전 반복
		while(R-->0) {
            copy();
			// 내부 회전 반복
			for(int i=0; i<loop; i++) {
				rotation(node[i][0], node[i][1], node[i][2], node[i][3]);
			}	
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	} // End of main
	
	static void copy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
	}
	
	static void rotation(int x1, int y1, int x2, int y2) {
		// 반시계 방향 회전
		
		// 상단 회전
		// temp(0, 3) -> arr(0, 2)
		// temp(0, 2) -> arr(0, 1)
		// temp(0, 1) -> arr(0, 0)
		for(int i=y2; i>y1; i--) {
			arr[x1][i-1] = temp[x1][i];
		}
		
		// 좌측 회전
		// temp(0,0) -> arr(1, 0)
		// temp(1,0) -> arr(2,0)
		// temp(2,0) -> arr(3,0)
		// temp(3,0) -> arr(4,0)
		for(int i=x1; i<x2; i++) {
			arr[i+1][y1] = temp[i][y1];
		}
		
		// 하단 회전
		// temp(4,0) -> arr(4,1)
		// temp(4,1) -> arr(4,2)
		// temp(4,2) -> arr(4,3)
		for(int i=y1; i<y2; i++) {
			arr[x2][i+1] = temp[x2][i];
		}
		
		// 우측 회전
		// temp(4,3) -> arr(3,3)
		// temp(3,3) -> arr(2,3)
		// temp(2,3) -> arr(1,3)
		// temp(1,3) -> arr(0,3)
		for(int i=x2; i>x1; i--) {
			arr[i-1][y2] = temp[i][y2];
		}
	
	} // End of rotation
	
} // End of Main class