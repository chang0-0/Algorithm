import java.io.*;

// 문제 : https://www.acmicpc.net/problem/2941

public class Main_2941_크로아티아_알파벳 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2941.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		// 1. 일반 구현
		int len = str.length();
		int count = 0;
		
		for(int i=0; i<len; i++) {
			char ch = str.charAt(i);
			
			// 글자가 c로 시작
			if(ch == 'c' && i <len - 1) {
				if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
					i++;
				}
			}
			// 글자가 d로 시작
			else if(ch == 'd' && i < len - 1) {
				if(str.charAt(i + 1) == '-') {
					i++;
				}
				else if(str.charAt(i + 1) == 'z' && i < len - 2) {
					if(str.charAt(i + 2) == '=') {
						i += 2;
					}
				}
			}
			// 글자가 l또는 n이고, i보다 문자열의 길이가 1뺀 값보다 클 때
			// 즉, lj, nl를 판단하기 현재 위치 i에서 뒤에 남아있는 글자가 더 있는지 체크
			else if( (ch == 'l' || ch == 'n') && i < len - 1 ) {
				if(str.charAt(i + 1) == 'j') {
					i++;
				}
			}
			// 첫 글자가 s또는 z이고, 뒤에 문자가 하나 더 올 수 있으면
			else if( (ch == 's' || ch == 'z') && i < len - 1 ) {
				if(str.charAt(i + 1) == '=') {
					i++;
				}
			}
			
			count ++;
		}
		
		System.out.println(count);
			
	} // End of main
} // End Main class