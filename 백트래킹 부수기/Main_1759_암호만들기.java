import java.util.*;
import java.io.*;

public class Main_1759_암호만들기 {
	static char arr[];
	static boolean visit[];
	static int L, C;
	static String result = "";
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1759.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		visit = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		DFS(0, 0, "");
		
		System.out.println(result);
	} // End of main
	
	static void DFS(int index, int depth, String str) {
		if(depth == L) {
			
			if(check(str)) {				
				result += str + "\n";
				return;
			}
			
			return;
		}
		
		for(int i=index; i<C; i++) {
			
			if(visit[i]) continue;
			
			// 자기 보다 낮은 숫자에 false가 있으면 지나쳐야함.
			visit[i] = true;
			DFS(i + 1, depth + 1, str + arr[i]);
			visit[i] = false;
		}
		
	} // End of DFS
	
	static boolean check(String str) {
		// 최소 한개의 모음 2개의 자음 체크
		
		char ch[] = str.toCharArray();
		int len = ch.length;
		int count = 0;
		int count2 = 0;
		for(int i=0; i<len; i++) {
			
			if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
				count++;
			}
			else {
				count2++;
			}
		}

		if(count > 0 && count2 >= 2) {
			return true;
		}


		return false;
	} // End of check
	
} // End of Main class