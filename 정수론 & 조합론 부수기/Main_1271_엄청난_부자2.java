import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main_1271_엄청난_부자2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1271.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		BigInteger bigNumber1 = new BigInteger(str1);
		BigInteger bigNumber2 = new BigInteger(str2);
		
		System.out.println( bigNumber1.divide(bigNumber2) );
		System.out.println( bigNumber1.remainder(bigNumber2));
	} // End of main
} // End of Main class