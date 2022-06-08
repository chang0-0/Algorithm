import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13549
// 목표: 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

// 풀이 참고 : https://moonsbeen.tistory.com/97
// https://zereight.tistory.com/174

public class Main_13549_숨바꼭질3 {
	static int arr[] = new int[100001];
	static boolean[] visit = new boolean [100001];
	
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
		
		while( !que.isEmpty() ) {
			Node node = que.poll();
			
			if(node.X == K) {
				min_time = node.time;
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
				
				if(next_X == 0) {
					continue;
				}
				
				// 방문을 했지만, 방문한 시간이 이전 시간 보다 더 적을 경우,
				if(range_check() && arr[next_X] > 0) {
					if(time < arr[next_X]) {
						visit[next_X] = false;
					}
				}
				
				// visit이 0일 경우, 한번도 방문 한적이 없는 경우
				if(range_check() && visit[next_X] == false) {
					visit[next_X] = true;
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
