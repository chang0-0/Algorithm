import java.io.*;

public class Main_Yes_or_Yes {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Yes_or_Yes.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String str = br.readLine().toLowerCase();
			if(str.equals("yes")) sb.append("YES").append('\n');
			else sb.append("NO").append('\n');
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class