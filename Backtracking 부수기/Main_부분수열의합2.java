import java.util.*;
import java.io.*;

public class Main_부분수열의합2 {
	static int N, M, sum, answer = 0;
	static int arr[];
	static boolean visit[];
	static int numbers[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1182.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			// 자리수에 해당되는 수열을 배열로 생성
			numbers = new int[i];
			
			
			System.out.println(i + "자리 수열");

			backtracking(i, 0, 0);
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
		}
		
		System.out.println(answer);
				
	} // End of main
	
	static void backtracking(int numbers_length, int now_length, int index) {
		System.out.println("**** backtracking(" + numbers_length + " ," + now_length + " ," +  + index + ") 실행됨 ****");
		
		// 탈출 조건
		if(numbers_length == now_length) {
			int sum = 0;
			
			for(int num : numbers) {
				sum += num;
			}
			
			System.out.println("(sum == M) : " + (sum == M) + "\n" + "\n");
			if(sum == M) {
				answer++;
			}
			
			return;
		}
		
		for(int i=index; i<N; i++) {
			
			// 방문한적이 없을 때,
			if(visit[i] == false) {
				visit[i] = true;
				
				numbers[now_length] = arr[i];

				System.out.println("실행 됨 backtracking(" + numbers_length + ", " + (now_length+1) + ", " + (i) + ") i 는" + i);
				backtracking(numbers_length, now_length + 1, i + 1);
				System.out.println("다시 backtracking(" + numbers_length + ", " + now_length + ", " + i +") 로 돌아옴 현재 i = " + i);                                    
				visit[i] = false;
				
			}
		}
		
	} // End of backtracking

} // End of main