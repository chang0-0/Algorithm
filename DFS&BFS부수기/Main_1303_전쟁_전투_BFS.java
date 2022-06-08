import java.util.*;
import java.io.*;

public class Main_1303_전쟁_전투_BFS {
	static int N; // 가로
	static int M; // 세로
	static int white_count = 0;
	static int black_count = 0;
	static int now_y;
	static int now_x;
	static int x;
	static int y;
	static int count;
	
	// BFS에서 사용하기 위한 Queue
	static Queue<Node> que = new LinkedList<>();
	static int dirY[] = {-1, 1, 0, 0}; // 상 하 좌 우
	static int dirX[] = {0, 0, -1, 1}; // 상 하 좌 우
	static boolean visit[][];
	static char map[][];
	
	// Queue에 x, y좌표를 담기위해 만든 클래스
	static class Node {
		int x;
		int y;
		
		// 2차원 배열에서 사용을 위해 순서를 바꿨음
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	} // End Node
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_bj_1303.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 새로
		
		// 1. 지도와 방문여부를 체크하는 배열 초기화 및 생성
		map = new char[M][N];
		visit = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
			}
		}
		
		// 2차원 배열 순환 -> BFS탐색
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				
				// false -> 방문한적이없는 곳일 경우
				if( visit[i][j] == false) {
					char color = map[i][j];		
					count = 0;

					if(color == 'W') {
						BFS(i, j, color);
						white_count += count * count;
					}
					else {
						BFS(i, j, color);
						black_count += count * count;
					}
					
				}
			}
		}
		
		System.out.println(white_count + " " + black_count);
	} // End of main
	
	static void BFS(int y, int x, char ch) {

		// BFS가 시작하면 x, y좌표를 Que에 집어넣음
		// 방문한 곳을 true값으로 바꿔줌
		que.offer(new Node(y, x));
		count = 1;
		visit[y][x] = true;

		// BFS특성 Queue가 빌때 까지 계속해서 반복
		while( !que.isEmpty() ) {
			// 들어온 값을 que에서 하나 빼냄
			// x y 좌표 두가지를 담기위해 Node형으로 Queue를 만들음
			Node node = que.poll();
			
			// 상 하 좌 우 4방향을 검사
			for(int i=0; i<4; i++) {
				// dirY : {-1, 1, 0, 0}; // 상 하 좌 우
				// dirX : {0, 0, -1, 1}; // 상 하 좌 우
				// 상 하 좌 우 로 4방향을 탐색 하기 위해서 2개의 배열을 임의로 만들어놓았다
				// y는 위아래로만 검사 -1, 1
				// x는 좌우 로만 검사 1 , -1
			
				// 0 보다 크거나 같아야 하기 때문에 처음 시작하는 1의 위치 기준으로 보면
				// now_y가 -1이 나와야 검사를 하지 않는다 때문에 상의 값을 -1로 섦정했다
				// now_x 도 마찬가지로 처음 시작 1을 기준으로 봤을 때 왼쪽으로 넘어가면 안된다.
				// 그렇기 때문에 좌의 값을 -1로 지정해서 범위 밖이 되도록 설정했다.
				now_y = node.y + dirY[i];
				now_x = node.x + dirX[i];

				// 범위를 검사하는 함수 실행 
				// 범위에 속하면서, 방문하지 않았으면서, 찾는 색과 지도의 색이 같을 조건
				if(Range_check() == true && visit[now_y][now_x] == false && ch == map[now_y][now_x]) {   
						que.offer(new Node(now_y, now_x));
						visit[now_y][now_x] = true;
						count++;
				}

			} //End for	
		}
			
	} // End of BFS
	

	// 범위에 들어오는지 검사하는 함수
	static boolean Range_check() {
		// 현재 x값과 y값이 지도의 범위를 벗어나지 않는지 체크
		// y와 x는 기본으로 0 부터시작하니 0과 같거나 커야한다.
		// y값은 세로인 M보다는 작아야함 
		// x값은 가로인 N보다는 커야함
		return (now_y >= 0 && now_y<M && now_x>=0 && now_x<N);
		
	} // End Range_check
	
} // End Class
