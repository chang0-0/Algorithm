import java.io.*;

public class Main_2577_숫자의개수 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/2577.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int arr[] = new int[10];
		
		int num = 1;
		for(int i=0; i<3; i++) {
			num *= Integer.parseInt(br.readLine());
		}
		String str = Integer.toString(num);
		int len = str.length();
		
		for(int i=0; i<len; i++) {
			char ch = str.charAt(i);
			arr[Character.getNumericValue(ch)]++;
		}
		
		for(int temp : arr) {
			sb.append(temp).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // End of main
} // End of Main class