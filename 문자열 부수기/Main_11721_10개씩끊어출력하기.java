import java.io.*;

public class Main_11721_10개씩끊어출력하기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11721.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char ch[] = br.readLine().toCharArray();
		int ch_len = ch.length;
		
		for(int i=0; i<ch_len; i++) {
			bw.append(ch[i]);
			if((i+1) % 10 == 0) bw.append("\n");
		}	
				
		bw.flush();
		bw.close();
		
	} // End of main
} // End of class