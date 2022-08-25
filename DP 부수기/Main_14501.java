import java.util.*;
import java.io.*;

public class Main_14501 {
	static int[] memo;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/14501.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());	
		}
		
		
		
		
		
	} // End of main
} // End of Main class