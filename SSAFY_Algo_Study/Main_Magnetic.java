import java.util.*;
import java.io.*;

public class Main_Magnetic {	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		int t = 1;
		while( (str = br.readLine()) != null ) {
			sb.append('#').append(t).append(' ');
			int N = Integer.parseInt(str);
			int table[][] = new int[N][N];
			
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for(int i=0; i<N; i++) {
				int magnetN = 0;
				for(int j=0; j<N; j++) {
					if(table[j][i] == 2 && magnetN == 1) {
						result++;
						magnetN = 0;
					}	
					else if(table[j][i] == 1) {
						magnetN = 1;
					}
				}
			}
			
			t++;
			sb.append(result).append('\n');
		}
		
		bw.write(sb.toString()); bw.close();
	} // End of main
} // End of Main_Magnetic 