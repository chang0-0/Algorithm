import java.util.*;
import java.io.*;

public class Main_7576_토마토 {
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static int box[][];
	static boolean visit[][];
	static Queue<Node> que = new LinkedList<>();
	// 참고 : https://hyeonseong.tistory.com/46
	
	static int N, M;
	static int now_x, now_y;
	static int count = 0;
	
	private static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean zero_test = false;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		
		box = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				// 익은 토마토가 여러 개 있을 경우 동시 진행을 위해 1의 위치는 곧바로 que에 넣음
				if(num == 1) {
					que.offer(new Node(j, i));
				}
				// 0이 있는 경우 true처리
				else if(num == 0) {
					zero_test = true;
				}

				box[i][j] = num;
			}
		}
		
		// 상자에 0이 하나라도 없으면 zero_test가 false이므로 
		// 바로 -1 출력 후 종료
		if(zero_test == false) {
			System.out.println(0);
			return;
		}
		
		while( !que.isEmpty() ) {
			BFS(que.size());
			count++;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {

				if(box[i][j]== 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		// 이미 1부터 시작하기 때문에 제외하기 위해서 -1;
		System.out.println(count - 1);
	}
	
	static void BFS(int size) {
		
		// 다른 BFS는 que가 빌 때 까지 반복했지만,
		// 1이 여러개 일 때 동시에 토마토가 익는 것을 계산하기 위해 바깥에서 que를 비울 때 까지 돌림.
		
		// que.size()가 0이 될 때까지만 돌게됨
		while( size-- > 0 ) {
			Node node = que.poll();
			
			for(int i=0; i<4; i++) {
				now_x = node.x + dirX[i];
				now_y = node.y + dirY[i];
				
				// 0인 것들을 익은 토마토 구분 짓기 위해 1로 변환시킴
				if( Range_check() && visit[now_y][now_x] == false && box[now_y][now_x] == 0 ) {
					que.offer(new Node(now_x, now_y));
					visit[now_y][now_x] = true;
					box[now_y][now_x] = 1;
					
				}

			}	
			
		}
	}
	
	private static boolean Range_check() {
		return (now_x >= 0 && now_y >= 0 && now_x < M && now_y < N);
	}
}
