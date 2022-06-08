import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/12851
// 목표 : 첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
// 둘째 줄에는 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수를 출력한다.

// 5 -> 4 -> 8 -> 16 -> 17 (4초)
// 5 -> 10 -> 9 -> 18 -> 17 (4초)

// K == N 일 경우, 0 1 출력
 
public class Main_12851_숨바꼭질2 {
	static Queue<Integer> que = new LinkedList<>();
	static int arr[] = new int[100001];

	static int N, K;
	static int min_time, count;
	static int next_time;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_12851.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		K = Integer.parseInt(st.nextToken()); // 동생의 위치
		
		// 순간이동은 *2 로 증가만 가능하므로, 뒤로가는 방법은 - 1밖에 없다.
		// 뒤로가는 것은 N - K로 계산하면됨. 방법의 수는 1가지
		if(N >= K) {
			System.out.println(N-K);
			System.out.println(1);
			return;
		}

		BFS();
		
		System.out.println(min_time);
		System.out.println(count);
			
	} // End of main
	
	private static void BFS() {
		min_time = Integer.MAX_VALUE/16; // 최단 시간
		count = 0;
		que.offer(N);
		arr[N] = 1;

		while( !que.isEmpty() ) {
			int time = que.poll();
			
			if(min_time < arr[time]) {
				return;
			}
			
			// 3가지 경우의 수를 동시에 완전 탐색
			// 범위를 벗어나지 않는 선에서
			for(int i=0; i<3; i++) {
				
				switch(i) {
					case 0: next_time = time + 1;
						break;
					case 1: next_time = time - 1;
						break;
					default : next_time = time * 2;
				}
			

				if(next_time == K) {
					min_time = arr[time];
					count ++;
				}
				
				
				if( Range_check() && (arr[next_time] == 0 || arr[next_time] == arr[time] + 1) ) {
					que.offer(next_time);
					arr[next_time] = arr[time] + 1;
				}
			
				
			}
		}
		
	} // End of BFS
	
	// 범위 체크
	private static boolean Range_check() {
		return (next_time >= 0 && next_time < 100001);
	} // End of Range_check
	

} // End of class
