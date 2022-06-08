import java.util.*;
import java.io.*;

public class Main_11650_좌표정렬하기 {
	static int arr[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int [N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// 2차원 배열 정렬을 위해 Arrays.sort()를 확장한 정렬 방법을 사용하여 푼다.
		// Arrays.sort() 확장을 위한 람다식 사용
		Arrays.sort(arr, (arr_1, arr_2) -> {
			// 2차원 배열의 정렬.
			// 배열1과 배열2를 비교하는 방식으로 진행하면서
			// arr_1의 x좌표와 arr_2의 x좌표가 같을 경우
			if(arr_1[0] == arr_2[0])  {
				return arr_1[1] - arr_2[1];
			}
			else {
				return arr_1[0] - arr_2[0];	
			}
		});
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}
}
