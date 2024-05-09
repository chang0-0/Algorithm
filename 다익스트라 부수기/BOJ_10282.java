package BOJ_10282;

import java.io.*;
import java.util.*;

public class BOJ_10282 {

    // https://www.acmicpc.net/problem/10282
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, D, C;
    private static List<List<Edge>> adjList;

    private static class Edge implements Comparable<Edge> {
        int num;
        int time;

        private Edge(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return time - o.time;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_10282\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] ret = dijkstra();
        sb.append(ret[0]).append(' ').append(ret[1]).append('\n');
        return sb.toString();
    } // End of solve()

    private static int[] dijkstra() {
        PriorityQueue<Edge> que = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] times = new int[N + 1];
        Arrays.fill(times, INF);

        que.offer(new Edge(C, 0));
        times[C] = 0;
        int count = 0;
        int max = 0;

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            if (isVisited[cur.num]) continue;
            if (times[cur.num] < cur.time) continue;
            isVisited[cur.num] = true;
            count++;
            max = Math.max(max, times[cur.num]);

            for (Edge next : adjList.get(cur.num)) {
                if (times[next.num] > times[cur.num] + next.time) {
                    times[next.num] = times[cur.num] + next.time;
                    que.offer(new Edge(next.num, times[next.num]));
                }
            }
        }

        return new int[]{count, max};
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            adjList.get(b).add(new Edge(a, s));
        }
    } // End of input()
} // End of Main class
