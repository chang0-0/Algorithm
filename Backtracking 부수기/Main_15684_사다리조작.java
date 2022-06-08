import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15684

// 문제 풀이 : 2차원 배열형태로 사다리의 선을 표현함 1은 우측으로 이동을 의미하고 2는 좌측으로 이동을 의미함으로써
// 사다리가 어떻게 표현되는지 배열로 나타낼 수 있음

// '입력으로 주어지는 가로선이 서로 연속하는 경우는 없다' 라는 조건이 있기 때문에 
// 사다리2차원 배열에서 1과 2가 겹치는 조건은 생각하지 않아도 됨

public class Main_15684_사다리조작 {
	static int N, M, H, ans;
	static boolean visit[][];
	static int arr[][];
	static boolean finish = false;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15684.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 사다리 선의 수
		H = Integer.parseInt(st.nextToken()); // 가로
		arr = new int[H+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1; // 우측으로 이동
			arr[x][y+1] = 2; // 좌측으로 이동
		}
		
		// 최대 추가할 수 있는 가로선의 수 = 3
		// ans = 0 은 사다리를 하나도 추가하지 않고도 가능한지를 파악함.
		for(int i=0; i<=3; i++) {
			ans = i; // 필요한 사다리의 개수			
			DFS(1, 0);
			if(finish) break;
		}
		
		System.out.println(finish ? ans : -1);
	} // End of main
	
	static void DFS(int x, int depth) {
		
		// 재귀 탈출 조건
		if(finish) return;
		// 재귀 탈출 조건
		if(ans == depth) {
			if(check()) {
				finish = true;
			}
			return;
		}
		
		for(int i=x; i<H+1; i++) {
			for(int j=1; j<N; j++) {
				
				if(arr[i][j] == 0 && arr[i][j + 1] == 0) {
					arr[i][j] = 1;
					arr[i][j+1] = 2;
					
					DFS(i, depth+1);
					
					// 가로선 백트래킹
					arr[i][j] = 0;
					arr[i][j+1] = 0;
				}
			}
		}
		
	} // End of DFS
	
	// 현재 만들어진 가로선으로 정답이 되는지 확인
	static boolean check() {
		for(int i=1; i<=N; i++) {
			int x = 1, y = i;
			
			// 높이만큼 반복
			for(int j=0; j<H; j++) {
				if(arr[x][y] == 1) { // 1이면 우측으로 가기때문에 y를 1증가시킴
					y++;
				}
				else if(arr[x][y] == 2) { // 2이면 좌측으로 가기때문에 y를 1감소시킴
					y--;
				}
				x++; // 다음 행으로 넘어감
			}
			
			if(y != i) return false; // 마지막에 출발지점 i와 도착지 y의 값이 다를 경우 false
			// 곧바로 종료
		}
		
		return true;
	} // End of check
	
} // End of Main class