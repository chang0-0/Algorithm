import java.util.*;
import java.io.*;

public class Main_18870_좌표압축 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/18870.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N]; 
		int sorted[] = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sorted);
		
		int rank = 0;
		for(int v : sorted) {
			if(!map.containsKey(v)) {
				map.put(v, rank);
				rank++;
			}
		}
		
		for(int num : arr) {
			int count = map.get(num);
			sb.append(count).append(' ');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // End of main
} // End of Main 