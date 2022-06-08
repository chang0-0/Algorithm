import java.util.*;
import java.io.*;

public class Main_4153_직각삼각형 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_4153.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Long> list = new ArrayList<>();
		
		for(int i=0; i<3; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}
		
		Collections.sort(list);
		long A = (long) Math.pow(list.get(0), 2);
		long B = (long) Math.pow(list.get(1), 2);
		long C = (long) Math.pow(list.get(2), 2);
		
		while(A != 0 && B != 0 && C != 0) {

			if((A + B) == C) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
			
			list.clear();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<3; i++) {
				list.add(Long.parseLong(st.nextToken()));
			}	
			
			Collections.sort(list);
			
			A = (long) Math.pow(list.get(0), 2);
			B = (long) Math.pow(list.get(1), 2);
			C = (long) Math.pow(list.get(2), 2);
			
		}
	}
}
