import java.io.*;
import java.util.*;

// 문제 : https://www.acmicpc.net/problem/1620

public class Main_1620_나는야_포켓몬_마스터_이다솜 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1620.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken()); // 포켓몬의 개수
		int M = stoi(st.nextToken()); // 문제의 개수
		
		String arr[] = new String[N + 1];
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String pokemon = br.readLine();
			arr[i] = pokemon;
			map.put(pokemon, i);
		}

		while(M --> 0) {
			String Q = br.readLine();
			
			// 아스키코드로 탐색
			// 48 ~ 57은 0 ~ 9에 해당
			if(Q.charAt(0) <= 57) {
				int key = Integer.parseInt(Q);
				sb.append(arr[key]+"\n");
			}
			else {
				sb.append(map.get(Q)+"\n");
			}
		}
		
		System.out.println(sb);
		
	} // End of main

	private static int stoi(String nextToken) {
		return Integer.parseInt(nextToken);
	}
} // End of class