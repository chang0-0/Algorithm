import java.util.*;
import java.io.*;

public class Main_2805_나무자르기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Long> treeList = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			treeList.add(Long.parseLong(st.nextToken()));
		}
		
		// 최대 높이 이진 탐색.
		long min = 0;
		long max = Collections.max(treeList);
		long result = 0;
		
		result = binary_search(M, min, max, treeList);
		System.out.println(result);
	}
	
	// 이진 탐색.
	private static long binary_search(int M, long min, long max, List<Long> list) {
				
		long mid = 0;
		while(min <= max) {
			long sum = 0;

			for(long tree : list) {
				if(tree >= mid) {
					sum += tree - mid;					
				}	
			}

			// 잘라진 나무 길이의 합이 M보다 크거나 같은 경우
			// 너무 길게 잘림 -> 절단기의 높이가 낮음을 의미하므로 높이를 더 높여야 함.
			if(sum >= M) {
				min = mid + 1;
			}
			// 잘라진 나무 길이의 합이 M보다 작을 경우
			// 너무 짧게 잘림 -> 절단기의 높이가 높음을 의미하므로 높이를 낮춰야 함.
			else {
				max = mid - 1;
			}
			
			// mid값이 결국 우리가 찾는 절단기에 설정할 수 있는 높이의 최댓값
			mid = (max + min)/2;
			
		}
		
		return mid;
		
	} // End Main
	
} // End Class
