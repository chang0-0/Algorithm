import java.util.*;
import java.io.*;

// 서로 마주보는 숫자들을 곱한 뒤 모두 더할 때 최댓값을 구하라.
public class Main_1959_두개의숫자열 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1959.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(' ');
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			int arr2[] = new int[M];
	
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) arr2[j] = Integer.parseInt(st.nextToken());

			int result = Integer.MIN_VALUE;
			if(N<M) { // M이 클때, arr2 배열의 길이가 길 때,
				for(int i=0; i<M-N+1; i++) {
					int sum = 0;
					for(int j=0; j<N; j++) {
						sum += arr[j] * arr2[i+j];
					}
					result = Math.max(sum, result);
				}
			}
			else if(N>M) {
				for(int i=0; i<N-M+1; i++) {
					int sum = 0;
					for(int j=0; j<M; j++) {
						sum += arr[i+j] * arr2[j];
					}
					result = Math.max(sum, result);
				}
			}
			else{
				for(int i=0; i<N; i++) {
					result += arr[i] * arr2[i];
				}
			}
			
			sb.append(result).append('\n');
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class