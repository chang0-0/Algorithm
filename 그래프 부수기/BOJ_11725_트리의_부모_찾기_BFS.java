package BOJ_11725;

import java.io.*;
import java.util.*;

public class BOJ_11725_트리의_부모_찾기_BFS {

    // https://www.acmicpc.net/problem/11725
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static List<List<Integer>> adjList;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11725\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        BFS();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void BFS() {
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];

        que.offer(1);
        isVisited[1] = true;

        while (!que.isEmpty()) {
            int current = que.poll();

            for (int next : adjList.get(current)) {
                if (isVisited[next]) continue;
                if (parents[next] == 0) {
                    parents[next] = current;
                    que.offer(next);
                }
            }
        }
    } // End of BFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

    } // End of input()
} // End of Main class
