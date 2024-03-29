package BOJ_17835;

import java.io.*;
import java.util.*;

public class BOJ_17835 {

    // https://www.acmicpc.net/problem/17835
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K;
    private static List<List<Edge>> adjList;
    private static final long INF = Long.MAX_VALUE;
    private static long[] dist;
    private static PriorityQueue<Edge> pque;

    private static class Edge implements Comparable<Edge> {
        int num;
        long dist;

        private Edge(int num, long dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(dist, o.dist);
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17835\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        long maxDist = 0;
        int ansNum = 0;

        dijkstra();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == INF || dist[i] == 0) continue;

            if (maxDist < dist[i]) {
                maxDist = dist[i];
                ansNum = i;
            }
        }

        sb.append(ansNum).append('\n').append(maxDist);
        return sb.toString();
    } // End of solve()

    private static long[] dijkstra() {
        boolean[] isVisited = new boolean[N + 1];

        while (!pque.isEmpty()) {
            Edge current = pque.poll();

            if (isVisited[current.num]) continue;
            if (dist[current.num] < current.dist) continue;
            isVisited[current.num] = true;

            for (Edge next : adjList.get(current.num)) {
                if (dist[next.num] > dist[current.num] + next.dist) {
                    dist[next.num] = dist[current.num] + next.dist;
                    pque.offer(new Edge(next.num, dist[next.num]));
                }
            }
        }

        return dist;
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 수
        M = Integer.parseInt(st.nextToken()); // 도로의 수
        K = Integer.parseInt(st.nextToken()); // 면접장의 수

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(v).add(new Edge(u, c));
        }

        pque = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int temp = Integer.parseInt(st.nextToken());
            dist[temp] = 0;
            pque.offer(new Edge(temp, 0));
        }
    } // End of input()
} // End of Main class
