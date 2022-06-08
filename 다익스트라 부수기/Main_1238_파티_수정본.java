import java.util.*;
import java.io.*;

// 방향 그래프

public class Main_1238_파티_수정본{
	private static final int INF = Integer.MAX_VALUE;
	static List<ArrayList<Node>> list = new ArrayList<>();
	static List<ArrayList<Node>> backlist = new ArrayList<>();
	static int N, M, X;
	
	static class Node implements Comparable<Node> {
		int roadNum; // 도로 번호
		int time; // 시간
		
		public Node(int roadNum, int time) {
			this.roadNum = roadNum;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return time - o.time;
		}

	} // End Node class

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 
		X = Integer.parseInt(st.nextToken()); // 이동 시간
		
		list = new ArrayList<>();
		backlist = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
			backlist.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list.get(n).add(new Node(m, t));
			backlist.get(m).add(new Node(n, t));
		}
		
		// 학생들 중 오고 가는데 가장 오래 걸리는 학생의 소요시간을 출력
		// X까지 갔다가 다시 돌아오는데, 걸리는 시간이 가장 오래 걸리는 학생
		int max = Integer.MIN_VALUE;

		int goResult[] = dijkstra(list);
		int backResult[] = dijkstra(backlist);

		for(int i=1; i<=N; i++) {
			max = Math.max(max,  goResult[i] + backResult[i]);
		}
		
		System.out.println(max);
	} // End of main
	
	
	static int[] dijkstra(List<ArrayList<Node>> list) {
		PriorityQueue<Node> que = new PriorityQueue<>();		
		
		boolean visit[] = new boolean[N + 1];
		int dist[] = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		que.offer(new Node(X, 0));
		
		while( !que.isEmpty() ) {
			Node queNode = que.poll();
			int num = queNode.roadNum;
			
			if(visit[num]) continue;
			
			visit[num] = true;
			for(Node node : list.get(num)) {
				if( !visit[node.roadNum] && dist[node.roadNum] > (dist[num] + node.time)  ) {
					dist[node.roadNum] = dist[num] + node.time;
					que.offer(new Node(node.roadNum, dist[node.roadNum]));
				}
			}
			
		}

		return dist;
	} // End of dijkstra
} // End of Main class