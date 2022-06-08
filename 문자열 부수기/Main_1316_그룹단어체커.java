import java.util.*;
import java.io.*;

public class Main_1316_그룹단어체커 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1316.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		int count = 0;
		
		while(N-->0) {
			String str = br.readLine();
			boolean bol = true;;
			
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
								
				if(stack.isEmpty()) {
					stack.push(ch);
				}
				else {
					char temp = stack.peek();
					
					// 스택에서 가장 앞에 있는, 문자와 들어오는 문자가 같을 경우 검사하지 않고 그대로 넘어감
					if(temp == ch) {
						continue;
					}
					// 스택에서 가장 위에 있는 문자와 들어오는 문자가 다를 경우, stack 내부에 같은 문자가 있는지 검사함
					else if(temp != ch){ 
						if(stack.contains(ch)) {
							bol = false;
							break;
						}
						
						stack.push(ch);						
					}
				}
				
				
			}
			
			if(bol == true) {
				count++;
			}
			
			stack.clear();
		}
		
		System.out.println(count);
	}
} // End of class