import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14888
// 
// N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.

public class Main_14888_연산자끼워넣기 {
	static int arr[];
	static int operators[];
	
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_14888.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 수의 개수
		arr = new int[N];
		Arrays.sort(arr); // 배열 정렬
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		operators = new int[4];
		for(int i=0; i<4; i++) {
			operators[i] = Integer.parseInt(st.nextToken()); // 연산자 개수 배열에 추가		
		}
		

		DFS(arr[0], 1);
		
		sb.append(max).append('\n').append(min).append('\n');
		System.out.println(sb);
	} // End of main
	
	// 재귀 탈출 조건, 백트래킹 탈출.
	static void DFS(int num, int idx) {
		
		if(idx == N) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		
		for(int i=0; i<4; i++) {
			// 연산자가 있으면 꺼내고, 없으면 꺼내지 않는다.
			if(operators[i] > 0) {
				operators[i]--;
				
				switch(i) {
					case 0: DFS(num + arr[idx], idx + 1); 
					break;
					case 1: DFS(num - arr[idx], idx + 1); 
					break;
					case 2: DFS(num * arr[idx], idx + 1); 
					break;
					case 3: DFS(num / arr[idx], idx + 1); 
					break;
				}
				
				operators[i]++;
			}
		}
	
	} // End of DFS
	
} // End of Main class