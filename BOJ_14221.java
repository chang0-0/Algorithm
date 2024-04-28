package BOJ_14221;

import java.io.*;
import java.util.*;

public class BOJ_14221 {

    // https://www.acmicpc.net/problem/14221
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, M, P, Q, min, ans;
    private static List<List<Edge>> adjList;
    private static int[] candidateHomes;
    private static List<Integer> convs;

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
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14221\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        dijkstra();

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void dijkstra() {
        PriorityQueue<Edge> pque = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        boolean[] isVisited = new boolean[N + 1];

        for (int i = 0; i < Q; i++) {
            int num = convs.get(i);
            pque.offer(new Edge(num, 0));
            dist[num] = 0;
        }

        int minDist = INF;

        while (!pque.isEmpty()) {
            Edge cur = pque.poll();

//            if (convs.contains(cur.num)) {
//                minDist = Math.min(minDist, dist[cur.num]);
//            }

            if (isVisited[cur.num]) continue;
            if (dist[cur.num] < cur.dist) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {
                if (dist[next.num] > dist[cur.num] + next.dist) {
                    dist[next.num] = dist[cur.num] + next.dist;
                    pque.offer(new Edge(next.num, dist[next.num]));
                }
            }
        }

        System.out.println(Arrays.toString(dist));

    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = INF;

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
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        candidateHomes = new int[P];
        // convs = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            candidateHomes[i] = Integer.parseInt(st.nextToken());
        }

        convs = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            // convs[i] = Integer.parseInt(st.nextToken());
            convs.add(Integer.parseInt(st.nextToken()));
        }
    } // End of input()
} // End of Main class
