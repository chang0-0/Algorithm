package BOJ_18427;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18427_BottomUp {

    // https://www.acmicpc.net/problem/18427
    // input
    private static BufferedReader br;

    // variables
    private static final int MOD = 10_007;
    private static int N, M, H;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_18427\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        memo = new int[N + 1][H + 1];
        memo[0][0] = 1; // base case

        sb.append(bottomUp());
        return sb.toString();
    } // End of solve()

    private static int bottomUp() throws IOException {

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            memo[i - 1][0] = 1;

            for (int j = 0; j < count; j++) {
                int block = Integer.parseInt(st.nextToken());

                for (int k = block; k <= H; k++) {
                    memo[i][k] = (memo[i][k] + memo[i - 1][k - block]) % MOD;
                }
            }

            for (int j = 1; j <= H; j++) {
                memo[i][j] = (memo[i][j] + memo[i - 1][j]) % MOD;
            }
        }

        return memo[N][H];
    } // End of bottomUp()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

    } // End of input()
} // End of Main class
