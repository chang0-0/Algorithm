import java.util.*;
import java.io.*;

// 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 
// 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.
// 첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.
// 0은 빈 칸, 1은 집, 2는 치킨집을 의미

public class Main_15686_치킨배달 {
	static int N, M;
	static int result = Integer.MAX_VALUE;
	
	static int arr[][];
	static boolean visit[];
	static List<Node> houseList = new ArrayList<>();
	static List<Node> chickenList = new ArrayList<>();
	static int csize;
	static int hsize;
	
	static class Node {
		int x;
		int y;

		public Node(int x, int y, boolean bol) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 2) {
					chickenList.add(new Node(i, j, false));
				}
				else if(num == 1) {
					houseList.add(new Node(i, j, false));
				}
				arr[i][j] = num;
			}
		}
		
		csize = chickenList.size();
		hsize = houseList.size();
		
		// 치킨집의 개수만큼 방문여부를 확인하는 배열을 생성함
		visit = new boolean[csize];
		DFS(0, 0);
		
		System.out.println(result);
	} // End of main
	
	static void DFS(int index, int depth) {
		
		// 재귀 탈출 조건
		if(depth == M) {
			int sum = 0;
			
			// 집의 위치에 따라 각 치킨집까지의 거리값을 계산해서
			// 최소값을 구해서 temp에 저장후 sum에 각 거리 최소합의 누적합을 구하기
			for(int i=0; i<hsize; i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j=0; j<csize; j++) {
					
					// 남아있는 치킨집일 경우.
					if(visit[j]) {
						if(temp == 1) continue;

						int dist = Math.abs(houseList.get(i).x - chickenList.get(j).x) + Math.abs(houseList.get(i).y - chickenList.get(j).y);                                 
						temp = Math.min(temp,  dist);
					}
				}
				sum += temp;
			}
			
			result = Math.min(result, sum);
			return;
		}
		
		for(int i=index; i<csize; i++) {
			visit[i] = true;
			DFS(i+1, depth+1);
			visit[i] = false;
		}
		
	} // End of DFS	
} // End of Main class