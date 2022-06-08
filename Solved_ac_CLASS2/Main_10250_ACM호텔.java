import java.util.*;
import java.io.*;

public class Main_10250_ACM호텔 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10250.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int room_num = 1;
			
			// 2차원 배열 개념
			int arr[][] = new int[H][W];
			for(int j=0; j<H; j++) {
				room_num += (100*(j+1));
				
				for(int k=0; k<W; k++) {
					arr[j][k] = room_num++;
				}	
				room_num = 1;
			}
			
			int count = 0;
			for(int j=0; j<W; j++) {
				for(int k=0; k<H; k++) {
					count ++;
					//System.out.print("[" + arr[k][j] + "]");
					if(count == N) {
						System.out.println(arr[k][j]);
						break;
					}
				}
				
			}
		}			
	}
}
