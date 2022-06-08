import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/17219
// 첫 번째 줄부터 M개의 줄에 걸쳐 비밀번호를 찾으려는 사이트 주소의 비밀번호를 차례대로 각 줄에 하나씩 출력한다.

public class Main_17219_비밀번호찾기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 저장된 사이트의 주소 수
		int M = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트의 주소 수
		HashMap<String, String> map = new HashMap<>();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
				
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			sb.append(map.get(st.nextToken())).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // End of main
} // End of Main class