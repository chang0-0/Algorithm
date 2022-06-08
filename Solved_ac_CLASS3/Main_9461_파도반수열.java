import java.io.*;

public class Main_9461_파도반수열 {
	static long memoization[] = new long[101];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9461.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		memoization[1] = 1;
		memoization[2] = 1;
		memoization[3] = 1;
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(DP(N)).append('\n');
		}
		
		System.out.println(sb);
	} // End of main
	
	static long DP(long depth) {
		// 가장 긴변을 찾아야 함
		// 만들려는 가장 긴 변은 memoization[depth-3] + memoization[depth-2]의 값이다.
		
		for(int i=4; i<=depth; i++) {
			if(memoization[i] == 0) {				
				memoization[i]= DP(i - 3) + DP(i - 2);
			}
		}

		return memoization[(int) depth];
	} // End of DP
} // End of Main class