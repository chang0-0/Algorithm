import java.io.*;

// https://www.acmicpc.net/problem/2447
// N이 27일 경우,
// 3짜리 별모양이 9짜리 별모양을 이루고 9짜리 별모양이 27짜리 별모양을 이룸

// 참고 : https://st-lab.tistory.com/95

public class Main_2447_별_찍기10 {
	static char arr[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2447.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//27은 3의 세제곱
		arr = new char[N][N];
		makeStar(0, 0, N, false);
		
		// 출력.
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		//System.out.println(sb);
	} // End of main
	
	static void print() {
		
		for(int i=0; i<27; i++) {
			for(int j=0; j<27; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	static void makeStar(int x, int y, int N, boolean blank) {
		
		print();
		

		// 공백칸일 경우
		if(blank) {
			for(int i=x; i<x + N; i++) {
				for(int j=y; j<y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		// 공백이 아닐 때, && 더이상 쪼갤 수 없는 블록일 때, 
		// 27 -> 9 -> 3 -> 1로 와서 N이 1일때
		if(N == 1) {
			arr[x][y] = '*';
			return;
		}
		
		// 공백이 아닐 때, 크기를 더 줄일 수 있을 때,
		int size = N / 3;
		int count = 0;
		for(int i=x; i<x + N; i+=size) {
			for(int j=y; j<y + N; j+=size) {
				count ++;
				
				if(count == 5) {
					makeStar(i, j, size, true);
				}
				else {
					makeStar(i, j, size, false);
				}
			}
		}
		
		
	}// End of makeStar
	
} // End of class

// 1. 작은 문제부터 해결해보자
// 3짜리 별 모양부터 만들어 보기