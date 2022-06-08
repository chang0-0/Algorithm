import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1764

public class Main_1764_듣보잡 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1764.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		
		while(N --> 0) {
			set.add(br.readLine());
		}
		
		while(M --> 0) {
			String name = br.readLine();	
			if(set.contains(name)) {
				list.add(name);
			}
		}
		
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        while(!list.isEmpty()){
            sb.append(list.remove(0)).append('\n');
        }
        System.out.println(sb);
	}
} // End of class