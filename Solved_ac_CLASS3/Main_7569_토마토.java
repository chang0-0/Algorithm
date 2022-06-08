import java.util.*;
import java.io.*;

// 문제 : https://www.acmicpc.net/problem/7569

// 목표 : 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다
// 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

class Node {
	int z;
	int y;
	int x;
	
	public Node(int z, int y, int x) {
		this.z = z;
		this.y = y;
		this.x = x;
	}
}

public class Main_7569_토마토 {
	static int box[][][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1, 0, 0}; // 상, 하, 좌, 우, 위, 아래
	static int dirY[] = {-1, 1, 0, 0, 0, 0};
	static int dirZ[] = {0, 0, 0, 0, 1, -1};
	static Queue<Node> que = new LinkedList<>();
	
	static int nowX, nowY, nowZ, N, M, H, count;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_7569.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 5, 3, 2
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수 x
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수 y
		H = Integer.parseInt(st.nextToken()); // 상자의 수 z
		
		boolean zero = false;
		box = new int[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				String str = br.readLine(); 
				st = new StringTokenizer(str);
						
				for(int k=0; k<M; k++) {
					int num = Integer.parseInt(st.nextToken());
					
					if(num == 0) {
						zero = true;
					}
					else if(num == 1) {
						que.offer(new Node(i, j, k));
					}
					
					box[i][j][k] = num;
				}
			}
		}
		
		if(zero == false) {
			System.out.println(0);
			return;
		}
		
		BFS();
		
		int max = Integer.MIN_VALUE / 16;
		for(int num[][] : box) {
			for(int num2[] : num) {						
				for(int num3 : num2) {
					
					if(num3 == 0) {
						System.out.println(-1);
						return;
					}
					
					if(max < num3) {
						max = num3;
					}
				}
			}
		}
		
		System.out.println(max - 1);
		
	} // End of main
	
	static void BFS() {
		count = 0;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for(int i=0; i<6; i++) {
				nowX = node.x + dirX[i];
				nowY = node.y + dirY[i];
				nowZ = node.z + dirZ[i];
				
				if(Range_check() && box[nowZ][nowY][nowX] == 0) {
					box[nowZ][nowY][nowX] = box[node.z][node.y][node.x] + 1;
					que.offer(new Node(nowZ, nowY, nowX));
				}	
			}
		}
	} // End of DFS()
	
	static boolean Range_check() {
		return (nowX < M && nowX >= 0 && nowY < N && nowY >= 0 && nowZ < H && nowZ >= 0);
	} // End of Range_check()
	
} // End of class