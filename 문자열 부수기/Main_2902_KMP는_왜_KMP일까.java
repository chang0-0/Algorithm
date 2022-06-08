import java.io.*;

public class Main_2902_KMP는_왜_KMP일까 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2902.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char str[] = br.readLine().toCharArray();
				
		for(char ch : str) {
			
			if(ch >= 65 && ch <= 90) {
				bw.append(ch);
			}
		}
		
		bw.flush();
		bw.close();
	} // End of main
} // End of class