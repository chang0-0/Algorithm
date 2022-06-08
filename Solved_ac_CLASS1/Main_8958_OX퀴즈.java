import java.io.*;

public class Main_8958_OX퀴즈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_8958.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int count = 0;
		for(int i=0; i<loop; i++) {
			String temp = br.readLine();
			
			for(int j=0; j<temp.length(); j++) {
				
				if(temp.charAt(j) == 'O') {
					count ++;
					sum += count;
				}
				else if(temp.charAt(j) == 'X') {
					count = 0;
				}
			}
			
			System.out.println(sum);
			sum = 0;
			count = 0;
		}

	}
}
