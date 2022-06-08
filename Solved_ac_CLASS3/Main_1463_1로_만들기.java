import java.io.*;

// https://www.acmicpc.net/problem/1463
// 목표 : 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

// 예외케이스 6을 생각해야됨
// 6 -> 6/3 = 2 -> 2 - 1 -> 1
// 6 -> 6/2 = 3 -> 3 / 3 -> 1

public class Main_1463_1로_만들기 {
	static Integer memo[]; //메모이제이션 배열
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1463.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		memo = new Integer[X + 1];
		memo[0] = memo[1] = 0;
		
		int result = DP(X);
	
		System.out.println(result);
	} // End of main
	
	static int DP(int N) {
		
		// 메모이제이션의 배열을 DP 재귀함수를 통해 값을 변경하고
		// Math.min을 통해서 최소값으로 갱신
		
		// Integer형 배열을 통한 null값 비교
		if(memo[N] == null) {
			// 6으로 나눠지는 경우
			if(N % 6 == 0) {
				memo[N] = Math.min(DP(N - 1), Math.min(DP(N / 3), DP(N / 2))) + 1;
			}
			else if (N % 3 == 0) {
				memo[N] = Math.min(DP(N / 3), DP(N - 1)) + 1;
			}
			else if(N % 2 == 0) {
				memo[N] = Math.min(DP(N / 2), DP(N - 1)) + 1;
			}
			else {
				memo[N] = DP(N -1) + 1;
			}
		}
		
		return memo[N];
	} // End of DP

} // End of class
