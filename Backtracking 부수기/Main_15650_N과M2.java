import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15650
// 이전 문제 백준 15549의 N과 M(1)과 차이점은 중복이 없다는 점이다.
// 이전에는 2 4, 4 2는 다른 값이었지만,
// 이번에는 2 4, 4 2는 같은 값이 되어 중복되는 값을 모두 없앤다.

public class Main_15650_N과M2 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		 
		arr = new int[M];
		
		DFS(1, 0);
		System.out.println(sb);
	} // End of main
	
	static void DFS(int at, int depth) {
		
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=at; i<=N; i++) {
			arr[depth] = i;
			DFS(i + 1, depth + 1);
		}
		
		return;
	} // End of DFS
	
} // End of class

/*
 * 실행 과정
 * 
 * 재귀 실행 => DFS(1, 0)
arr[0] : [1, 0]
재귀 실행 => DFS(2, 1)
arr[1] : [1, 2]
재귀 실행 => DFS(3, 2)
sb 돌음 
재귀 탈출 => DFS(2, 1)
arr[1] : [1, 3]
재귀 실행 => DFS(4, 2)
sb 돌음 
재귀 탈출 => DFS(3, 1)

================
재귀 탈출 => DFS(1, 0)
arr[0] : [2, 3]
재귀 실행 => DFS(3, 1)
arr[1] : [2, 3]
재귀 실행 => DFS(4, 2)
sb 돌음 
재귀 탈출 => DFS(3, 1)

================
재귀 탈출 => DFS(2, 0)
arr[0] : [3, 3]
재귀 실행 => DFS(4, 1)

================
재귀 탈출 => DFS(3, 0)

================
1 2 
1 3 
2 3 
 *  */
