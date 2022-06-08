import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10845

public class Main_10845_큐 {
	static LinkedList<Integer> que = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10845.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String function = "";
		int num = 0;
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			
			if(st.countTokens() > 1) {
				function = st.nextToken();
				num = Integer.parseInt(st.nextToken());
				que.offer(num);
			}
			else {
				function = st.nextToken();
				
				if(function.startsWith("f")) {
					front();
				}
				else if(function.startsWith("b")) {
					back();
				}
				else if(function.startsWith("s")) {
					sb.append(que.size()+"\n");
				}
				else if(function.startsWith("e")) {
					empty();
				}
				else if(function.startsWith("p")) {
					pop();
				}
			}
		}
		
		System.out.println(sb);
	}
	
	static void pop() {
		if(que.isEmpty()) {
			sb.append(-1+"\n");
		}
		else {
			sb.append(que.poll()+"\n");
		}
	}
	
	static void empty() {
		if(que.isEmpty()) {
			sb.append(1+"\n");
		}
		else {
			sb.append(0+"\n");
		}
	}
	
	static void front() {
		if(que.isEmpty()) {
			sb.append(-1+"\n");
		}
		else {
			sb.append(que.peekFirst()+"\n");
		}
	}
	
	static void back() {
		if(que.isEmpty()) {
			sb.append(-1+"\n");
		}
		else {
			sb.append(que.peekLast()+"\n");
		}
	}

}