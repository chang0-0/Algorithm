package BOJ_14282;

import java.io.*;
import java.util.*;

public class BOJ_14282 {

    // https://www.acmicpc.net/problem/14284
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, S, T;
    private static List<List<Edge>> adjList;

    private static final int INF = Integer.MAX_VALUE;

    private static class Edge implements Comparable<Edge> {
        int num;
        int dist;

        private Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        } // End of Edge()

        @Override
        public String toString() {
            return "Edge {" + num + ", " + dist + "} \n";
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14282\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(dijkstra());
        return sb.toString();
    } // End of solve()

    private static int dijkstra() {
        PriorityQueue<Edge> que = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        que.offer(new Edge(S, 0));
        dist[S] = 0;

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            if (cur.num == T) {
                return cur.dist;
            }

            if (dist[cur.num] < cur.dist || isVisited[cur.num]) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {
                if (dist[next.num] > dist[cur.num] + next.dist) {
                    dist[next.num] = dist[cur.num] + next.dist;
                    que.offer(new Edge(next.num, dist[next.num]));
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
            adjList.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
