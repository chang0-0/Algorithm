package BOJ_1719;

import java.io.*;
import java.util.*;

public class BOJ_1719_dijk {

    // https://www.acmicpc.net/problem/1719
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] path;
    private static List<List<Edge>> adjList;
    private static final int INF = 1_000_000_1;

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
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1719\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    sb.append('-').append(' ');
                } else {
                    sb.append(path[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pque = new PriorityQueue<>();
        int[] dists = new int[N + 1];
        Arrays.fill(dists, INF);
        boolean[] isVisited = new boolean[N + 1];

        pque.offer(new Edge(start, 0));
        dists[start] = 0;

        while (!pque.isEmpty()) {
            Edge cur = pque.poll();

            if (dists[cur.num] < cur.dist) continue;
            if (isVisited[cur.num]) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {
                if (dists[next.num] > dists[cur.num] + next.dist) {
                    dists[next.num] = dists[cur.num] + next.dist;
                    pque.offer(new Edge(next.num, dists[next.num]));

                    if (start == cur.num) {
                        path[start][next.num] = next.num;
                    } else {
                        path[start][next.num] = path[start][cur.num];
                    }
                }
            }
        }
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        path = new int[N + 1][N + 1];
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
    } // End of input()
} // End of Main class
