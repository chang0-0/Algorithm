package BOJ_4803;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_4803 {

    // https://www.acmicpc.net/problem/4803
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, T;
    private static int[] parents, ranks;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_4803\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = 1;
        for (; ; ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> cycleList = new HashSet<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean ret = union(a, b);

            if (ret) {
                cycleList.add(a);
            }
        }

        for (int i = 1; i <= N; i++) {
            // 모두 입력 후 부모 갱신해줘야 됨
            if (cycleList.contains(i)) {
                parents[i] = find(i);
                cycleList.add(parents[i]);
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (!cycleList.contains(parents[i]) && parents[i] == i) ans++;
        }

        sb.append("Case ").append(T++).append(": ");
        if (ans == 0) {
            sb.append("No trees.");
        } else if (ans == 1) {
            sb.append("There is one tree.");
        } else {
            sb.append("A forest of ").append(ans).append(" trees.");
        }
        sb.append('\n');

        return sb.toString();
    } // End of solve()

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return true;

        if (ranks[rootA] < ranks[rootB]) {
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;

            if (ranks[rootA] == ranks[rootB]) {
                ranks[rootA]++;
            }
        }

        return false;
    } // End of union()

    private static int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    } // End of find()

    private static void input() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        ranks = new int[N + 1];
    } // End of input()
} // End of Main class
