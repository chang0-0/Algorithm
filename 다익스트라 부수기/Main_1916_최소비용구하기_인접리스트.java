import java.util.*;
import java.io.*;

// 문제 : https://www.acmicpc.net/problem/1916
// A -> B로가는 최소비용을 출력하라.

public class Main_1916_최소비용구하기_인접리스트 {
	private static final int INF = Integer.MAX_VALUE / 16;
	static List<ArrayList<Node>> list;
	static int dist[];
	
	static int N;
	
	static class Node implements Comparable<Node> {
		int nodeNum;
		int weight;
		
		public Node(int nodeNum, int weight) {
			this.nodeNum = nodeNum;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	} // End of Node

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1916.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		
		list = new ArrayList<>();
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());	
			
			list.get(s).add(new Node(d, w));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
			
		System.out.println(dijkstra(start, destination));
		
	} // End of main
	
	static int dijkstra(int start, int destination) {
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		boolean visit[] = new boolean[N + 1];
		
		dist[start] = 0;
		que.offer(new Node(start, 0));
		
		while( !que.isEmpty() ) {
			Node queNode = que.poll();
			int start_nodeNum = queNode.nodeNum;
			
			if( !visit[start_nodeNum] ) {
				visit[start_nodeNum] = true;
				
				// start_nodeNum에서 갈 수 있는 곳들을 인접리스트를 통해서 탐색.
				for(Node node : list.get(start_nodeNum)) {
					
					// 기존에 있던 dist값이 새로운 dist값 보다 작을 경우. -> 최소값으로 갱신
					if( !visit[node.nodeNum] && dist[node.nodeNum] > (dist[start_nodeNum] + node.weight) ) {
						dist[node.nodeNum] = dist[start_nodeNum] + node.weight;
						que.offer(new Node(node.nodeNum, dist[node.nodeNum]));
					}
				}
			}
		}
		
		return dist[destination];
	} // End of dijkstra

} // End of Main class