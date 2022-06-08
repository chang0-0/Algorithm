import java.io.*;
import java.util.*;

// list를 사용해서 BufferedWriter 출력 굉장히 비효율적..

public class Main_2751_수정렬하기2_3 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2751.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		int size = list.size();
		for(int i=0; i<size; i++) {
			bw.write(list.get(i).toString());
			bw.write('\n');
		}

		bw.flush();
		bw.close();
	} // End of main
} // End of class