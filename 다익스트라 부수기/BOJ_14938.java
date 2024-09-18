package BOJ_14938;

import java.io.*;
import java.util.*;

public class BOJ_14938 {

    // https://www.acmicpc.net/problem/14938
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, R;
    private static int[] items;
    private static List<List<Edge>> adjList;
    private static final int INF = Integer.MAX_VALUE;

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
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14938\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int dijkstra(int start) {
        int[] dists = new int[N + 1];
        boolean[] isVisited = new boolean[N + 1];
        Arrays.fill(dists, INF);

        PriorityQueue<Edge> pque = new PriorityQueue<>();
        pque.offer(new Edge(start, 0));
        dists[start] = 0;

        while (!pque.isEmpty()) {
            Edge cur = pque.poll();

            if (dists[cur.num] < cur.weight) continue;
            if (isVisited[cur.num]) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {
                if (dists[next.num] > dists[cur.num] + next.weight) {
                    dists[next.num] = dists[cur.num] + next.weight;
                    pque.offer(new Edge(next.num, dists[next.num]));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (dists[i] <= M) {
                sum += items[i];
            }
        }

        return sum;
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Edge(b, c));
            adjList.get(b).add(new Edge(a, c));
        }
    } // End of input()
} // End of Main class
