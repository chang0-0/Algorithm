package BOJ_20168;

import java.io.*;
import java.util.*;

public class BOJ_20168 {

    // https://www.acmicpc.net/problem/20168
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, M, A, B, C, ans;
    private static List<List<Node>> adjList;

    private static class Node implements Comparable<Node> {
        int num;
        int weight;
        int maxWeight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        public Node(int num, int weight, int maxWeight) {
            this.num = num;
            this.weight = weight;
            this.maxWeight = maxWeight;
        }

        @Override
        public int compareTo(Node o) {
            return maxWeight - o.maxWeight;
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_20168\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(dijkstra());
        return sb.toString();
    } // End of solve()

    private static long dijkstra() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        boolean[] isVisited = new boolean[N + 1];
        PriorityQueue<Node> pQue = new PriorityQueue<>();

        dist[A] = 0;
        pQue.offer(new Node(A, 0, 0));

        while (!pQue.isEmpty()) {
            Node current = pQue.poll();

            if (current.num == B) {
                ans = Math.min(ans, current.maxWeight);
            }

            if(dist[current.num] > current.weight) continue;
            if (isVisited[current.num]) continue;
            isVisited[current.num] = true;

            for (Node next : adjList.get(current.num)) {
                // 경로상에서 가장 많이 낸 돈
                int maxWeight = Math.max(current.maxWeight, next.weight);

                if (dist[next.num] > maxWeight) {
                    if (current.weight + next.weight <= C) {
                        dist[next.num] = maxWeight;
                        pQue.offer(new Node(next.num, current.weight + next.weight, maxWeight));
                    }
                }
            }
        }

        if (ans == INF) return -1;
        return ans;
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ans = INF;
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b, c));
            adjList.get(b).add(new Node(a, c));
        }

    } // End of input()
} // End of Main class
