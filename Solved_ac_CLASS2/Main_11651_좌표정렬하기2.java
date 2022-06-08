import java.util.*;
import java.io.*;

public class Main_11651_좌표정렬하기2 {
	static int arr[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11651.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		// 2차원 배열 생성
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());	
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (arr_1, arr_2) -> {
			// 정렬 조건
			/*  1. y의 값을 기준으로 오름차순으로 정렬 함
				2. y의 값이 같을 경우 x값을 기준으로 정렬 함  
			*/
			
			if(arr_1[1] == arr_2[1]) {
				return arr_1[0] - arr_2[0];
			}
			else {
				return arr_1[1] - arr_2[1];
			}
		});
		
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}
}
