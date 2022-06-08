import java.io.*;
import java.util.*;

public class Main_팩토리얼 {
	
	public static int factorial(int n) {

		if(n > 0) {
			return n * factorial(n - 1);
		}
		else {
			return 1;
		}
		
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/inptut_factorial.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = factorial(N);
		
		System.out.println(result);

		
	}

}
