package BOJ_14916;

import java.io.*;
import java.util.Arrays;

public class BOJ_14916_topDown {

    // https://www.acmicpc.net/problem/14916
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] memo;

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
        int ret = topDown(N);
        if (ret == INF) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }

        return sb.toString();
    } // End of solve()

    private static int topDown(int n) {
        if (n <= 0) return 0; // 거스름돈 동전의 개수 0이면 동전의 개수는 0개임
        if (memo[n] != INF) return memo[n];

        if (n - FIVE >= 0) {
            memo[n] = Math.min(memo[n], topDown(n - FIVE) + 1);
        }

        if (n - TWO >= 0) {
            memo[n] = Math.min(memo[n], topDown(n - TWO) + 1);
        }

        return memo[n];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        Arrays.fill(memo, INF);
    } // End of input()
} // End of Main class
