package BOJ_5590;

import java.io.*;
import java.util.*;

public class BOJ_5590 {

    // https://www.acmicpc.net/problem/5590
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, K;
    private static List<List<Node>> adjList;

    private static class Node implements Comparable<Node> {
        int num;
        int cost;

        private Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5590\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                // 운항정보 입력
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                adjList.get(c).add(new Node(d, e));
                adjList.get(d).add(new Node(c, e));
            } else {
                // 운송
                int ret = dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

                if (ret == INF) {
                    sb.append(-1);
                } else {
                    sb.append(ret);
                }
                sb.append('\n');
            }
        }

        return sb.toString();
    } // End of solve()

    private static int dijkstra(int start, int dest) {
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        PriorityQueue<Node> pQue = new PriorityQueue<>();

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pQue.offer(new Node(start, 0));

        while (!pQue.isEmpty()) {
            Node current = pQue.poll();

            if (dist[current.num] > current.cost) continue;
            if (isVisited[current.num]) continue;
            isVisited[current.num] = true;

            for (Node next : adjList.get(current.num)) {
                if (dist[next.num] > dist[current.num] + next.cost) {
                    dist[next.num] = dist[current.num] + next.cost;
                    pQue.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

        return dist[dest];
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
    } // End of input()
} // End of Main class
