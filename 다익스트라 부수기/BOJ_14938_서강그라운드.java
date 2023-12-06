package BOJ_14938;

import java.io.*;
import java.util.*;

public class BOJ_14938_서강그라운드 {
    // https://www.acmicpc.net/problem/14938
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE / 4;
    private static int N, M, R;
    private static int[] items;
    private static List<List<Node>> adjList;

    private static class Node implements Comparable<Node> {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }

        @Override
        public String toString() {
            return "Node{" + "node=" + node + ", dist=" + dist + '}';
        }
    }

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

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (adjList.get(i).isEmpty()) continue;
            max = Math.max(max, dijkstra(i));
        }

        sb.append(max);
        return sb.toString();
    } // End of solve()

    private static int dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));

        boolean[] isVisited = new boolean[N + 1];

        while (!pQ.isEmpty()) {
            Node current = pQ.poll();

            if (dist[current.node] < current.dist) continue;
            if (isVisited[current.node]) continue;
            isVisited[current.node] = true;

            for (Node next : adjList.get(current.node)) {
                if (dist[next.node] > dist[current.node] + next.dist) {
                    dist[next.node] = dist[current.node] + next.dist;
                    pQ.offer(new Node(next.node, dist[next.node]));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
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
            int l = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b, l));
            adjList.get(b).add(new Node(a, l));
        }
    } // End of input()
} // End of Main class
