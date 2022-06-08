import java.io.*;

public class Main_1157_단어공부 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1157.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		str = str.toUpperCase();
		
		int[] arr = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				arr[str.charAt(i) - 65]++;
			}
		}
		
		int max = -1;
		char ch = '?';
		for (int i = 0; i < 26; i++) {
 
			if (arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 65);
			} 
			else if (arr[i] == max) {
				ch = '?';
			}
		}
		System.out.print(ch);
	}	
} // End of class