import java.util.*;
import java.io.*;

class Solution {
    private static int N, src, dst, K;
    private static List<List<Edge>> adjList;
    private static final int INF = Integer.MAX_VALUE / 2;

    private static class Edge implements Comparable<Edge> {
        int num;
        int dist;
        int cnt;

        private Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        private Edge(int num, int dist, int cnt) {
            this.num = num;
            this.dist = dist;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(dist, o.dist);
        }

        @Override
        public String toString() {
            return "Edge{" + num + ", " + dist + ", " + cnt + "}";
        }
    } // End of Edge class

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        N = n;
        K = k;

        adjList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            adjList.add(new ArrayList<>());
        }

        int len = flights.length;
        for(int i=0; i<len; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int dist = flights[i][2];

            adjList.get(from).add(new Edge(to, dist));
        }
    
        int ans = dijkstra(src, dst);
        if(ans == INF) return -1;
        return ans;
    } // End of main()

    private static int dijkstra(int src, int dst) {
        int[][] dist = new int[N][K + 2];
        for(int i=0; i<N; i++) {
            Arrays.fill(dist[i], INF);
        }
        
        Queue<Edge> que = new PriorityQueue<>();
        que.offer(new Edge(src, 0, K + 1));
        dist[src][K + 1] = 0;
        
        while(!que.isEmpty()) {
            Edge cur = que.poll();   


            if(cur.num == dst) {
                // 최단거리 바로 return
                return dist[dst][cur.cnt];
            }
            if(dist[cur.num][cur.cnt] < cur.dist) continue;
            if(cur.cnt == 0) continue;

            for(Edge next : adjList.get(cur.num)) {
                int nextCnt = cur.cnt - 1;
                int nextDist = dist[cur.num][cur.cnt] + next.dist;

                if(dist[next.num][nextCnt] > nextDist) {
                    dist[next.num][nextCnt] = nextDist;
                    que.offer(new Edge(next.num, dist[next.num][nextCnt], nextCnt));
                }             
            }
        }
        

        return INF;
    } // End of dijkstra()
} // End of Main class