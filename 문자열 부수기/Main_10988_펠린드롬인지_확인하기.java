import java.io.*;

// https://www.acmicpc.net/problem/10988
// 목표 : 첫째 줄에 팰린드롬이면 1, 아니면 0을 출력한다.

public class Main_10988_펠린드롬인지_확인하기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10988.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		// 펠린드롬 검사기 만들기
		palindrome(str);
		
	} // End of main
	
	static void palindrome(String str) {	
		int length = str.length();
		
		for(int i=0; i<length/2; i++)	{
			char front = str.charAt(i);
			char back = str.charAt( (length-1)-i );
			
			if( front != back ) {
				System.out.println(0);
				return;
			}
		}
	
		System.out.println(1);
		
	} // End of palindrome
	
} // End of class 
