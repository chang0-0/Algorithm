import java.util.*;
import java.io.*;

// 첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.

public class Main_10819_차이를최대로 {
	static int N;
	static int arr[];
	static boolean visit[];
	static int ans[];
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10819.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visit = new boolean[N];
		ans = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		DFS(0);
		System.out.println(result);
		
	} // End of main
	
	static void DFS(int depth) {
		
		if(depth == N) {
			int sum = 0;
			
			// 배열의 순서를 변화시켜서 합산을 구해서 최대값 갱신
			for(int i=1; i<N; i++) {
				sum += Math.abs(ans[i-1] - ans[i]);
			}
			
			result = Math.max(result, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			if(visit[i]) continue;
			
			visit[i] = true;
			ans[depth] = arr[i];
			DFS(depth + 1);
			visit[i] = false;
		}

	} // End of DFS

} // End of Main class