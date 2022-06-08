
import java.io.*;
import java.util.*;

public class Main_1000 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1000.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		StringTokenizer st = new StringTokenizer(T, " ");
		
		int sum = 0;
		for(int i=0; i<st.countTokens()+1; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
	
		System.out.println(sum);
		br.close();
	}
}

