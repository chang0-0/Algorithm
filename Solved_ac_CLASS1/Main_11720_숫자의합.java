import java.io.*;

public class Main_11720_숫자의합 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11720.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		String num2 = br.readLine();
		
		int sum = 0;
		for(int i=0; i<num1; i++) {
			sum += Character.getNumericValue(num2.charAt(i));
		}
		
		System.out.println(sum);

	}

}
