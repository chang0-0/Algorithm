import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9375

public class Main_9375_패션왕신해빈 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_9375.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<String, Integer>();	
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			
			int N = Integer.parseInt(br.readLine());
			while(N-->0) {
				String[] type = br.readLine().split(" ");
				map.put(type[1], map.getOrDefault(type[1], 0)+1);
			}
			
			Iterator<Integer> it = map.values().iterator();
			
			int result = 1;
			while(it.hasNext()) {
				result *= it.next().intValue() + 1;
			}
			
			sb.append((result-1) + "\n");
			map.clear();
		}
		
		System.out.println(sb);
		
	} // End of main
} // End of class