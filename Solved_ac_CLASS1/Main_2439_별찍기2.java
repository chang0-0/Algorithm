import java.io.*;

public class Main_2439_별찍기2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2439.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=count; i>0; i--) {
			
			for(int k=1; k<i; k++) {
				System.out.print(" ");
			}
			
			for(int j=0; j<=(count - i); j++) {
				System.out.print("*");
			}
			
			System.out.println("");
		}
	}
}
