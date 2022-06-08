import java.io.*;

public class Main_2231_분해합{

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		for(int i=1; i<=N; i++) {
			String temp = Integer.toString(i);
			int sum = 0;
			
			for(int j=0; j<temp.length(); j++) {
				sum += Character.getNumericValue(temp.charAt(j));
			}
			sum += Integer.parseInt(temp);
			
			if(sum == N) {
				System.out.println(temp);
				break;
			}
			else if(i==N) {
				System.out.println(0);
			}
		}
	}
}
