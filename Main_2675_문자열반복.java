import java.io.*;

public class Main_2675_문자열반복 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2675.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int loopCount = Integer.parseInt(br.readLine());
		
		for(int i=0; i<loopCount; i++) {
			String arr[] = br.readLine().split(" ");
			int loopCount2 = Integer.parseInt(arr[0]);
			int strLength = arr[1].length();
			String str = arr[1];
			String temp = "";
			
			for(int j=0; j<strLength; j++) {
				for(int k=0; k<loopCount2; k++) {
					temp += str.charAt(j);
				}
				
			}
			System.out.print(temp);
			System.out.println(" ");
		} 
		
		br.close();
	}
}