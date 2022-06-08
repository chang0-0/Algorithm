import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/5430
// 목표 : 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 
// 만약, 에러가 발생한 경우에는 error를 출력한다.

// 오류 발생시 참고 : https://www.acmicpc.net/board/view/25456

public class Main_5430_AC {
	static ArrayDeque<Integer> deque;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_5430.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트케이스의 개수
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			
			// 함수와 함수문자열의 길이 값
			String p = br.readLine();
			int number = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			deque = new ArrayDeque<Integer>();
			
			for(int i=0; i<number; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(p);
		}
		
		System.out.println(sb);
	} // End of main
	
	static void AC(String p) {
		// 기본값 정방향 출력 forward_direction = false;
		boolean forward_direction = true;
		
		for(char function : p.toCharArray()) {
			
			if(function == 'R') {
				forward_direction = !forward_direction;
				continue;
			}
			
			// 정방향일 때
			if( forward_direction ) {
				
				// 덱이 비었으면,
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			}
			// 역방향 일때 forward_direction = true
			else {
				
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}
		
		makePrintString(forward_direction);
	}

	private static void makePrintString(boolean forward_direction) {
			
		sb.append('[');
		
		if(deque.size() > 0) {
			if(forward_direction) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else {
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		
		sb.append(']').append('\n');
	} // End of makePrintString
	
} // End of class