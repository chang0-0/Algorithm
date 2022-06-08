import java.util.*;
import java.io.*;

public class Test4 {
	public static void main(String[] args) throws Exception  {
		System.setIn(new FileInputStream("res/test4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); // 하행
		int H = Integer.parseInt(st.nextToken()); // 상행
		
		// 충주로 향하는 하행열차
		for(int i=0; i<C; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String time = st.nextToken();
		}
		
		// 부발로 향하는 상행 열차
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String time = st.nextToken();
		}

		

		
		
	} // End of main

} // End of Main class