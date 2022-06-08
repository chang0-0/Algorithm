import java.util.*;
import java.io.*;

public class Main_2178_미로탐색_BFS2 {
	  static int n, m;
	  static int[] dx = {0, 0, -1, 1}; //상우하좌
	  static int[] dy = {-1, 1, 0, 0};
	  static int[][] maze; //미로
	  static boolean[][] visit;
	  static int now_x;
	  static int now_y;
	  
	  public static void main(String[] args) throws IOException {
		  System.setIn(new FileInputStream("res/input_bj_2178.txt"));
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st = new StringTokenizer(br.readLine());
		
		  n = Integer.parseInt(st.nextToken()); // 세로
		  m = Integer.parseInt(st.nextToken()); // 가로
		  maze = new int[n][m];
		  visit = new boolean[n][m];
		  
		  for(int i=0; i<n; i++) {
				String str = br.readLine();
				
				for(int j=0; j<m; j++) {
					char ch = str.charAt(j);
					maze[i][j] = Character.getNumericValue(ch);
				}
			}
		  
		  BFS();
		  System.out.print(maze[n - 1][m - 1]); //(N, M) 출력. 좌표값이기 때문에 -1
	  }
	  
	  
	  public static void BFS() {
	    Queue<Integer> queue_x = new LinkedList<Integer>(); //x값에 대한 Queue
	    Queue<Integer> queue_y = new LinkedList<Integer>(); //y값에 대한 Queue
	    
	    queue_x.offer(0);
	    queue_y.offer(0);
	    
	    visit[0][0] = true;
	    while(!queue_x.isEmpty()) {
	      int x = queue_x.poll();
	      int y = queue_y.poll();
	      
	      //상하좌우 확인
	      for(int i = 0; i < 4; i++) {
	        now_x = x + dx[i];
	        now_y = y + dy[i];
	        
	          if( Range_check() && maze[now_y][now_x] == 1 && visit[now_y][now_x] == false) {
	            queue_x.offer(now_x);
	            queue_y.offer(now_y);
	            visit[now_y][now_x] = true;

	            maze[now_y][now_x] = maze[y][x] + 1; //이동횟수
	          }
	          
	        }
	      } // End of while

	  }
	  
	// 범위 체크
		public static boolean Range_check() {
			return (now_x >= 0 && now_x < m && now_y >= 0 && now_y < n);
		} // End of Range_check	
		
		
} // End of class