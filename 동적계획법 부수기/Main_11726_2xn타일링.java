import java.io.*;

// https://www.acmicpc.net/problem/11726
// 목표 : 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

// 2xn 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수를 구하라

public class Main_11726_2xn타일링 {
	static int memoization[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11726.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2는 세로 고정, n은 가로
		int n = Integer.parseInt(br.readLine());
		memoization = new int[1001];
		
		memoization[1] = 1;
		memoization[2] = 2;
		memoization[3] = 3;
		memoization[4] = 5;
		
		dp(n);
		
		System.out.println(memoization[n]);
	} // End of main
	
	static void dp(int num) {
		
		for(int i=4; i<=num; i++) {
			if(memoization[i] == 0) {
				
				// memoization 배열에 10007의 나머지 값을 저장해줘야 함
				memoization[i] = (memoization[i - 1] + memoization[i - 2]) % 10007;				
			}
		}
		
	} // End of result
} // End of class