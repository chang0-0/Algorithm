import java.io.*;
import java.util.*;

// 문제 : https://www.acmicpc.net/problem/1927

// x가 자연수라면, 배열에 x를 넣으라는 추가하는 연산이고,
// x가 0이라면, 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거하는 경우이다.

// 우선순위 큐 -> 작은 숫자가 높은 우선순위를 가짐.

public class Main_1927_최소힙 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1927.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				
				if(que.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					int value = que.poll();
					sb.append(value + "\n");
				}
				
			}
			else {
				que.offer(x);
			}
		}
		
		System.out.println(sb);
		
	} // End of main
} // End of Main class