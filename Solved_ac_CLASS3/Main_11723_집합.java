import java.util.*;
import java.io.*;

public class Main_11723_집합 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/11723.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<>();
		
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int x = 0;
			if( !str.equals("all") && !str.equals("empty") ) x = Integer.parseInt(st.nextToken());
			
			if(str.equals("add")) set.add(x);
			else if(str.equals("remove")) set.remove(x);
			else if(str.equals("check")) {
				if(set.contains(x)) sb.append(1).append('\n');
				else sb.append(0).append('\n');
			}
			else if(str.equals("toggle")) {
				if(set.contains(x)) set.remove(x);
				else set.add(x);
			}
			else if(str.equals("all")) {
				for(int i=1; i<=20; i++) set.add(i);
			}
			else if(str.equals("empty")) set.clear();
			
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class