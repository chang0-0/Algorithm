import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9935

// 1. 문자열이 폭발 문자열을 포함하고 있는 경우, 모든 폭발 문자열이 폭발하게 된다.
// 남은 문자열을 모두 이어붙여서 완전한 문자열을 만들어라
// 2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수 있다.
// 3. 폭발은 폭발 문자열이 없을 때 까지 계속된다.

public class Main_9935_문자열_폭발 {	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9935.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String bomb = br.readLine();
		int str_len = str.length();
		int bomb_len = bomb.length();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str_len; i++) {
			int count = 0;
			stack.push(str.charAt(i));
			
			// 스택의 크기가 폭탄 문자열의 길이와 같아지면 탐색 시작
			if(stack.size() >= bomb_len) {
				
				for(int j=0; j<bomb_len; j++) {
					
					if(stack.get(stack.size() - bomb_len + j) == bomb.charAt(j)) {
						count++;
					}	
					
					if(count == bomb_len) {
						for(int k=0; k<bomb_len; k++) {
							stack.pop();
						}
					}
					
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			for(char ch : stack) {
				sb.append(ch);
			}
		}
		
		System.out.println(sb);
		
	} // End of main
} // End of class