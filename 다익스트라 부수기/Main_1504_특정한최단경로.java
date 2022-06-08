import java.util.*;
import java.io.*;

// 문제 : https://www.acmicpc.net/problem/1504
// 무방향 그래프.
// 마지막줄에 해당하는 값의 최단 경로를 출력 경로가 없을 때는 -1을 출력

public class Main_1504_특정한최단경로 {
	static final int INF = Integer.MAX_VALUE / 16;
	static ArrayList<ArrayList<Node>> list;
	static int dist[];
	static boolean check[];
	
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
		System.setIn(new FileInputStream("res/input_bj_1504.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		dist = new int[N + 1];
		check = new boolean[N + 1];
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		while(E --> 0) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(x).add(new Node(y, weight));
			list.get(y).add(new Node(x, weight));
		}
		
		st = new StringTokenizer(br.readLine());	
		int must1 = Integer.parseInt(st.nextToken());
		int must2 = Integer.parseInt(st.nextToken());
		
		int res1 =0;
		res1 += dijkstra(1, must1, N);
		res1 += dijkstra(must1, must2, N);
		res1 += dijkstra(must2, N, N);
		
		int res2 = 0;
		res2 += dijkstra(1, must2, N);
		res2 += dijkstra(must2, must1, N);
		res2 += dijkstra(must1, N, N);
		
        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
		
	} // End of main
	
	private static int dijkstra(int start, int destination, int N) {
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.offer(new Node(start, 0));
		dist[start] = 0;
		
		while( !que.isEmpty() ) {
			Node queNode = que.poll();
			int start_nodeNum = queNode.nodeNum;
			
			if( !check[start_nodeNum] ) {
				check[start_nodeNum] = true;
				
				for(Node node : list.get(start_nodeNum)) {
					// 이동하는 곳의 가중치 값이 기존에 있던 곳의 가중치 값과 현재 이동하면서 생긴 가중치 값보다 클 경우.
					if( !check[node.nodeNum] && dist[node.nodeNum] > (dist[start_nodeNum] + node.weight)) {
						dist[node.nodeNum] = dist[start_nodeNum] + node.weight;
						que.offer(new Node(node.nodeNum, dist[node.nodeNum]));
					}
					
				}
			}
		}
		
		return dist[destination];
	} // End of dijkstra(
	
} // End of Main class