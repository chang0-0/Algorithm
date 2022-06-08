import java.util.*;
import java.io.*;

public class Main_13549_숨바꼭질3_2 {
	static int arr[] = new int[100001];
	
	static int N, K, next_X;
	static int min_time = Integer.MAX_VALUE / 16;	
	
	public static class Node {
		int X; // 수빈이의 위치
		int time; // 시간(가중치 개념)
		
		public Node (int X, int time) {
			this.X = X;
			this.time = time;		
		}
	} // End of Node class
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_13549.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		K = Integer.parseInt(st.nextToken()); // 동생의 위치
		
		// 동생과 수빈이위치가 같거나
		// 수빈이가 동생 보다 앞에 있을 때,
		if(N >= K) {
			System.out.println(N - K);
			return;
		}
		
		
		BFS();
		
		
		System.out.println(min_time);
		
	} // End of main
	
	private static void BFS() {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(N, 0));
		int time;
		arr[0] = -1;
		
		while( !que.isEmpty() ) {
			Node node = que.poll();
			
			if(node.X == K) {
				min_time = Math.min(min_time, node.time);
			}
			
			for(int i=0; i<3; i++) {
				time = 0;
				
				switch(i) {
					case 0: next_X = node.X + 1;
							time = node.time + 1;
					 	break;
					case 1: next_X = node.X - 1;
							time = node.time + 1;
						break;
					case 2: next_X = node.X * 2;
							time = node.time;
						break;
				}

								
				// 방문을 했지만, 방문한 시간이 이전 시간 보다 더 적을 경우,
				if(range_check() && arr[next_X] > 0) {
					if(time < arr[next_X]) {
						arr[next_X] = time;
					}
				}
				
				// visit이 0일 경우, 한번도 방문 한적이 없는 경우
				if(range_check() && arr[next_X] == 0) {
					arr[next_X] = time;
					que.offer(new Node(next_X, time));
				}	
				
				
			}
			
		}
		
	} // End of BFS
	
	private static boolean range_check() {
		return (next_X >= 0 && next_X < 100001);
	} // End of range_check

	
} // End of Main class
