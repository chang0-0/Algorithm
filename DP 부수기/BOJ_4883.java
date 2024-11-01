package BOJ_4883;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4883 {

    // https://www.acmicpc.net/problem/4883
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[][] arr = new int[100_001][3];
    private static int[][] memo = new int[100_001][3];

    private static final int INF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_4883\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            bw.write(testCase++ + ". ");

            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        sb.append(topDown(N - 1, 1)).append('\n');
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int m) {
        if (n == 0 && m == 1) return arr[n][m];
        if (n < 0 || m < 0 || m > 2) return INF;

        if (memo[n][m] != INF) return memo[n][m];
        int minCost = INF;

        // 같은 방향에서는 오른쪽으로만 이동 가능.
        if (m - 1 >= 0) {
            minCost = Math.min(minCost, topDown(n, m - 1));
        }

        // 아래로 중앙으로 이동
        if (n - 1 >= 0) {
            minCost = Math.min(minCost, topDown(n - 1, m)); // 중앙
        }

        // 아래 왼쪽으로 이동
        if (n - 1 >= 0 && m - 1 >= 0) {
            minCost = Math.min(minCost, topDown(n - 1, m - 1)); // 왼쪽 아래로
        }

        // 아래 오른쪽으로 이동
        if (n - 1 >= 0 && m + 1 <= 2) {
            minCost = Math.min(minCost, topDown(n - 1, m + 1)); // 오른쪽 아래로
        }


        memo[n][m] = minCost + arr[n][m];
        return memo[n][m];
    } // End of topDown()

    private static void input() throws IOException {
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], INF);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
