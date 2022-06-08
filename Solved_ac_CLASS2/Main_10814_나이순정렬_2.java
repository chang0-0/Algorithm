import java.util.*;
import java.io.*;

public class Main_10814_나이순정렬_2 {
	// https://www.acmicpc.net/problem/10814
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10814.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 나이와 이름을 저장할 2차원 배열 생성
		String[][] arr = new String[N][2];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		

		
		
	} // End Main	
} // End Class
