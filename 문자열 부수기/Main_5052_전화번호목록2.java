import java.io.*;
import java.util.Arrays;

public class Main_5052_전화번호목록2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_5052.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			String number_list[] = new String[N];
			
			for(int i=0; i<N; i++) {
				number_list[i] = br.readLine();
			}
			
			Arrays.sort(number_list);
						
			// true = 접두어가 없다 = 일관성이 있다.
			if(solution(N, number_list)) {
				sb.append("YES\n");
			}
			// false = 접두어가 있다. = 일관성이 없다.
			else {
				sb.append("NO\n");
			}
			
		}
		
		System.out.println(sb);
	} // End of main
	
	// 접두어 판단
	static boolean solution(int N, String[] number_list) {
		
		for(int i=0; i<N-1; i++) {
			if(number_list[i + 1].startsWith(number_list[i])) {
				
				// 접두어가 있다 = 일관성이 없다 = false;
				return false;
			}
		}
		
		// 접두어가 없다 = 일관성이 있다 = true
		return true;
		
	} // End of solution
} // End of class