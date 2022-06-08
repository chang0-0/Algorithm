import java.util.*;
import java.io.*;

// 부분수열에서 합이 S가 되는 부분수열의 개수를 출력

public class Main_1182_부분수열의합 {
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
		
		// 자리수를 지정하는 배열
		for(int i=1; i<=N; i++) {		
			// M으로 만들기 위해서 수열들의 합을
			// 한개 숫자로 M을 만들 수 있는 경우를 체크
			// 2개의 값으로 M을 만들 수 있는지 체크
			// 이렇게 자리 수를 하나씩 늘려가면서 수열에서 만들 수 있는 숫자들의 모든 조합을 확인
			// numbers는 수열에서 선택할 숫자들의 갯수를 의미.
			numbers = new int[i];

			backtracking(i, 0, 0);
		}
		
		System.out.println(answer);
	} // End of main
	
	private static void backtracking(int numbers_length, int now_Number_length, int index) {
		
		// 재귀 탈출조건
		// 숫자 조합으로 만들 총 자리수와 현재 만들어진 자리수가 같을 경우, 검사 후 탈출
		if(now_Number_length == numbers_length) {
			
			int sum = 0;
			for(int num : numbers) {
				sum += num;
			}
			
			if(M == sum) {
				answer++;
			}
			return;
		}
			
		for(int i = index; i < N; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				numbers[now_Number_length] = arr[i];
				backtracking(numbers_length, now_Number_length + 1, i + 1);
				visit[i] = false;
			}
		}
		
	} // End of backtracking
} // End of Main class