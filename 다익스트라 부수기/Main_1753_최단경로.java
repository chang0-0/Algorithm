import java.util.*;
import java.io.*;

public class Main_1753_최단경로 {
	static ArrayList<ArrayList<Node>> list;
	
	static final int INF = Integer.MAX_VALUE / 16;
	static int dist[];
	
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
	} // End of Node class
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1753.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		list = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		int start = Integer.parseInt(br.readLine());
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(x).add(new Node(y, w));
		}

		dijkstra(start, N);
		for(int i=1; i<=N; i++) {
			
			if(dist[i] == INF) {
				sb.append("INF\n");
				continue;
			}
			
			sb.append(dist[i]).append('\n');
		}
		
		System.out.println(sb);
		
	} // End of main

	static void dijkstra(int start, int N) {
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		boolean check[] = new boolean[N + 1];
		dist[start] = 0;
		que.offer(new Node(start, 0));
		
		while( !que.isEmpty() ) {
			Node queNode = que.poll();
			int startNum = queNode.nodeNum;
			
			if( !check[startNum] ) {
				check[startNum] = true;
				
				for(Node node : list.get(startNum)) {
					
					if( !check[node.nodeNum] && dist[node.nodeNum] > (dist[startNum] + node.weight) ) {
						dist[node.nodeNum] = dist[startNum] + node.weight;
						que.offer(new Node(node.nodeNum, dist[node.nodeNum]));
					}
				}
				
			}
		}

	} // End of dijkstra
	
} // End of Main class