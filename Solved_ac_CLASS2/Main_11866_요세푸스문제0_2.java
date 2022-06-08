import java.util.*;
import java.io.*;

public class Main_11866_요세푸스문제0_2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11866.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		sb.append('<');
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		int index = 0;
		
		while(N > 1) {
			index = (index + (K - 1)) % N;
			sb.append(list.remove(index)).append(", ");
			N--;
		}
		
		sb.append(list.remove()).append('>');
		System.out.println(sb);
		
	}
}
