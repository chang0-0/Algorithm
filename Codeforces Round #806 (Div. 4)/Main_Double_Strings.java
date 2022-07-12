import java.io.*;
import java.util.*;

public class Main_Double_Strings {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Double_Strings.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 1의 개수와 0의 개수를 파악해서 둘의 개수를 같게 해주면 됨
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			if(N==1) {
				sb.append(0).append('\n');
				continue;
			}
			int arr[][] = new int[N][N];
			
			int zero = 0; int one = 0;
			
			for(int i=0; i<N; i++) {
				char ch[] = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					int num = ch[j] - '0';
					arr[i][j] = num;
					if(num == 0) zero++;
					else one++;
				}
			}
			
			System.out.println(zero + ", " + one);
			
			for(int num[] : arr) System.out.println(Arrays.toString(num));
			
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
} // End of Main class