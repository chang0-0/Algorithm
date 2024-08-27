package BOJ_9251;

import java.io.*;

public class BOJ_9251_bottomUp {

    // https://www.acmicpc.net/problem/9251
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[] str1, str2;

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

        int[][] memo = new int[N + 1][M + 1];

        int n = 1;
        int m = 1;
        while (n <= N) {
            if (str1[n - 1] == str2[m - 1]) {
                memo[n][m] = memo[n - 1][m - 1] + 1;
            } else {
                memo[n][m] = Math.max(memo[n - 1][m], memo[n][m - 1]);
            }

            m++;
            if (m == M + 1) {
                n++;
                m = 1;
            }
        }

        sb.append(memo[N][M]);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        N = str1.length;
        M = str2.length;
    } // End of input()
} // End of Main class
