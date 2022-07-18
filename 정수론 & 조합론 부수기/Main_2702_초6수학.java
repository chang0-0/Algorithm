import java.util.*;
import java.io.*;

public class Main_2702_초6수학 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2702.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = Math.max(N, M);
			int min = Math.min(N, M);
			
			int GCD = euclidean(max, min);
			int LCM = max*min / GCD;
			sb.append(LCM).append(' ').append(GCD).append('\n');
		}
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
	
	private static int euclidean(int N, int M) {
		int r = N % M;
		if(r == 0) return M;
		else return euclidean(M, r);
	} // End of euclidean
} // End of Main class