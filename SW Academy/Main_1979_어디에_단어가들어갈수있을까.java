import java.util.*;
import java.io.*;

// 주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램을 작성하라.
// 퍼즐의 각 셀 중, 흰색 부분은 1, 검은색 부분은 0 으로 주어진다.

public class Main_1979_어디에_단어가들어갈수있을까 {
	static int arr[][];
	static int N, K;

	// 배열을 분리 한다.
	// 돌려서 가로로 봤을때 길이가 K와 같은 값이 있는 지 찾는다.
	// 다시 돌려서 세로로 세아렸을 때, 길이가 K와 같은게 있는지 찾는다.
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(' ');
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 가로 세로의 길이
			K = Integer.parseInt(st.nextToken()); // 단어의 길이
			arr = new int[N][N];
			int result = 0;
			int rowCount = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				rowCount = 0;
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num;
					
					if(num == 1) rowCount++;
					else{
						if(rowCount == K) result++;
						rowCount = 0;
					}
				}
				if(rowCount == K) result++; // 줄이 바뀌고 난 후 다음 값도 1일 경우, 마지막 값을 계산해야 됨
			}
		
			result += find_column();
			sb.append(result).append('\n');
		}
		 
		bw.write(sb.toString()); bw.flush(); bw.close();
	} // End of main
	
	private static int find_column() {
		int colCount = 0;
		int result = 0;
		for(int i=0; i<N; i++) {
			colCount = 0;
			for(int j=0; j<N; j++) {
				int num = arr[j][i];
				
				if(num == 1) colCount ++;
				else {
					if(colCount == K) result++;
					colCount = 0;
				}
			}
			if(colCount == K) result++;
		}
		
		return result;
	} // End of find_column
} // End of main