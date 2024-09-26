import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11399

public class Main_11399_ATM {
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11399.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(N --> 0) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int count = 0;
		int sum = 0;
		for(int num : list) {
			count += num;
			sum += count;
		}
		
		System.out.println(sum);
	}
}
