package BOJ_23793;

import java.io.*;
import java.util.*;

public class BOJ_23793 {

    // https://www.acmicpc.net/problem/23793
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, X, Y, Z;
    private static List<List<Edge>> adjList;
    private static final int INF = Integer.MAX_VALUE;

    private static class Edge implements Comparable<Edge> {
        int num;
        int dist;

        private Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_23793\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // X -> Y -> Z
        int prev = dijkstra(X, Y, 0);
        int post = dijkstra(Y, Z, 0);

        if (prev == -1 || post == -1) {
            sb.append(-1).append(' ');
        } else {
            sb.append(prev + post).append(' ');
        }

        sb.append(dijkstra(X, Z, Y));
        return sb.toString();
    } // End of solve()

    private static int dijkstra(int start, int dest, int stopover) {
        PriorityQueue<Edge> pque = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        pque.offer(new Edge(start, -1));
        dist[start] = 0;
        isVisited[stopover] = true;

        while (!pque.isEmpty()) {
            Edge cur = pque.poll();

            if (cur.num == dest) return cur.dist;

            if (dist[cur.num] < cur.dist) continue;
            if (isVisited[cur.num]) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {

                if (dist[next.num] > dist[cur.num] + next.dist) {
                    dist[next.num] = dist[cur.num] + next.dist;
                    pque.offer(new Edge(next.num, dist[next.num]));
                }
            }
        }

        return -1;
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
