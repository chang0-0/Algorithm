package BOJ_2302;

import java.io.*;
import java.util.Arrays;

public class BOJ_2302 {

    // https://www.acmicpc.net/problem/2302
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static boolean[] vips;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2302\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // basecase 기저 조건
        memo[0] = 1;
        memo[1] = 1;

        sb.append(topDown(N));
        return sb.toString();
    } // End of solve()

    private static int topDown(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        if (vips[n] || vips[n - 1]) {
            memo[n] = topDown(n - 1);
        } else {
            memo[n] = topDown(n - 1) + topDown(n - 2);
        }


        return memo[n];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        vips = new boolean[N + 1];
        memo = new int[N + 1];
        Arrays.fill(memo, -1);

        for (int i = 0; i < M; i++) {
            vips[Integer.parseInt(br.readLine())] = true;
        }
    } // End of input()
} // End of Main class
