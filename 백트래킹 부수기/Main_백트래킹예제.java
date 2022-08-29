import java.util.*;

public class Main_백트래킹예제 {
	static String target;
	static String[] arr = {"A", "B", "C", "D"};
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;
	static LinkedList<String> list = new LinkedList<>();
	
	public static void main(String[] args) {
		target = "D";
		visit = new boolean[4];

		// target인 D까지 갈 수 있는 최소한의 값을 구하여라
		DFS(arr[0], 0);
		
		System.out.println("최종 정답 : " + result);
	} // End of main
	
	static void DFS(String begin, int count) {
		System.out.println("재귀 실행 DFS(" + begin + ", " + count + ")");
		
		if(begin == target) {
			result = Math.min(result, count);
			System.out.println("result : " + result);
			System.out.println( "List : " + list);
			System.out.println("\n");
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			
			if(visit[i]) continue;
			
			list.add(arr[i] );
			visit[i] = true;
			DFS(arr[i], count + 1);
			System.out.println("재귀 탈출 현재 DFS(" + arr[i] + ", " + count + ")");
			visit[i] = false;
			list.pollLast();
		}
		
		
	} // End of DFS
} // End of main