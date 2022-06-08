import java.util.*;
import java.io.*;

public class Main_1916_최소비용구하기_인접행렬{
	final static int  INF = Integer.MAX_VALUE / 16;
	static int N, M;
	static ArrayList<ArrayList<Node>> list; 	// 인접리스트 생성
	static int dist[]; // 각 정점으로 가는 최단거리를 저장하는 배열
	static boolean check[]; // 방문 여부를 확인하는 배열
	
	// 인접리스트를 위한 Node class 생성
	static class Node implements Comparable<Node> {
		int nodeNum;
		int weight;
		
		public Node(int nodeNum, int weight) {
			this.nodeNum = nodeNum;
			this.weight = weight;
		}

		// 우선순위 큐의 자동정렬
		// 정렬 기준은 가중치를 기준으로 가중치가 낮은 값을 선택함.
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
		
	} // End of Node class

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1916.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시(노드)의 개수
		M = Integer.parseInt(br.readLine()); // 버스(간선)의 개수
		
		// 인접리스트 생성
		list = new ArrayList<>();
		dist = new int[N + 1];
		check = new boolean[N + 1];
		
		Arrays.fill(dist, INF);
		
		// 노드 번호 만큼 인접리스트를 생성해서 초기화 함.
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// x에서 y로 가는 곳 까지의 비용을 list(x)에 모두 저장
			list.get(x).add(new Node(y, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
		
		int result = dijkstra(start, destination);
		System.out.println(result);
		
	} // End of main
	
	
	// 다익스트라 알고리즘
	private static int dijkstra(int start, int destination) {
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		boolean check[] = new boolean[N + 1];
		que.offer(new Node(start, 0));
		dist[start] = 0;
		
		while( !que.isEmpty() ) { 
			Node node = que.poll();
			int end = node.nodeNum;
			
			if(!check[end]) {
				check[end] = true;
				
				for(Node node2 : list.get(end)) {
					
					// 기존의 거리비용이 새로운 거리비용보다 클 경우 갱신을 해야됨.
					if(!check[node2.nodeNum] && dist[node2.nodeNum] > (dist[end] + node2.weight) ) {
						dist[node2.nodeNum] = dist[end] + node2.weight;
						que.offer(new Node(node2.nodeNum, dist[node2.nodeNum]));
					}
					
				}
			}
		}
		
		
		return dist[destination];
	} // End of dijkstra

} // End of Main class