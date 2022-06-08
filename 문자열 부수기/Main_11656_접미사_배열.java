import java.util.*;
import java.io.*;

public class Main_11656_접미사_배열 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		List<String> list = new ArrayList<>();
		
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			String temp = str.substring(i, str.length());
			list.add(temp);
		}
		
		Collections.sort(list);
		for(String str2 : list) {
			sb.append(str2 + "\n");
		}
		
		System.out.println(sb);
		
	} // End of main
} // End of class