package BOJ_12865;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865 {

    // https://www.acmicpc.net/problem/12865
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[][] memo;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_12865\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 배낭에 넣을 수 있는 물건들의 가치합의 최대값
        topDown(N, K);
        sb.append(memo[N][K]);
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int k) {
        if (n == 0 || k == 0) return 0;

        if (memo[n][k] != -1) return memo[n][k];

        if (k >= arr[n - 1][0]) {
            memo[n][k] = Math.max(topDown(n - 1, k - arr[n - 1][0]) + arr[n - 1][1], topDown(n - 1, k));
        } else {
            memo[n][k] = topDown(n - 1, k);
        }

        return memo[n][k];
    } // End of topDown()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        memo = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
