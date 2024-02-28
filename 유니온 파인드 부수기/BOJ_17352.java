package BOJ_17352;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17352 {

    // https://www.acmicpc.net/problem/17352
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] parents, ranks;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17352\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int a = find(1);
        for (int i = 2; i <= N; i++) {
            if (a != find(i)) {
                sb.append(a).append(' ').append(i);
                break;
            }
        }


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
        if (parents[node] == node) return node;

        return parents[node] = find(parents[node]);
    } // End of find()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        ranks = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    } // End of input()
} // End of Main class
