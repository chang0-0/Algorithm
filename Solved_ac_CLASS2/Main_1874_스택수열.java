import java.io.*;
import java.util.*;

public class Main_1874_스택수열 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1874.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int length = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<Integer>();
		List<String> result = new ArrayList<>();
		
		int listCount = 0;
		int stackCount = 0;
		
		for(int i=1; i<=length; i++) {
			int temp = Integer.parseInt(br.readLine());
			list.add(temp);
			
		}
		
		for(;;) {				
			int listValue = list.get(listCount);
			
			// stack이 처음 생성되고 처음 값이 들어 왔을 때
			if(stack.empty() == true) {
				stackCount ++;
				stack.push(stackCount);
				result.add("+");
			}
			
			// stack.peek() == listValue가 같으면 반복함.
			int peek = stack.peek().intValue();
			
			if(peek == listValue) {
				stack.pop();
				result.add("-");
				listCount++;
			}
			else if(peek != listValue) {
				stackCount++;
				stack.push(stackCount);
				result.add("+");
			}
			
			if(stackCount == length) {
				while(stack.empty() == false) {
					stack.pop();
					result.add("-");
				}
				
				int size = result.size();
				int i = 0;
				for(; i<size; i++) {
					System.out.println(result.get(i));
				}
				
				stack.clear();
				break;
			}
		
		}//for End	
		
	} // Main End
}// Class End