import java.util.*;
import java.io.*;

public class Main_9012_괄호 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			int length = str.length();
			
			for(int j=0; j<length; j++) {
				char ch = str.charAt(j);
				
				if(ch == '(') {
					stack.push(ch);
				}
				else {
					int size = stack.size();
					if(size == 0) {
						stack.push(ch);
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			
			// 마지막에 스택이 비었으면 VPS
			if(stack.isEmpty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
			stack.clear();
		}
		
	}
}
