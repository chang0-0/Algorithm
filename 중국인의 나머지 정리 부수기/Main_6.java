import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/6064
public class Main_6064_카잉달력 {
	// M, N은 달력의 마지막 최고 값.
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/6064.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 10 12의 나머지가 3 9가 되는 값.
			// 1. 식의 설계
			int n = M * N;
			int N1 = n/M;
			int N2 = n/N;
			System.out.println("N1 : " + N1);
			System.out.println("N2 : " + N2);
				
			// 2. 선형 합동식 특수해
			int x1 = find_mod(N1, M);
			int x2 = find_mod(N2, N);
			System.out.println("x1 : " + x1);
			System.out.println("x2 : " + x2);
			
			// 3. 연립합동식의 해
			int alpha = (x*N1*x1) + (y*N2*x2);

			int result = alpha % n;
			System.out.println(result);
		}
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
	
	private static int find_mod(int num1, int num2) {
		System.out.println("num1 : " + num1 + ", num2 : " + num2);
		for(int i=1; i<100; i++) {
			if((num1*i) % num2 == 1) {
				return i;
			}
		}
		
		return 0;
	} // End of find_mod
} // End of Main class