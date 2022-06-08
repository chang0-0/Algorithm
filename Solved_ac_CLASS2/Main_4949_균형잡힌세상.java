import java.io.*;
import java.util.*;

public class Main_4949_균형잡힌세상 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_4949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Character> list = new ArrayList<>();
		int size = 0;
		
		for(;;) {			
			String str = br.readLine();
			int length = str.length();
			
			if(length == 1 && str.charAt(0) == '.') {
				break;
			}
						
			for(int i=0; i<length; i++) {
				char temp = str.charAt(i);
				
				if(temp == '(' || temp == '[') {
					list.add(temp);				
				}
				else if(temp == ')') {
					list.add(temp);	
					size = list.size();
					
					for(int j=size-1; j>=0; j--) {
						char get = list.get(j);
						
						if(get == '(') {
							list.remove(size-1);
							list.remove(j);
							break;
						}
						else if(get == '[') {
							break;
						}
						
					}
					
				}
				else if(temp == ']') {
					list.add(temp);	
					size = list.size();
					
					for(int j=size-1; j>=0; j--) {
						char get = list.get(j);
						
						if(get == '[' ) {
							list.remove(size-1);
							list.remove(j);
							break;
						}
						else if(get == '(') {
							break;
						}
						
					}
					
				}

			}
			
			if(list.isEmpty()) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
			
			
			list.clear();
		}
		
		

	}
}
