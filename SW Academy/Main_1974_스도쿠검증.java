import java.util.*;
import java.io.*;
	
// 완전한 스도쿠 일 경우 -> 1, 아닐 경우 -> 0
public class Main_1974_스도쿠검증 {
	static StringBuilder sb = new StringBuilder();
	static int arr[][] = new int[9][9];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(' ');
			
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}	
			}
			
			// 가로체크
			boolean bol = true;
			for(int i=0; i<9; i++) {
				int sum = 0;
				for(int j=0; j<9; j++) {
					sum += arr[i][j];
				}
				if(sum != 45) bol = false;
			}
			if(bol == false) {
				sb.append(0).append('\n');
				continue;
			}
			
			// 세로체크
			for(int i=0; i<9; i++) {
				int sum = 0;
				for(int j=0; j<9; j++) {
					sum += arr[j][i];
				}
				if(sum != 45) bol = false;
			}
			if(bol == false) {
				sb.append(0).append('\n');
				continue;
			}
			
			
			for(int i=0; i<9; i+=3) {
				for(int j=0; j<9; j+=3) {
					int x = i;
					int y = j;
					int sum = 0;
					
					for(int k=x; k<x+3; k++) {
						for(int l=y; l<y+3; l++) {
							sum += arr[k][l];
						}
					}
					
					if(sum != 45) {
						bol = false;
						break;
					}
				}
			}
			
			if(!bol) sb.append(0).append('\n');
			else sb.append(1).append('\n');
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class