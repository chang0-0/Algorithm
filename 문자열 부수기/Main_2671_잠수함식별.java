import java.io.*;
import java.util.regex.Pattern;

public class Main_2671_잠수함식별 {
	private static final Pattern P = Pattern.compile("(100+1+|01)+");


	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2671.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		System.out.println(P.matcher(br.readLine()).matches() ? "SUBMARINE" : "NOISE");
		
	} // End of main
} // End of class