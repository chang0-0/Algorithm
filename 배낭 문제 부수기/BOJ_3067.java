package BOJ_3067;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3067 {

    // https://www.acmicpc.net/problem/3067
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] coins;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3067\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(topDown(N, M)).append('\n');
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int m) {
        if (n <= 0 || m < 0) return 0;
        if (m == 0) return 1;

        if (memo[n][m] != -1) return memo[n][m];

        memo[n][m] = topDown(n - 1, m) + topDown(n, m - coins[n - 1]);

        return memo[n][m];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        coins = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        memo = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
    } // End of input()
} // End of Main class
