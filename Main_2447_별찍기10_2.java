import java.io.*;

// StringBuilder 보다 BufferedWriter가 훨씬 더 효율적이고 시간이 잘 나옴.

public class Main_2447_별찍기10_2 {
		static char arr[][];
		
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2447.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		makeStar(0, 0, N, false);
		
		// 출력 
		for(int i=0; i<N; i++) {
			bw.write(arr[i]);
			bw.write('\n');
		}
				
		// BufferedWriter 출력
		bw.flush();
		bw.close();
		
	} // End of main
	
	static void makeStar(int x, int y, int N, boolean blank) {

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