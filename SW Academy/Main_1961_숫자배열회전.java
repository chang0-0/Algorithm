import java.util.*;
import java.io.*;

public class Main_1961_숫자배열회전 {
	static StringBuilder sb = new StringBuilder();
	static int arr[][];
	static int temp[][];
	static String ans[][];
	static int N;
	static int ansCount = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append('\n');
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			temp = new int[N][N];
			ans = new String[N][3];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());
					temp[i][j] = arr[i][j] = num;
				}
			}
			
			ansCount = 0;
			for(int i=1; i<=3; i++) {
				rotation(i); // 90도 단위로 회전, 90, 180, 270 총 3번 회전
				makeAns();
				ansCount++;
			}
			
			build();
			
		} // End of for(t)
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main

	private static void rotation(int count) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) arr[j][(N-1)-i] = temp[i][j];
		}
		
		if(count==3) return;
		copy();
	} // End of rotation
	
	private static void copy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) temp[i][j] = arr[i][j];
		}
	} // End of copy
	
	private static void makeAns() {
		for(int i=0; i<N; i++) {
			StringBuilder temp = new StringBuilder();
			for(int j=0; j<N; j++) temp.append(Integer.toString(arr[i][j]));
			ans[i][ansCount] = temp.toString();
		}
	} // End of makeAns
	
	private static void build() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) sb.append(ans[i][j]).append(' ');
			sb.append('\n');
		}
	} // End of build
	
} // End of Main class