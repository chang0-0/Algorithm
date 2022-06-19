import java.io.*;

public class Main_2739_구구단 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2739.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=9; i++) {
			sb.append(N).append(' ').append('*').append(' ').append(i).append(' ').append('=').append(' ').append(N*i).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // End of main
} // End of Main 