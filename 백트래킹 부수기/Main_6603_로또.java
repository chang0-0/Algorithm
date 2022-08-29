import java.util.*;
import java.io.*;

public class Main_6603_로또 {
	static int N;
	static boolean visit[];
	static int arr[];
	static int ans[];
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/6603.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String temp = "";
		while( (temp = br.readLine()) != null ) {
			if(temp == "0") break;

			
			st = new StringTokenizer(temp);
			N = Integer.parseInt(st.nextToken());
			visit = new boolean[N];
			arr = new int[N];
			ans = new int[6];
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			DFS(0, 0);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // End of main
	
	static void DFS(int index, int depth) {
		
		if(depth == 6) {
			for(int i=0; i<N; i++) {
				if(visit[i]) {					
					sb.append(arr[i]).append(' ');
				}
			}
			sb.append('\n');
			return;
		}
		
		for(int i=index; i<N; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			DFS(i, depth + 1);
			visit[i] = false;				
		}
		
	} // End of DFS
} // End of Main class