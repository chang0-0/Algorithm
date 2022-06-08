import java.io.*;
import java.util.*;

public class Main_2609_최대공약수와_최소공배수 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2609.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2  = Integer.parseInt(st.nextToken());
		
		int min = Math.min(num1, num2);
		int common_divisor;
		
		// 최대 공약수
		for(common_divisor = min; common_divisor>=1; common_divisor--) {
			if(num1 % common_divisor == 0 && num2 % common_divisor == 0) {
				System.out.println(common_divisor);
				break;
			}
		}
				
		int i=2;
		int common_multiple = num1;
		
		// 최소 공배수
		for(;;) {			
			if(common_multiple % num2 == 0) {
				System.out.println(common_multiple);
				break;
			}
			
			common_multiple = num1 * i;
			i++;
		}

	}
}
