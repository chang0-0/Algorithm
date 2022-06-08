import java.io.*;
import java.util.*;

// 이 수열에서 짝수와 짝수가 인접한 경우나 홀수와 홀수가 인접한 경우가 없도록 하고 싶다.
// 할 수 있는 작업은 인접한 두 수를 교환하는 것이다. 가능한 최소 작업 횟수를 구하라.

public class Test2 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_test2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		while(N-->0) {
			int result = 0;
			int num = Integer.parseInt(br.readLine());
			int arr[] = new int[num];
			
			
			int jjak = 0; 
			int hol = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<num; i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i] = temp; 
				
				if(temp % 2 == 0) {
					jjak++;
				}
				else {
					hol++;
				}
			}
			
			int len = arr.length;
			// 짝수나 홀수가 num의 개수 절반 이상이면 불가능
			if(num <= 2) {
				if(hol==jjak) {
					result = -1;
				}
				else {
					result = 0;
				}
				sb.append('#').append(count++).append(' ').append(result).append('\n');
				continue;
			}
			else if(num > 2) {
				if( hol > len/2 || jjak > len/2 ) {
					sb.append('#').append(count++).append(' ').append(-1).append('\n');
					continue;
				}
			}
			
			for(int i=0; i<num; i++) {
				int num1 = arr[i];
				
				for(int j=0; j<num-1; j++) {
					
					if(i == j) continue;
					
					int temp2 = arr[j];
					arr[j] = num1;
					arr[j+1] = temp2;
				}
			}
			
			sb.append('#').append(count++).append(' ').append(result).append('\n');
		}

		System.out.println(sb);
	} // End of main
	
} // End of Test2