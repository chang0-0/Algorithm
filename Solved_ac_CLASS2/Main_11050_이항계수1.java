import java.util.*;
import java.io.*;

public class Main_11050_이항계수1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11050.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int fact = 1;
		int comb = 1;
		
		// K가 0일경우 반복하지 않으므로 자동으로 1이 출력됨.
		for(int i=K; i>=1; i--) {
			fact = i * fact;
			comb = N * comb;
			N--;
		}
		
		System.out.println(comb / fact);
	}
}
