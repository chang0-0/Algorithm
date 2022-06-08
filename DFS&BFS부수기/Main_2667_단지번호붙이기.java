import java.util.*;
import java.io.*;

// 문제 : https://www.acmicpc.net/problem/2667

public class Main_2667_단지번호붙이기 {
	static int arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	
	static int count = 0, number = 0;
	static int nowX, nowY, N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2667.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
		
			for(int j=0; j<N; j++) {				
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(visit[i][j] == false && arr[i][j] == 1) {
					count = 0;
					number++;
					DFS(i, j);	
					list.add(count);
				}
				
			}
		}
			
		Collections.sort(list);
		bw.append(number + "\n");
		for(int num : list) {
			bw.append(num + "\n");
		}
		
		bw.flush();
		bw.close();		
	} // End of main
	
	static void DFS(int x, int y) {
		visit[x][y] = true;
		arr[x][y] = number;
		count ++;
		
		for(int i=0; i<4; i++) {
			nowX = dirX[i] + x;
			nowY = dirY[i] + y;
			
			if(Range_check() && visit[nowX][nowY] == false && arr[nowX][nowY] == 1) {
				visit[nowX][nowY] = true;
				arr[nowX][nowY] = number;
				
				DFS(nowX, nowY);
			}
		}		
		
	} // End of DFS
	
	static boolean Range_check() {
		return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
	} // End of Range_check
	
} // End of class