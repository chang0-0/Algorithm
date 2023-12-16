package BOJ_18352;

import java.io.*;
import java.util.*;

public class BOJ_18352_특정_거리의_도시_찾기 {

    // https://www.acmicpc.net/problem/18352
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE / 40;
    private static int N, M, K, X;
    private static List<List<Node>> adjList;

    private static class Node implements Comparable<Node> {
        int num;
        int weight;

        private Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        } // End of Node()

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        } // End of compareTo()

        @Override
        public String toString() {
            return "Node : {num : " + num + ", weight : " + weight + "}";
        } // End of toString()
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_18352\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] dist = dijkstra();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
            }
        }

        if (sb.toString().isEmpty()) {
            sb.append(-1);
        }

        return sb.toString();
    } // End of solve()

    private static int[] dijkstra() {
        PriorityQueue<Node> pQue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        pQue.offer(new Node(X, 0));
        dist[X] = 0;

        while (!pQue.isEmpty()) {
            Node current = pQue.poll();

            if (isVisited[current.num]) continue;
            if (current.weight > dist[current.num]) continue;
            isVisited[current.num] = true;

            for (Node next : adjList.get(current.num)) {
                if (!isVisited[next.num] && dist[next.num] > dist[current.num] + next.weight) {
                    dist[next.num] = dist[current.num] + 1;
                    pQue.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

        return dist;
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adjList.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), 1));
        }
    } // End of input()
} // End of Main class
