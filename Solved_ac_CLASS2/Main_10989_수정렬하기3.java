import java.util.*;
import java.io.*;

public class Main_10989_수정렬하기3 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10989.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int num : arr) {
			sb.append(num).append('\n');
		}
		
		System.out.println(sb);
	}
}
