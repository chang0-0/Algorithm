import java.io.*;

// https://www.acmicpc.net/problem/11727
// 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

public class Main_11727_2xn타일링2{
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11727.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int memoization[] = new int[1001];
		memoization[1] = 1;
		memoization[2] = 3;
		memoization[3] = 5;
		
		for(int i=4; i<=N; i++) {
			memoization[i] = (memoization[i - 1] + 2 * memoization[i - 2]) % 10007;
		}
				
		System.out.println(memoization[N]);
	} // End of main
} // End of Main class