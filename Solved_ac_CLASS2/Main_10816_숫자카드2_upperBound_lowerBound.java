import java.util.*;
import java.io.*;

public class Main_10816_숫자카드2_upperBound_lowerBound {
	static final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
	static final List<Integer> nlist = new ArrayList<>();
	
	private static int upperBound(int num) {
		int min = 0;
		int max = nlist.size();
		
		// min과 max가 같아질 때 까지 반복
		// 같아지면 중지
		while(min < max) {
			int half = (min + max) / 2;
			
			// num값이 중간 위치의 값보다 작을 경우
			// 중앙값이 찾는 값 보다 무조건 클 경우에만 max 값을 중앙값으로 바꾼다.
			// 찾는 값보다 half가 크면 max로 처리함.
			if(num < nlist.get(half)) {
				max = half;
			}
			// 중복원소의 경우 else에서 처리된다.
			// 중복일 경우 인덱스 범위를 계속 올려서 인덱스를 높임
			
			else {
				min = half + 1;
			}
		}

		return min;
	}
	
	private static int lowerBound(int num) {
		int min = 0;
		int max = nlist.size();
		
		// min과 max가 같아질 때 까지 반복
		// 같아지면 중지
		while(min < max) {

			int half = (min + max) / 2;
			
			/*
			 *  key 값이 중간 위치의 값보다 작거나 같을 경우 
			 *  (중복 원소에 대해 왼쪽으로 탐색하도록 상한을 내린다.)
			 */
			
			// 중앙값이 찾는 값 보다 같기만해도 max 값을 중앙값으로 바꾼다.
			// max 값이 중앙값이 되므로 상한값이 자동으로 내려가게됨.
			if(num <= nlist.get(half)) {
				max = half;
			}
			else {
				min = half + 1;
			}
		}

		return min;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_10816.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nlist.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(nlist);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());			
			
			sb.append((upperBound(num) - lowerBound(num))   + " ");
		}
				
		System.out.println(sb);
	}
}
