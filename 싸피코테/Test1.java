import java.io.*;
import java.util.*;


//N개의 정수가 있는 수열이 주어진다.
//이 수열에서 짝수와 짝수가 인접한 경우나 홀수와 홀수가 인접한 경우가 없도록 하고 싶다.
//할 수 있는 작업은 인접한 두 수를 교환하는 것이다. 가능한 최소 작업 횟수를 구하라.

// 나머지 구하기
public class Test1 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_test1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		while(N-->0) {
			int result = 0;
			int num = Integer.parseInt(br.readLine());
			int arr[] = new int[num];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<num; i++) {
				int num1 = arr[i];
				
				for(int j=0; j<num; j++) {
					if(j==i) continue;
					
					result += num1 % arr[j];
				}
			}
			
			sb.append('#').append(count++).append(' ').append(result).append('\n');
		}

		System.out.println(sb);
	} // End of main

} // End of Test1