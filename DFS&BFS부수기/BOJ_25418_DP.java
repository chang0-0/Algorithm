package BOJ_25418;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25418_DP {

    // https://www.acmicpc.net/problem/25418
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int A, K;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25418\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        memo[A] = 0;

        for (int i = A; i <= K; i++) {
            if (i + 1 <= K && memo[i] + 1 < memo[i + 1]) {
                memo[i + 1] = memo[i] + 1;
            }

            if (i * 2 <= K && memo[i] + 1 < memo[i * 2]) {
                memo[i * 2] = memo[i] + 1;
            }
        }

        sb.append(memo[K]);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        memo = new int[K + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
    } // End of input()
} // End of Main class
