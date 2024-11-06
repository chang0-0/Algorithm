package BOJ_2579;

import java.io.*;
import java.util.Arrays;

public class BOJ_2579 {

    // https://www.acmicpc.net/problem/2579
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] stairs;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2579\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(topDown(N, 0));

        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int m) {
        if (n <= 0) return 0;

        if (memo[n][m] != -1) return memo[n][m];

        if (m < 2) {
            memo[n][m] = Math.max(memo[n][m], topDown(n - 1, m + 1) + stairs[n]);
        }

        if (n >= 2) {
            memo[n][m] = Math.max(memo[n][m], topDown(n - 2, 1) + stairs[n]);
        }

        return memo[n][m];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1][3];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }

        stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
    } // End of input()
} // End of Main class
