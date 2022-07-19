import java.io.*;

public class Main_14555_공과잡초 {	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/14555.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append('#').append(t).append(' ');
			char ch[] = br.readLine().toCharArray();
			char temp = ch[0];
			int result = 0;
			
			int len = ch.length;
			for(int i=1; i<len; i++) {
				String str = Character.toString(temp) + Character.toString(ch[i]);
				
				if( str.equals("(|") || str.equals("|)") ) {
					result++;
				}
				else if( str.equals("()") ) result++;
				
				temp = ch[i];
			}
			
			sb.append(result).append('\n');
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class