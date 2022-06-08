import java.util.*;
import java.io.*;

public class Main_11724_연결요소의개수_BFS {
	static List<ArrayList<Integer>> nearList = new ArrayList<>();
	static boolean node[];
	static int N, count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_11724.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		// node와 인접리스트 생성
		node = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			nearList.add(new ArrayList<>());
		}
	
		while(M-->0) {
 			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 무방향 그래프 인접리스트에 생성
			nearList.get(x).add(y);
			nearList.get(y).add(x);
		}
		
		int count = 0;
		for(int i=1; i<=N; i++) {
			
			if(node[i] == false) {
				BFS(i);
				count ++;
			}
			
		}
		
		System.out.println(count);
		
	} // End of main
	
	static void BFS(int value) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(value);
		
		while( !que.isEmpty() ) {
			int num = que.poll();
			
			int size = nearList.get(num).size();
			
			for(int i=0; i<size; i++) {
				int new_value = nearList.get(num).get(i);
				
				if(node[new_value] == false) {
					que.offer(new_value);
					node[new_value] = true;
				}
			}
			
		}
	} // End of BFS

	
} // End of class