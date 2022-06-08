import java.util.*;
import java.io.*;

public class Main_2164_카드2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2164.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> linkedlist = new LinkedList<>();
		int num = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=num; i++) {
			linkedlist.add(i);
		}
		
		int i = 0;
		while(linkedlist.size() != 1) {
			linkedlist.remove(i);
			int temp = linkedlist.get(i);
			linkedlist.remove(i);
			linkedlist.add(linkedlist.size(), temp);

		}
		
		System.out.println(linkedlist.get(0));
	}
}
