import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/1992
// N은 언제나 제곱수

public class Main_1992_쿼드트리 {
	static int N;
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			char ch[] = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				arr[i][j] = ch[j] - '0';
			}
		}
		
		// 0부터 시작해서 재귀를 통해서 전체 탐색
		solution(0, 0, N);
		bw.write(sb.toString());bw.flush();bw.close();
	} // End of main
	
	private static void solution(int x, int y, int size) {
		if(checkPossibility(x, y, size)) { // 압축이 가능할 경우. 곧바로 해당 값을 출력
			sb.append(arr[x][y]);
			return;
		}
		
		// 압축이 불가능 할 경우 작은 사이로 다시 새로운 사이즈를 정의
		int newSize = size / 2; // 현재 사이즈에서 1 0으로 분리가 안될 경우 다시 압축
		sb.append('('); // 사이즈가 수정 될 경우 ( 를 앞에 생성
		
		solution(x, y, newSize);
		solution(x, y + newSize, newSize);
		solution(x + newSize, y, newSize);
		solution(x + newSize, y + newSize, newSize);
		sb.append(')'); // 괄호 닫기
	} // End of solution
	
	private static boolean checkPossibility(int x, int y, int size) {
		int value = arr[x][y];
		
		for(int i=x; i<x + size; i++) {
			for(int j=y; j<y + size; j++) {
				// 하나라도 다른 값이 나오게되면 곧바로 false를 return
				if(value != arr[i][j]) return false;
			}
		}
		return true;
	} // End of checkPossibility
} // End of Main class