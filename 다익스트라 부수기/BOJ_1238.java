package BOJ_1238;

import java.io.*;
import java.util.*;

public class BOJ_1238 {

    // https://www.acmicpc.net/problem/1238
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, X;
    private static List<List<Edge>> goList, backList;
    private static final int INF = Integer.MAX_VALUE / 2;


    private static class Edge implements Comparable<Edge> {
        int num;
        int weight;

        private Edge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1238\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] ret = dijkstra(goList);
        int[] ret2 = dijkstra(backList);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, ret[i] + ret2[i]);
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int[] dijkstra(List<List<Edge>> adjList) {
        int[] dists = new int[N + 1];
        Arrays.fill(dists, INF);
        PriorityQueue<Edge> que = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];

        que.offer(new Edge(X, 0));
        dists[X] = 0;

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            if (isVisited[cur.num]) continue;
            if (dists[cur.num] < cur.weight) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {
                if (dists[next.num] > dists[cur.num] + next.weight) {
                    dists[next.num] = dists[cur.num] + next.weight;
                    que.offer(new Edge(next.num, dists[next.num]));
                }
            }
            isVisited[cur.num] = true;
        }


        return dists;
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        goList = new ArrayList<>();
        backList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            goList.add(new ArrayList<>());
            backList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            goList.get(u).add(new Edge(v, w));
            backList.get(v).add(new Edge(u, w));
        }
    } // End of input()
} // End of Main class
