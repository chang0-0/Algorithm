import java.io.*;

public class Main_10026_적록색약_DFS {
	static char arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1}; // 상 하 좌 우
	static int dirY[] = {-1, 1, 0, 0};
	
	static int N, nowX, nowY;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int R = 0, G = 0, B = 0, T = 0;
		
		arr = new char[N][N];
		char colors[] = {'R', 'G', 'B', 'T'}; 
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}	
		
		for(int i=0; i<4; i++) {
			int result = 0;
			char color = colors[i];
			visit = new boolean[N][N];

			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					
					if(color == 'T' && !visit[j][k] && (arr[j][k] == 'R' || arr[j][k] == 'G')) {
						DFS(j, k, color);
						result++;
					}	
					else if(!visit[j][k] && arr[j][k] == color) {
						DFS(j, k, color);
						result++;
					}

				}
			}
						
			switch(color) {
				case 'R': R = result;
				break;
				case 'G': G = result;
				break;
				case 'B': B = result;
				break;
				case 'T': T = result;
				break;
			}
		}	
		
		int person1 = R + G + B;
		sb.append(person1 + " ");
		
		int person2 = B + T;
		sb.append(person2);
		
		System.out.println(sb);
	} // End of main
	
	static void DFS(int x, int y, char color) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			nowX = dirX[i] + x;
			nowY = dirY[i] + y;
		
			if(color == 'T') {
				if(range_check() && !visit[nowX][nowY] && (arr[nowX][nowY] == 'R' || arr[nowX][nowY] == 'G')) {
					DFS(nowX, nowY, color);
				}
			}
			else if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == color) {
				DFS(nowX, nowY, color);
			}
		}
		
		
	} // End of BFS
	
	static boolean range_check() {
		return (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N); 	
	} // End range_check

} // End of class