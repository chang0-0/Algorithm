import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main_2857_FBI {
	private static final Pattern P = Pattern.compile(".*FBI.*");
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2857.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();

		for(int i=1; i<=5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "-");
			
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
				
				if(P.matcher(token).matches()) {
					sb.append(i + " ");
				}
			}
		}
		
		if(sb.length() == 0) {
			System.out.println("HE GOT AWAY!");
		}
		else {
			System.out.println(sb);
		}
		
	} // End of main
} // End of class