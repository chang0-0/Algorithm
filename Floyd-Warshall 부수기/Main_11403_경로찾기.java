import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11403
// 목표: 총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 
// 정점 i에서 j로 가는 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.

// 오로지 갈 수 있냐 없냐를 파악하는 문제

public class Main_11403_경로찾기 {
	static StringBuilder sb;
	static int N, M;

	static int arr[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11403.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		floyd();
		
		sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
	} // End of Main
	
	static void floyd() {
		
		// k = 거쳐가는 노드
		for(int k=0; k<N; k++) {
			// i = 출발 노드			
			for(int i=0; i<N; i++) {
				// j = 도착 노드
				for(int j=0; j<N; j++) {
					// (i,k) -> (k, j) -> (k,i) 방향 그래프에서 다른 간선과 노드를 통해
					// 해당 노드로 이동이 가능한 가 를 판별

					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
			
		}
		
	} // End of Find()
} // End of class
