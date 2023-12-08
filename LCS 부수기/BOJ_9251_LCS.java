package BOJ_9251;

import java.io.*;
import java.util.Arrays;

public class BOJ_9251_LCS {

    // https://www.acmicpc.net/problem/9251
    // input
    private static BufferedReader br;

    // variables
    private static int[][] memo;
    private static String N;
    private static String M;
    private static int NLen;
    private static int MLen;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9251\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(LCS(NLen, MLen));
        return sb.toString();
    } // End of solve()

    private static int LCS(int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (N.charAt(n - 1) == M.charAt(m - 1)) {
            memo[n][m] = 1 + LCS(n - 1, m - 1);
        } else {
            memo[n][m] = Math.max(LCS(n - 1, m), LCS(n, m - 1));
        }

        return memo[n][m];
    } // End of topDown()

    private static void input() throws IOException {
        N = br.readLine();
        M = br.readLine();
        NLen = N.length();
        MLen = M.length();

        memo = new int[NLen + 1][MLen + 1];
        for (int i = 0; i <= NLen; i++) {
            Arrays.fill(memo[i], -1);
        }
    } // End of input()
} // End of Main class
