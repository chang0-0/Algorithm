import java.util.*;
import java.io.*;

//목표: ‘땅 고르기’ 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하시오.

// 우리의 목적은 이 집터 내의 땅의 높이를 일정하게 바꾸는 것이다
// 1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
// 2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.

public class Main_18111_마인크래프트 {
	static int arr[][];
	static int result[] = new int[2];
	
	static int time = Integer.MAX_VALUE;
	static int height;
	static int block;
	static int N, M, B;
		
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_18111.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		B = Integer.parseInt(st.nextToken()); // 가지고있는 블록의 갯수
		
		arr = new int [N][M];		
		int max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				max = Math.max(max, arr[i][j]);
			}
		}
		
		brute_force(max);
		
		System.out.println(time + " " + height);
	}
	
	static void brute_force(int max) {
		
		// arr전체를 탐색해서 각 블럭의 갯수를 맞춰보며, 시간을 계산
		// 각 시간의 최소값으로 갱신.
		for(int i=0; i<=max; i++) {
			result = excavation(i); 
			
			if(time > result[0]) {
				time = result[0];
				height = result[1];
			}
			// 시간이 같을 경우, 높이가 더 높은것을 채택한다.
			else if(time == result[0] && height < result[1]) {
				time = result[0];
				height = result[1];
			}
			
		}
	} // End of brute_force()
	
	// 시간 높이 배열로 반환 
	static int[] excavation(int height) {
		int block = B;
		int time = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int value = arr[i][j];
				
				if(value == height) {
					continue;
				}
				
				// 맞추려는 높이가 더 낮은 경우
				// 블럭을 깎아야 하는 경우
				if(value > height) {
					// 블럭을 파내고, 인벤에 넣는 시간 2초
					time += (value - height)*2;
					block += (value - height);
				}
				// value기준으로 맞추려고 하는 높이(height)가 더 높은 경우
				// 즉, 블럭을 쌓아야하는 경우
				else {
					time += height - value;
					block -= (height - value);
				}
			}
		}
		
		// 남은 블럭의 갯수가 0 미만이면 불가능으로 판단. 최고치를 반환.
		if(block < 0) {
			result[0] = 999999999;
			return result;
		}
		
		result[0] = time;
		result[1] = height;
		
		return result;
	}
	
} // End of class
