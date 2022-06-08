import java.util.*;
import java.io.*;

// 문제 FizzBuzz
// 조건:
// 만약 3과 5의 최소공배수이면 FizzBuzz
// 만약 3의 공배수일 경우, Fizz
// 만약 5의 공배수일 경우, Buzz
// 만약 아무것도 해당되지 않을 경우 i를 출력


class Result {
	public static void fizzBuzz(int n) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			
			if(i % (3 * 5) == 0) {
				sb.append("FizzBuzz\n");
			}
			else if(i % 3 == 0) {
				sb.append("Fizz\n");
			}
			else if(i % 5 == 0) {
				sb.append("Buzz\n");
			}
			else {
				sb.append(i+"\n");
			}
			
		}
		
		System.out.println(sb);
		
	} // End of fizzBuzz
	
} // End of Resul

public class Main_FizzBuzz {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_fizzBuzz.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
                
        Result.fizzBuzz(n);

        bufferedReader.close();
	} // End of main
	
} // End of class