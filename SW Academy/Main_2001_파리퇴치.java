import java.util.*;
import java.io.*;

// M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다.
public class Main_2001_파리퇴치 {
	static int N, M;
	static int arr[][];
	static int dir[][] = new int[2][2];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(' ');
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 출발점을 지정해주기
			int result = 0;
			int max = -1;
			for(int i=0; i<N-(M-1); i++) {
				for(int j=0; j<N-(M-1); j++) {
					dir[0][0] = i;
					dir[0][1] = j;
					
					dir[1][0] = i+(M-1);
					dir[1][1] = j+(M-1);
					result = find_max();
					max = Math.max(result, max);
				}
			}
			
			sb.append(max).append('\n');
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
	
	private static int find_max() {
		int sum = 0;
		int x = dir[0][0];
		int y = dir[0][1];
		
		int x2 = dir[1][0];
		int y2 = dir[1][1];
		
		for(int i=x; i<=x2 ; i++) {
			for(int j=y; j<=y2; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	} // End of find_max
	
} // End of Main class