package BOJ_23801;

import java.io.*;
import java.util.*;

public class BOJ_23801 {

    // https://www.acmicpc.net/problem/23801
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, X, Z;
    private static List<List<Edge>> adjList;
    private static final long INF = Long.MAX_VALUE / 4;

    private static class Edge implements Comparable<Edge> {
        int node;
        long weight;

        private Edge(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(weight, o.weight);
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_23801\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        long[] from = dijkstra(X);
        long[] to = dijkstra(Z);

        int p = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = INF;

        while (p-- > 0) {
            int y = Integer.parseInt(st.nextToken());

            if (from[y] != INF && to[y] != INF) {
                ans = Math.min(ans, from[y] + to[y]);
            }
        }


        sb.append(ans == INF ? -1 : ans);
        return sb.toString();
    } // End of solve()

    private static long[] dijkstra(int start) {
        PriorityQueue<Edge> pque = new PriorityQueue<>();
        long[] memo = new long[N + 1];
        Arrays.fill(memo, INF);

        pque.offer(new Edge(start, 0));
        memo[start] = 0;

        while (!pque.isEmpty()) {
            Edge cur = pque.poll();

            if (cur.weight > memo[cur.node]) continue;

            for (Edge next : adjList.get(cur.node)) {
                if (memo[next.node] > memo[cur.node] + next.weight) {
                    memo[next.node] = memo[cur.node] + next.weight;
                    pque.offer(new Edge(next.node, memo[next.node]));
                }
            }
        }

        return memo;
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new Edge(v, w));
            adjList.get(v).add(new Edge(u, w));
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
