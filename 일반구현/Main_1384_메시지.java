import java.util.*;
import java.io.*;

public class Main_1384_메시지 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1384.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(br.readLine());
		int group = 1;
		while( N != 0 ) {
			sb.append("Group").append(' ').append(group).append('\n');
			String arr[][] = new String[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = st.nextToken();
				}
			}
			
			int num = 0;
			boolean bol = true;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j].equals("N")) {
						num = i - j;
						if(num < 0) num += N; 
						
						sb.append(arr[num][0]).append(" was nasty about ").append(arr[i][0]).append('\n');
						bol = false;
					}
				}
			}
			if(bol == true) sb.append("Nobody was nasty").append('\n');

			group ++;
			sb.append('\n');
			N = Integer.parseInt(br.readLine());
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class