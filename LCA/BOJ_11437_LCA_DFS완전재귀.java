package BOJ_11437;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11437_LCA_DFS완전재귀 {

    // https://www.acmicpc.net/problem/11437
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] depths, parents;
    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11437\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        DFS(1, 0, 0, 0);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b)).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void DFS(int current, int parent, int depth, int index) {
        if (index == 0) {
            parents[current] = parent;
            depths[current] = depth;
        } else if (index == adjList.get(current).size()) return;

        int next = adjList.get(current).get(index);
        if (next != parent) {
            DFS(next, current, depth + 1, 0);
        }

        DFS(current, parent, depth, index + 1);
    } // End of DFS()

    private static int LCA(int a, int b) {
        if (a == b) {
            return a;
        }

        // 먼저 깊이를 맞춘다
        if (depths[a] > depths[b]) {
            return LCA(parents[a], b);
        } else if(depths[a] < depths[b]) {
            return LCA(a, parents[b]);
        }

        // 깊이가 같다면 공통 조상을 찾는다
        return LCA(parents[a], parents[b]);
    } // End of LCA()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        depths = new int[N + 1];
        parents = new int[N + 1];

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        M = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
