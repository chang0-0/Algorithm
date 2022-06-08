import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10610
// 그리디 알고리즘
// 예외 : 만들 수 없는 경우 -> -1을 출력.
// 30의 배수에는 무조건 0이 포함되어 있다.
// 3의 배수여야 한다.

public class Main_10610_30 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10610.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char arr[] = br.readLine().toCharArray();
		Arrays.sort(arr);
		int len = arr.length;
		
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		for(int i = len - 1; i >= 0; i--) {
			
			// 아스키코드 0의 48 값을 빼줘서 문자를 숫자로 변환.
			int num = arr[i] - '0';
			sum += num;
			sb.append(num);
		}
		
		// 30의 배수인지 판단하기 위한 조건 생성
		// arr배열의 가장 첫번째가 0이 아니거나, sum이 3의 배수가 아닐 경우,
		// 2개의 조건을 하나라도 만족하지 못하면, 30의 배수가 아니다
		if(arr[0] != '0' || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sb);
		
	} // End of main
} // End of class