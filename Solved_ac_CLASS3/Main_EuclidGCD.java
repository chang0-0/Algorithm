import java.util.*;
import java.io.*;

public class Main_EuclidGCD {
	public static int GCD(int x, int y) {
		
		if(y == 0) {
			return x;
		}
		else {
			return GCD(y, x % y);
		}

	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_EuclidGCD.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());

		int result = GCD(x, y);
		System.out.println(result);
		
	}
}
