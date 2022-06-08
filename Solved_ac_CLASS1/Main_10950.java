import java.util.*;
import java.io.*;

public class Main_10950 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10950.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int loop = Integer.parseInt(br.readLine());
		
		for(int i=0; i<loop; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String num1 = st.nextToken();
			String num2 = st.nextToken();
			System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
		}
	}
}
