package BOJ_9084;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9084_bottomUp {

    // https://www.acmicpc.net/problem/9084
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] memo;
    private static int[] coins;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9084\\res.txt"));
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

        sb.append(bottomUp()).append('\n');
        return sb.toString();
    } // End of solve()

    private static int bottomUp() {
        // 기저조건
        for (int i = 0; i <= N; i++) {
            memo[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 현재 동전의 가치가 j보다 크면, 이 동전은 사용할 수 없다.
                if (coins[i - 1] > j) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    // 현재 동전을 사용하지 않는 경우 + 현재 동전을 사용하는 경우
                    memo[i][j] = memo[i - 1][j] + memo[i][j - coins[i - 1]];
                }
            }
        }


        return memo[N][M];
    } // End of bottomUp


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        coins = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        memo = new int[N + 1][M + 1];
    } // End of input()
} // End of Main class
