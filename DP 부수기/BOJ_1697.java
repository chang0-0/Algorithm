package BOJ_1697;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1697 {

    // https://www.acmicpc.net/problem/1697
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1697\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(bottomUp());
        return sb.toString();
    } // End of solve()

    private static int bottomUp() {
        for (int i = N + 1; i <= K; i++) {
            int min;

            if (i % 2 == 0) {
                min = memo[i / 2] + 1;
            } else {
                min = Math.min(memo[(i + 1) / 2], memo[(i - 1) / 2]) + 2;
            }

            memo[i] = Math.min(min, memo[i - 1] + 1);
        }

        return memo[K];
    } // End of bottomUp()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        memo = new int[100_001];
        for (int i = 0; i < N; i++) {
            memo[i] = N - i;
        }
        System.out.println(Arrays.toString(memo));
    } // End of input()
} // End of Main class
