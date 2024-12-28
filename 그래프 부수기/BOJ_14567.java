package BOJ_14567;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14567 {

    // https://www.acmicpc.net/problem/14567
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static List<List<Integer>> adjList;
    private static int[] degrees;

    private static class Edge {
        int num;
        int count;

        private Edge(int num, int count) {
            this.num = num;
            this.count = count;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14567\\res.txt"));
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
            sb.append(ret[i]).append(' ');
        }

        return sb.toString();
    } // End of solve()

    private static int[] BFS() {
        ArrayDeque<Edge> que = new ArrayDeque<>();
        int[] ret = new int[N + 1];
        boolean[] isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) {
                que.offer(new Edge(i, 1));
                ret[i] = 1;
                isVisited[i] = true;
            }
        }

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            for (int next : adjList.get(cur.num)) {
                if (isVisited[next]) continue;
                degrees[next]--;
                if (degrees[next] == 0) {
                    ret[next] = cur.count + 1;
                    que.offer(new Edge(next, cur.count + 1));
                }
            }
        }

        return ret;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degrees = new int[N + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            degrees[b]++;
        }

    } // End of input()
} // End of Main class
