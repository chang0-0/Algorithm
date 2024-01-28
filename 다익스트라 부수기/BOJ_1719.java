package BOJ_1719;

import java.io.*;
import java.util.*;

public class BOJ_1719 {

    // https://www.acmicpc.net/problem/1719
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, M;
    private static int[][] ans;
    private static List<List<Node>> adjList;

    private static class Node implements Comparable<Node> {
        int num;
        int time;

        private Node(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }

        @Override
        public String toString() {
            return "Node{" + num + ", " + time + "}";
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1719\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // System.out.println(adjList);

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    sb.append('-');
                } else {
                    sb.append(ans[i][j]);
                }

                sb.append(' ');
            }

            sb.append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void dijkstra(int num) {
        PriorityQueue<Node> pQue = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, INF);
        dist[num] = 0;
        pQue.offer(new Node(num, 0));

        while (!pQue.isEmpty()) {
            Node current = pQue.poll();

            if (dist[current.num] < current.time) continue;
            if (visited[current.num]) continue;
            visited[current.num] = true;

            for (Node next : adjList.get(current.num)) {
                if (dist[next.num] > dist[current.num] + next.time) {
                    dist[next.num] = dist[current.num] + next.time;
                    pQue.offer(new Node(next.num, dist[next.num]));
                    if (num == current.num) {
                        // 이전 노드가 출발 노드 일 경우, 다음 노드 번호를 넣는다.
                        ans[num][next.num] = next.num;
                    } else {
                        // 그 외의 경우 다음 노드에는 이전의 부모 노드 번호를 넣는다. (바로 이전의 거쳐온 곳)
                        ans[num][next.num] = ans[num][current.num];
                    }
                }
            }
        }

    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[N + 1][N + 1];

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b, w));
            adjList.get(b).add(new Node(a, w));
        }
    } // End of input()
} // End of Main class
