import java.io.*;
import java.util.Arrays;


public class test2 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int len = str.length();
		int arr[] = new int[26];
		Arrays.fill(arr, -1);
		
		for(int i=0; i<len; i++) {
			int ch = str.charAt(i) - 97;
			
			if(arr[ch] == -1) {
				arr[ch] = i;
			}
		}
		
		for(int num : arr) {
			sb.append(num).append(' ');
		}
		
		System.out.println(sb);
        
    } // End of main
} // End of Main class