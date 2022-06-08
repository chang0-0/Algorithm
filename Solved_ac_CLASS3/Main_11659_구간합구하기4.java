import java.util.*;
import java.io.*;

public class Main_11659_구간합구하기4 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11659.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		list.add(0, 0);
		for(int i=1; i<=N; i++) {
			list.add(list.get(i-1) + Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(list);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			sb.append(list.get(num2) - list.get(num-1)).append('\n');
		}
		
		System.out.println(sb);
	} // End of main
} // End of Main class