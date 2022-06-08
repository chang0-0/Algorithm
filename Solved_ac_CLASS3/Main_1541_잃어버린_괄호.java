import java.io.*;
import java.util.*;

// 문제: https://www.acmicpc.net/problem/1541
// 예제1 : 55 - (50 + 40) = -35
// 예제2 : 30-70-20+40-10+100+30-35 -> 30-70-(20+40)-(10+100+30)-35 = -275

// 가장 앞에 부호가 -일 경우 부호 갯수 = 숫자 갯수
// 가장 앞에 부호가 없을 경우, 부호 갯수 < 숫자 갯수


public class Main_1541_잃어버린_괄호 {	

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1541.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		
		String formula = br.readLine();
		String zero = "+";
		
		// 처음 시작하는 부호가 -일 경우 (음수일 경우)
		if( !formula.startsWith("-")) {
			zero += formula;
			formula = zero;
		}

		
		int length = formula.length();
		boolean open = false;
		for(int i=0; i<length; i++) {
			char ch = formula.charAt(i);
			
			if(ch == '-' && open == false) {
				open = !open;
				list.add(ch + "(+");
			}
			// + 기호 인데, 괄호가 열려있음을 의미
			else if(ch == '+' && open == true) {
				list.add(String.valueOf(ch));
			}
			else if(ch == '-' && open == true) {
				list.add(")" + ch + "(+");
			}
			else {
				list.add(String.valueOf(ch));
			}
			
			// 마지막줄에 괄호가 열려있을 경우
			if( i == length-1 && open == true) {
				list.add(")");
			}
		}
		
		// 수정된 식을 다시 넣기 위해 formula 초기화.
		formula = "";
		for(String str : list) {
			formula += str;
		}
		
		
		StringTokenizer st = new StringTokenizer(formula, "-");
		int minus_sum = 0;
		int plus_sum = 0;
		
		while(st.hasMoreElements()) {
			String temp = st.nextToken();
			
			// 괄호는 음수에만 있고 +는 양수 음수 모두 해당하기 때문에, "("를 판별할 수 있는 if문을 먼저 넣어야함
			// 괄호와 +가 동시에 있을 때
			if( temp.contains("(")) {
				temp = temp.replace("(", "");
				temp = temp.replace(")", "");
				
				StringTokenizer plus_token = new StringTokenizer(temp, "+");
				while(plus_token.hasMoreElements()) {
					minus_sum -= Integer.parseInt(plus_token.nextToken());
				}
				
			}
			// +만 있을 때
			else if ( temp.contains("+")){

				StringTokenizer plus_token = new StringTokenizer(temp, "+");
				while(plus_token.hasMoreElements()) {
					plus_sum += Integer.parseInt(plus_token.nextToken());
				}
			
			}
		}
		

		System.out.println(minus_sum + plus_sum);
		
	} // End of main
} // End of class