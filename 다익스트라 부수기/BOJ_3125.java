package BOJ_3125;

import java.io.*;
import java.util.*;

public class BOJ_3125 {

    // https://www.acmicpc.net/problem/3125
    // input
    private static BufferedReader br;

    // variables
    private static final String POINT = "%.6f";
    private static final int INF = Integer.MAX_VALUE;
    private static int N;
    private static double[][] dists;
    private static Coordinate[] sparkCoors;
    private static List<List<Integer>> adjList;

    private static class Coordinate {
        int x;
        int y;
        int arrowCount;

        private Coordinate(int x, int y, int arrow) {
            this.x = x;
            this.y = y;
            this.arrowCount = arrow;
        }
    } // End of Coordinate class

    private static class Node implements Comparable<Node> {
        int num;
        double dist;

        private Node(int num, double dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(dist, o.dist);
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3125\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int ar = Integer.parseInt(st.nextToken());

            sparkCoors[i + 1] = new Coordinate(x, y, ar);
            for (int j = 0; j < N - 1; j++) {
                int next = Integer.parseInt(st.nextToken());
                adjList.get(i + 1).add(next);
            }
        }

        // 각 스파크별 거리미리 계산
        for (int i = 1; i <= N; i++) {
            Coordinate temp = sparkCoors[i];

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                Coordinate temp2 = sparkCoors[j];
                dists[i][j] = distCalc(temp.x, temp.y, temp2.x, temp2.y);
            }
        }

        // 다익스트라
        double[] dist = dijkstra(1);
        for (int i = 1; i <= N; i++) {
            String format = String.format(POINT, dist[i]);
            sb.append(format).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static double[] dijkstra(int start) {
        PriorityQueue<Node> pque = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        double[] dist = new double[N + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pque.offer(new Node(start, 0));

        while (!pque.isEmpty()) {
            Node current = pque.poll();

            if (isVisited[current.num]) continue;
            if (dist[current.num] < current.dist) continue;
            isVisited[current.num] = true;
            dist[current.num] = current.dist;

            int ar = sparkCoors[current.num].arrowCount;

            for (int next : adjList.get(current.num)) {
                if (ar == 0) break; // 남은 화살이 없으면 진행할 수 없음
                if (isVisited[next]) continue;

                double time = dists[current.num][next];
                if (dist[next] <= dist[current.num] + time) continue;

                pque.offer(new Node(next, dist[current.num] + time));
                ar--;
            }
        }

        return dist;
    } // End of dijkstra()

    private static double distCalc(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    } // End of distCalc()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        sparkCoors = new Coordinate[N + 1];
        adjList = new ArrayList<>();
        dists = new double[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
    } // End of input()
} // End of Main class
