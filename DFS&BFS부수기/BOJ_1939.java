import java.io.*;
import java.util.*;

public class  {

    // https://www.acmicpc.net/problem/1939
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, fac1, fac2;
    private static List<List<Node>> adjList;

    private static class Node implements Comparable<Node> {
        int num;
        int weight;
        int maxWeight;

        private Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        private Node(int num, int weight, int maxWeight) {
            this.num = num;
            this.weight = weight;
            this.maxWeight = maxWeight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - weight;
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];

        que.offer(new Node(fac1, 0, Integer.MAX_VALUE));

        while (!que.isEmpty()) {
            Node current = que.poll();

            if (isVisited[current.num]) continue;
            isVisited[current.num] = true;

            if (current.num == fac2) {
                return current.maxWeight;
            }

            for (Node next : adjList.get(current.num)) {
                if (current.maxWeight > next.weight) {
                    que.offer(new Node(next.num, next.weight, next.weight));
                } else {
                    que.offer(new Node(next.num, current.weight, current.weight));
                }
            }
        }

        return -1;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        st = new StringTokenizer(br.readLine());
        fac1 = Integer.parseInt(st.nextToken());
        fac2 = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class

