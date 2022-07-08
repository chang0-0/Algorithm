import java.util.*;
import java.io.*;

// I n은 정수 n을 Q에 삽입하는 연산을 의미한다.
// 동일한 정수가 삽입될 수 있음
// D 1은 Q에서 최댓값을 삭제하는 연산
// D -1은 Q에서 최솟값을 삭제하는 연산을 의미

public class Main_7662_이중우선순위큐 {
	static PriorityQueue<Integer> que = new PriorityQueue<>();
	static PriorityQueue<Integer> Dque = new PriorityQueue<>(Collections.reverseOrder());
	static HashMap<Integer, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/7662.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int Q = Integer.parseInt(br.readLine());
			for(int i=0; i<Q; i++) {
				st = new StringTokenizer(br.readLine());
				String fun = st.nextToken();			
				int n = Integer.parseInt(st.nextToken());
				
				if(fun.equals("I")) input(n);
				else {
					if(map.isEmpty()) continue;
					else delete(n);
				}
			}
			
			if(map.isEmpty()) sb.append("EMPTY").append('\n');
			else {
				int n = removeMap(que);
				sb.append(n).append(' ').append(removeMap(Dque));
			}
		}

		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
	
	private static void input(int n) {
		map.put(n, map.getOrDefault(n, 0) + 1);
		que.offer(n);
		Dque.offer(n);
	} // End of input
	
	private static int delete(int n){
		
		if(n == 1) {
			PriorityQueue<Integer> tempQue = que;
			return removeMap(tempQue);
		}
		else {
			PriorityQueue<Integer> tempQue = Dque;
			return removeMap(tempQue);
		}
	} // End of delete
	
	private static int removeMap(PriorityQueue<Integer> que) {
		int num;
		for(;;) {
			num = que.poll();
			int cnt = map.getOrDefault(num, 0);
			
			if(cnt == 0) continue;
			
			if(cnt == 1) map.remove(num);
			else map.put(num, cnt - 1);
			
			break;
		}
		
		return num;
	} // End of removeMap
} // End of Main class