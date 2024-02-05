package BOJ_1277;

import java.io.*;
import java.util.*;

public class BOJ_1277 {

    // https://www.acmicpc.net/problem/1277
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N;
    private static List<List<Node>> adjList;

    private static class Node implements Comparable<Node> {
        int num;
        double dist;

        private Node(int num, double dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (dist - o.dist);
        }
    } // End of Coordinate class

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1277\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        double ans = dijkstra() * 1000;

        sb.append((int) ans);
        return sb.toString();
    } // End of solve()

    private static double dijkstra() {
        PriorityQueue<Node> pQue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        double[] dist = new double[N + 1];
        Arrays.fill(dist, INF);


        dist[1] = 0;
        pQue.offer(new Node(1, 0.0));

        while (!pQue.isEmpty()) {
            Node current = pQue.poll();

            if (dist[current.num] < current.dist) continue;
            if (isVisited[current.num]) continue;
            isVisited[current.num] = true;

            for (Node next : adjList.get(current.num)) {

                if (dist[next.num] > dist[current.num] + next.dist) {
                    dist[next.num] = dist[current.num] + next.dist;
                    pQue.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

        return dist[N];
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        double m = Double.parseDouble(br.readLine());
        Coordinate[] powers = new Coordinate[N + 1];
        adjList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            powers[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            adjList.add(new ArrayList<>());
        }
        adjList.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            Coordinate current = powers[i];

            for (int j = i + 1; j <= N; j++) {
                double diff = Math.sqrt(Math.pow(current.x - powers[j].x, 2) + Math.pow(current.y - powers[j].y, 2));
                if (diff > m) continue;

                adjList.get(i).add(new Node(j, diff));
                adjList.get(j).add(new Node(i, diff));
            }
        }


        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b, 0));
            adjList.get(b).add(new Node(a, 0));
        }

    } // End of input()
} // End of Main class
