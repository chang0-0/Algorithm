import java.io.*;

public class Main_10989_수정렬하기3_2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10989.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// counting Sort
		// 수의 범위 (0 ~ 10000) 이므로 총 개수 10001개로 배열 생성
		// 하지만 0은 범위에 들어 있지 않으므로 0은 사실상 제외됨
		int count[] = new int[10001];
		for(int i=0; i<N; i++) {
			count[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=1; i<10001; i++) {
			
			while(count[i] > 0) {
				sb.append(i).append('\n');
				count[i]--;
			}
		}
		
		System.out.println(sb);
	}
}
