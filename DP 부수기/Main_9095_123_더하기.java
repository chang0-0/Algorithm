import java.io.*;

// https://www.acmicpc.net/problem/9095

// 동적계획법 Memoization을 이용하기
// 반복되는 테스트케이스여도 낮은 값에서의 테스트 값은 변하지 않음.

public class Main_9095_123_더하기 {
	
	// 작은 문제부터 풀어가는 bottom-up방식
	// memoization 사용
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9095.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int memoization[] = new int[11];
		
		memoization[1] = 1;
		memoization[2] = 2;
		memoization[3] = 4;
		
		while(T--> 0) {
			int num = Integer.parseInt(br.readLine());
			
			for(int i=4; i<=num; i++) {
				
				if(memoization[i] == 0) {
					memoization[i] = memoization[i - 1] + memoization[i - 2] + memoization[i - 3];					
				}
				else {
					continue;
				}
				
			}
			sb.append(memoization[num]+"\n");
		}
		
		System.out.println(sb);
	} // End of main
} // End of class