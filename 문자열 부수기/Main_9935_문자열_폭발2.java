import java.io.*;

// https://www.acmicpc.net/problem/9935

// 1. 문자열이 폭발 문자열을 포함하고 있는 경우, 모든 폭발 문자열이 폭발하게 된다.
// 남은 문자열을 모두 이어붙여서 완전한 문자열을 만들어라
// 2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수 있다.
// 3. 폭발은 폭발 문자열이 없을 때 까지 계속된다.

public class Main_9935_문자열_폭발2 {	

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9935.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		
		int str_len = str.length;
		int bomb_len = bomb.length;
		
		char result[] = new char[str_len];
		int result_len = 0;
		
		for(char ch : str) {
			result[result_len ++] = ch;
			
			if(result_len >= bomb_len && ch == bomb[bomb_len - 1]) {
				boolean find = true;
				
				for(int j=1; j<bomb_len; j++) {
					if(str_len - 1 -j < 0 || bomb_len - 1- j < 0 
							|| result[result_len - 1 - j] != bomb[bomb_len - 1 - j]) {
						find = false;
						break;
					}
				}
				
				if(find) {
					result_len -= bomb_len;
				}
			}	
		}
		
		System.out.println(result.length == 0 ? "FRULA" : String.valueOf(result, 0 ,result_len));
	} // End of main
} // End of class