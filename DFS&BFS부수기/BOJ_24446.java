package BOJ_24446;

import java.io.*;
import java.util.*;

public class BOJ_24446 {

    // https://www.acmicpc.net/problem/24446
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, R;
    private static List<List<Integer>> adjList;

    private static class Node {
        int num;
        int depth;

        private Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }


        @Override
        public String toString() {
            return "Node{" + num + ", " + depth + "}\n";
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_24446\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] ret = BFS();
        for (int i = 1; i <= N; i++) {
            sb.append(ret[i]).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static int[] BFS() {
        ArrayDeque<Node> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] depths = new int[N + 1];
        Arrays.fill(depths, -1);
        que.offer(new Node(R, 0));
        depths[R] = 0;
        isVisited[R] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int next : adjList.get(cur.num)) {
                if (isVisited[next]) continue;
                depths[next] = cur.depth + 1;
                isVisited[next] = true;
                que.offer(new Node(next, depths[next]));
            }
        }

        return depths;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    } // End of input()
} // End of Main class
