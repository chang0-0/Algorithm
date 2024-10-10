package BOJ_22115;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22115 {

    // https://www.acmicpc.net/problem/22115
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] arr;
    private static int[][] memo;
    private static final int MAX = 100_101;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_22115\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 정확히 K카페인
        int ans = topDown(N, K);
        if (ans == MAX) {
            sb.append(-1);
        } else {
            sb.append(ans);
        }

        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int k) {
        if (k == 0) return 0;
        if (n == 0) return MAX;

        if (memo[n][k] != -1) return memo[n][k];

        int result = topDown(n - 1, k);
        if (k >= arr[n - 1]) {
            int cur = topDown(n - 1, k - arr[n - 1]);
            if (cur != MAX) {
                result = Math.min(result, cur + 1);
            }
        }

        memo[n][k] = result;
        return memo[n][k];
    } // End of topDown()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        memo = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
