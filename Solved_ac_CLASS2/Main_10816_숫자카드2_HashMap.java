import java.util.*;
import java.io.*;

public class Main_10816_숫자카드2_HashMap {
	// https://www.acmicpc.net/problem/10816

	static final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
	static final List<Integer> nlist = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10816.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nlist.add(num);
			
			map.put(num, map.getOrDefault(num, 0) +1);
		}
		
		Collections.sort(nlist);
		System.out.println(map);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());			
			
			sb.append(map.getOrDefault(num, 0) + " ");
		}
		

		System.out.println(sb);
	}
}
