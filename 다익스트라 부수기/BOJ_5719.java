package BOJ_5719;

import java.io.*;
import java.util.*;

public class BOJ_5719 {

    // https://www.acmicpc.net/problem/5719
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, S, D;
    private static List<List<Edge>> adjList;
    private static List<List<Integer>> pathList;
    private static final int INF = Integer.MAX_VALUE;
    private static boolean[][] isShortPath;

    private static int[] path;


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

        @Override
        public String toString() {
            return "Edge{" +
                    "num=" + num +
                    ", dist=" + dist +
                    '}';
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5719\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (; ; ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            input();
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        /*
            단방향 그래프,
         */

        int ret = dijkstra(S);

        if (ret == INF) {
            sb.append(-1).append('\n');
            return sb.toString();
        }

        int result = dijkstra(S);
        if (result == INF) {
            sb.append(-1);
        } else {
            sb.append(result);
        }

        sb.append('\n');

        return sb.toString();
    } // End of solve()


    private static int dijkstra(int start) {
        PriorityQueue<Edge> que = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, INF);

        que.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            if (dist[cur.num] < cur.dist) continue;
            if (isVisited[cur.num]) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {
                if (isShortPath[cur.num][next.num]) continue;

                int nextMove = dist[cur.num] + next.dist;

                if (dist[next.num] == nextMove) {
                    // 기존 최단 경로와 같을 경우 경로에 추가만 한다.
                    pathList.get(next.num).add(cur.num);
                } else if (dist[next.num] > nextMove) {
                    // 최단 경로가 갱신 될 경우
                    // 기존경로를 제거하고 새로운 경로로 추가함
                    pathList.get(next.num).clear();
                    pathList.get(next.num).add(cur.num);
                    dist[next.num] = nextMove;
                    que.offer(new Edge(next.num, nextMove));
                }
            }
        }


        // 각 노드별로 갈 수 있는 경로가 여러개 일 수 있다.
        // 경로 찾아서 갈 수 없는 경로 지우기
        ArrayDeque<Integer> que2 = new ArrayDeque<>();
        for (int node : pathList.get(D)) {
            // node -> D 경로 지우기
            isShortPath[node][D] = true;

            que2.offer(node);
            while (!que2.isEmpty()) {
                int cur = que2.poll();

                for (int next : pathList.get(cur)) {
                    if (isShortPath[next][cur]) continue;
                    isShortPath[next][cur] = true;
                    que2.offer(next);
                }
            }
        }

        return dist[D];
    } // End of dijkstra()

    private static void input() throws IOException {
        adjList = new ArrayList<>();
        pathList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
            pathList.add(new ArrayList<>());
        }

        isShortPath = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Edge(b, c));
        }

    } // End of input()
} // End of Main class
