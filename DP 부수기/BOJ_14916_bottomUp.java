package BOJ_14916;

import java.io.*;
import java.util.Arrays;

public class BOJ_14916_bottomUp {

    // https://www.acmicpc.net/problem/14916
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    private static final int INF = Integer.MAX_VALUE / 4;
    private static final int TWO = 2;
    private static final int FIVE = 5;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14916\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 최소가 되도록 만들어야 한다.
        int ret = bottomUp();
        if (ret == INF) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }

        return sb.toString();
    } // End of solve()

    private static int bottomUp() {
        int[] memo = new int[N + 1];
        Arrays.fill(memo, INF);
        memo[0] = 0;

        for (int i = 1; i <= N; i++) {
            if (memo[i] != INF) continue;

            if (i - FIVE >= 0) {
                memo[i] = Math.min(memo[i], memo[i - FIVE] + 1);
            }
            if (i - TWO >= 0) {
                memo[i] = Math.min(memo[i], memo[i - TWO] + 1);
            }
        }

        return memo[N];
    } // End of bottomUp()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
