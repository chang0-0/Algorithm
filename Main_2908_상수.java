import java.io.*;

public class Main_2908_상수 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2908.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr[] = br.readLine().split(" ");
		int max = 0;
		
		for(int i=arr.length-1; i>=0; i--) {
			String temp = arr[i];
			String num = "";
			
			for(int j=temp.length()-1; j>=0; j--) {
				num += temp.charAt(j);
			}
			
			if(max < Integer.parseInt(num)) {
				max = Integer.parseInt(num);
			}
		}
		
		System.out.println(max);
	}
}
