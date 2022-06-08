import java.util.*;
import java.io.*;

public class Main_10828_스택 {
	static int[] stack;
	static int size = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;	
		
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		
		String str = " ";
		while( (str = br.readLine()) != null ) {
			
			st = new StringTokenizer(str);
			
			switch(st.nextToken()) {
				case "push" :
					push(Integer.parseInt(st.nextToken()));
					break;
				case "pop" :
					sb.append(pop()).append('\n');
					break;
				case "empty" :
					sb.append(empty()).append('\n');
					break;
				case "top" :
					sb.append(top()).append('\n');
					break;
				case "size" :
					sb.append(size()).append('\n');
					break;
			}
		}	
		System.out.println(sb);
	}

	private static int top() {
		if(size == 0) {
			return -1;
		}
		else {
			return stack[size - 1];
		}
	}

	private static int size() {
		return size;
	}

	private static int empty() {
		if(size == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}

	private static int pop() {
		if(size == 0) {
			return -1;
		}
		else {
			int res = stack[size - 1];
			stack[size - 1] = 0;
			size --;
			return res;
		}
	}

	private static void push(int num) {
		stack[size] = num;
		size ++;
	}

}
