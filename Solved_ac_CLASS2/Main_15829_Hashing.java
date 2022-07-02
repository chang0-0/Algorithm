import java.io.*;

public class Main_15829_Hashing {
	private static final int M = 1234567891;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15829.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char ch[] = br.readLine().toCharArray();
		
		long result = 0;
		long pow = 1;
		for(int i=0; i<L; i++) {
			result += (ch[i] - 'a'+1) * pow % M;
			pow = pow * 31 % M;
		}
		System.out.println( result % M );
	} // End of main
} // End of Main class