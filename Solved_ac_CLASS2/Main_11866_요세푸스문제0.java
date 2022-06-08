import java.util.*;
import java.io.*;

public class Main_11866_요세푸스문제0 {
	static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11866.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<N+1; i++) {
			que.add(i);
		}
		
		while( que.size() > 1 ) {
			
			for(int i=0; i<K-1; i++) {
				int temp = que.poll();
				que.add(temp);
			}
			int num = que.poll();
			sb.append(num).append(", ");
			
		}
		
		int num = que.poll();
		sb.append(num).append(">");
		
		System.out.println(sb);
	}
}
