import java.util.regex.Pattern;
import java.io.*;

// https://www.acmicpc.net/problem/status/1013/93/1
// 목표 : 주어진 전파가 제시한 패턴이면 “YES”를 그렇지 않은 경우는 “NO”를 출력한다.

public class Main_1013_Contact {
	private static final Pattern P = Pattern.compile("(100+1+|01)+");
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		// 패턴 : (100+1+ | 01)+
		
		while(T-- > 0) {
            if (P.matcher(br.readLine()).matches()) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
		}
		
		System.out.println(sb);
		
	} // End of main
} // End of class 