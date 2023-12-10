package BOJ_1976;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1976_여행_가자 {

    // https://www.acmicpc.net/problem/1976
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static List<List<Integer>> adjList;
    private static int[] travels;
    private static int[] parents, ranks;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1976\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int node : adjList.get(i)) {
                union(i, node);
            }
        }

        int parent = find(travels[0]);
        for (int i = 1; i < M; i++) {
            if (parent != find(travels[i])) {
                sb.append("NO");
                return sb.toString();
            }
        }

        sb.append("YES");
        return sb.toString();
    } // End of solve()

    private static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent != bParent) {
            if (ranks[aParent] < ranks[bParent]) {
                parents[aParent] = bParent;
            } else {
                parents[bParent] = aParent;
                if (ranks[aParent] == ranks[bParent]) {
                    ranks[aParent]++;
                }
            }
        }
    } // End of union()

    private static int find(int node) {
        if (node == parents[node]) return node;

        return parents[node] = find(parents[node]);
    } // End of find()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        ranks = new int[N + 1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    adjList.get(i + 1).add(j + 1);
                }
            }
        }

        travels = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travels[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
