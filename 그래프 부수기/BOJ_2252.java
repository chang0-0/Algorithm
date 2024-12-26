package BOJ_2252;

import java.io.*;
import java.util.*;

public class BOJ_2252 {

    // https://www.acmicpc.net/problem/2252
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static List<List<Integer>> adjList;
    private static int[] degree;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2252\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] ret = BFS();
        for (int t : ret) sb.append(t).append(' ');

        return sb.toString();
    } // End of solve()

    private static int[] BFS() {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] ret = new int[N];
        int idx = 0;

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            ret[idx++] = cur;

            for (int next : adjList.get(cur)) {
                degree[next]--;

                if (degree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        return ret;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        degree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a -> b
            adjList.get(a).add(b);
            degree[b]++;
        }
    } // End of input()
} // End of Main class
