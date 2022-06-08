import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11404
// 목표 : n개의 줄을 출력해야 한다.
// i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용이다. 
// 만약, i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력한다.

// 연결되는 노드를 파악함과 동시에
// 각 비용의 최소 값을 갱신해서 map에 저장

public class Main_11404_플로이드 {
	static final int INF = 1000000000;
	static int N, M;
	static int x = 0;
	static int y = 0;
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11404.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
				
		// 지도 생성
		// 전체를 일단 -1로 초기화.
		// 나중에 갈 수 없는 곳을 0으로 구분 짓기 위함.
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = INF;
				
				// 자기 자신은 갈 수 없음으로0처리
				if(i == j) {
					map[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			y = Integer.parseInt(st.nextToken()) - 1;
			x = Integer.parseInt(st.nextToken()) - 1;
			int value = Integer.parseInt(st.nextToken());
			
			map[y][x] = Math.min(map[y][x], value);
		}

		Road_Finder();
		
		// 출력
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
            	// 경로 탐색을 마쳤음에도 불구하고
            	// 여전히 value가 100001의 최댓값일 경우 갈 수 없음으로 판단. 0으로 바꿔줌
            	if(map[i][j] == INF) {
            		map[i][j] = 0;
            	}
            	
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
	} // End of Main
	
	static void Road_Finder() {
		// 전체를 탐색하면서 최소비용을 갱신.
		// i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력한다.			
		
		// 거쳐가는 노드 k
		for(int k=0; k<N; k++) {
			// 출발 노드 i
			for(int i=0; i<N; i++) {
				// 도착 노드 j
				for(int j=0; j<N; j++) {
					
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
					
				} // for(j) of End
			} // for(i) of End
		} // for(k) of End
		
	} // End of Find_Road
	
} // End of class
