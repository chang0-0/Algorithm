import java.io.*;
import java.util.*;

public class Main_10871_X보다작은수 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10871.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		int length = Integer.parseInt(temp[0]);
		int range = Integer.parseInt(temp[1]);
		
		List<Integer> list = new ArrayList<>();
		String arr[] = br.readLine().split(" ");
		
		for(int i=0; i<arr.length; i++) {
			int num = Integer.parseInt(arr[i]);
			
			if(num < range) {
				list.add(num);
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}	
	}
}
