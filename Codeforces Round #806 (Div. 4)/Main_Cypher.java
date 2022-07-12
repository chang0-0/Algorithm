import java.io.*;
import java.util.*;

public class Main_Cypher {
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Cypher.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());			
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char ch[] = st.nextToken().toCharArray();
				for(char temp : ch) {
					if(temp == 'D') up(i);
					else down(i);
				}				
			}
			for(int num : arr) sb.append(num).append(' ');
			sb.append('\n');
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
	
	private static void up(int num) {
		if(arr[num] == 9) arr[num] = 0;
		else arr[num]++;
	} // End of up
	
	private static void down(int num) {
		if(arr[num] == 0) arr[num] = 9;
		else arr[num]--;
	} // End of down
} // End of Main class