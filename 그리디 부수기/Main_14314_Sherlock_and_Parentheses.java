import java.util.*;
import java.io.*;

public class Main_14314_Sherlock_and_Parentheses {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/14314.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			sb.append("Case #").append(i+1).append(": ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			long result = Math.min(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			result = result * (result + 1) / 2;
			sb.append(result).append('\n');
		}		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class