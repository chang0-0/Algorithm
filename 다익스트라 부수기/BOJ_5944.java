package BOJ_5944;

import java.io.*;
import java.util.*;

public class BOJ_5944 {

    // https://www.acmicpc.net/problem/5944
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int C, P, PB, PA1, PA2;
    private static List<List<Node>> adjList;

    private static class Node implements Comparable<Node> {
        int num;
        int weight;

        private Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5944\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        int ans = 0;
        int[] dist = dijkstra(PB);

        if (dist[PA1] > dist[PA2]) {
            ans += dist[PA2];
            dist = dijkstra(PA2);
            ans += dist[PA1];
        } else {
            ans += dist[PA1];
            dist = dijkstra(PA1);
            ans += dist[PA2];
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int[] dijkstra(int start) {
        PriorityQueue<Node> pQue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[P + 1];
        int[] dist = new int[P + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pQue.offer(new Node(start, 0));

        while (!pQue.isEmpty()) {
            Node current = pQue.poll();

            if (dist[current.num] < current.weight) continue;
            if (isVisited[current.num]) continue;
            isVisited[current.num] = true;

            for (Node next : adjList.get(current.num)) {
                if (dist[next.num] <= dist[current.num] + next.weight) continue;
                dist[next.num] = dist[current.num] + next.weight;
                pQue.offer(new Node(next.num, dist[next.num]));
            }
        }

        return dist;
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        PB = Integer.parseInt(st.nextToken());
        PA1 = Integer.parseInt(st.nextToken());
        PA2 = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= P; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b, c));
            adjList.get(b).add(new Node(a, c));
        }

    } // End of input()
} // End of Main class
