import java.util.*;
import java.io.*;

public class Main_11047_동전0 {
	static List<Integer> money_list = new ArrayList<>();
	static int N, K;
	static int count = 0;
 	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value <= K) {
				money_list.add(value);
			}
		}
			
		greedy();	
		
		System.out.println(count);
	} // End of main
	
	static void greedy() {

		int size = money_list.size();
		
		for(int i = size-1; i>=0; i--) {
			int won = money_list.get(i);
			int div = K / won;
			
			count += div;
			K -= div * won;
		}
		
	} // End of greedy
	
} // End of class
