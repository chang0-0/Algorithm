import java.util.*;
import java.io.*;
// x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 자연수는 231보다 작다

public class Main_11279_최대힙 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/11279.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());	
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) {
				pq.offer(num);
			}
			else {
				
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}
				else {
					sb.append(pq.poll()).append('\n');
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	} // End of main
} // End of Main class