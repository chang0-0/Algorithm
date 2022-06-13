import java.util.*;
import java.io.*;

public class Main_10925 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/10925.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String temp = "";
		while( (temp = br.readLine()) != null ) {
			st = new StringTokenizer(temp);
			int num1 =  Integer.parseInt(st.nextToken());
			int num2 =  Integer.parseInt(st.nextToken());
			
			if(num1 == 0) break;
			sb.append(num1 + num2).append('\n');
		}
				
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // End of main
} // End of Main