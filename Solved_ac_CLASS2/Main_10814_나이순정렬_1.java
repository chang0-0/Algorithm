import java.util.*;
import java.io.*;

public class Main_10814_나이순정렬_1 {
	// https://www.acmicpc.net/problem/10814
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10814.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());		
		StringBuilder p[] = new StringBuilder[201];
		
		//객체배열의 인덱스에 각 StringBuilder 객체를 생성한다.
		
		for(int i = 0; i< p.length; i++) {
			p[i] = new StringBuilder();
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			p[age].append(age).append(' ').append(name).append('\n');
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(StringBuilder val : p) {
			sb.append(val);
		}
		
		System.out.println(sb);
		
		
	} // End Main	
} // End Class
