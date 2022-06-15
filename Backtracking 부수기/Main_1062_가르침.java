import java.util.*;
import java.io.*;

public class Main_1062_가르침 {
	static int N;
	static int K;
	static int count = 0;
	static int max = 0;
	static String word[];
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1062.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new String[N];
		visit = new boolean[26];
		
		if(K<5) {
			System.out.print(0);
			return;
		}
		else if(K==26) {
			System.out.println(N);
			return;
		}
		
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			word[i] = temp.substring(4, temp.length()-4);
		}
		
		visit['a'-97] = true;
		visit['n'-97] = true;
		visit['t'-97] = true;
		visit['i'-97] = true;
		visit['c'-97] = true;
		
		backtracking(0, 0);
		System.out.print(max);
	} // End of main
	
	static void backtracking(int index, int depth) {
		
		if(depth == K-5) {
			int count = 0;
			
			for(int i=0; i<N; i++) {
				boolean bol = true;
				int len = word[i].length();
				for(int j=0; j<len; j++) {
					if(visit[word[i].charAt(j) - 97]) continue;
					bol = false;
					break;
				}
				if(bol) count++;
			}
			
			max = Math.max(max, count);
			return;
		}
		
		for(int i=index; i<26; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			backtracking(i+1, depth+1);
			visit[i] = false;
		}
	} // End of backtracking
} // End of Main class