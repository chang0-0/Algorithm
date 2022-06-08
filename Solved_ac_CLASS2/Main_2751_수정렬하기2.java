import java.util.*;
import java.io.*;

public class Main_2751_수정렬하기2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2751.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		for(int num : list) {
			sb.append(num).append('\n');
		}
		System.out.println(sb);
	}
}
