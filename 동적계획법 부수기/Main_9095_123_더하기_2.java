import java.io.*;

// 단순 재귀 함수를 사용해서 문제 풀이
// 참고 : https://www.acmicpc.net/source/34561257

// x,y의 좌표에 따라 공백 또는 재귀 호출을 반복해주어 더 이상 나눌 칸이 없을 때까지 반복하는 것이다.

public class Main_9095_123_더하기_2 {
	static int N;
	static int result;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9095.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			N = Integer.parseInt(br.readLine());
			
			result = 0;
			perm(0);
			
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	} // End of main
	
	private static void perm(int sum) {
		
		if(sum == N) {
			result ++;
			return;
		}
		
		for(int i=1; i<=3; i++) {
			int total = sum + i;
			
			if(total > N) {
				break;
			}
			else {				
				perm(total);
			}
			
		}
	}
} // End of class