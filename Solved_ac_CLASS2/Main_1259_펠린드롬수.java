import java.io.*;
import java.util.*;

public class Main_1259_펠린드롬수 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1259.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> linkedList = new LinkedList<>();
		LinkedList<Character> linkedList2 = new LinkedList<>();
		
		// 0 일때까지 반복
		int num;
		while((num = Integer.parseInt(br.readLine())) != 0) {
			String temp = Integer.toString(num);
			
			for(int i=0; i<temp.length(); i++) {
				linkedList.add(temp.charAt(i));
			}
			
			for(int j=temp.length()-1; j>=0; j--) {
				linkedList2.add(temp.charAt(j));
			}
						
			for(char ch : linkedList) {
				char ch2 = linkedList2.poll();
				
				if(ch != ch2) {
					System.out.println("no");
					break;
				}
				else if(linkedList2.isEmpty()) {
					System.out.println("yes");
				}
			}
			
			linkedList.clear();
			linkedList2.clear();
		}

		br.close();
	}
}