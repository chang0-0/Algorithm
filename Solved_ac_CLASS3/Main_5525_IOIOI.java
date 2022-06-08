import java.io.*;

// 문제 : https://www.acmicpc.net/problem/5525

public class Main_5525_IOIOI {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_5525.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N+1개의 I와 O로만 이루어진 문자열
		int N = Integer.parseInt(br.readLine()); // Pn의 n
		int M = Integer.parseInt(br.readLine()); // 문자열의 길이
		char s[] = br.readLine().toCharArray();
		
		int result = 0;
		int count = 0;
		
		for(int i=1; i < M - 1; i++) {
			
			if(s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
				count++;
				
				// 겹치는 부분도 고려해야함.
				// IOIOI에서 IOI를 찾는다고 했을 때, IOI를 한번 찾고나면 다음 IOI를 찾기위해서는 
				// IO를 건너뛰어야 하기 때문에, 2를 건너뛰어야 함.
				
				// 일치하는 값인 count와 N의 값이 같아지면 결과를 나타내는 result를 증가
				if(count == N) {
					count--;
					result++;
				}
				i++;
			}
			//틀리면 count를 초기화.
			else {
				count = 0;
			}
			
		}
		
		System.out.println(result);

	} // End of main
} // End of class