package BOJ_11725;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11725_트리의_부모_찾기 {

    // https://www.acmicpc.net/problem/11725
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] parents;
    private static List<List<Integer>> adjList;

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

        DFS(1, 0, 0, 0);
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void DFS(int current, int parent, int depth, int idx) {
        if (idx == 0) {
            parents[current] = parent;
        } else if (idx == adjList.get(current).size()) {
            return;
        }

        int next = adjList.get(current).get(idx);
        if (next != parent) {
            DFS(next, current, depth + 1, 0);
        }

        DFS(current, parent, depth, idx + 1);
    } // End of DFS()


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();
        parents = new int[N + 1];

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
