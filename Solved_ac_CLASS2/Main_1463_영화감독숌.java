import java.io.*;

public class Main_1463_영화감독숌 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1463.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int seriesNum = Integer.parseInt(br.readLine());
		int count = 0;
		
		int i = 666;
		for(;;) {
			String temp = Integer.toString(i);
			int sixCount = 0;
			
			for(int j = 0; j<temp.length(); j++) {
				char ch = temp.charAt(j);
				
				if(ch == '6') {
					sixCount ++;
				}
				else {
					sixCount = 0;
				}
				
				if(sixCount == 3) {
					count ++;
					break;
				}				
			}
			
			if(seriesNum == count) {
				System.out.println(i);
				break;
			}
			
			i++;
		}
		
		br.close();
	}
}
