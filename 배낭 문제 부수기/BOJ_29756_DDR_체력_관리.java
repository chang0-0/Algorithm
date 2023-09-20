package BOJ_29756;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_29756_DDR_체력_관리 {

    // https://www.acmicpc.net/problem/29756
    // input
    private static BufferedReader br;

    // variables
    private static final int MAX_HEALTH = 100;
    private static int N, K;
    private static int[] scores;
    private static int[] healths;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_29756\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(knapsack(N, MAX_HEALTH));
        return sb.toString();
    } // End of solve()

    private static int knapsack(int n, int health) {
        if (n == 0) return 0;
        if (memo[n][health] != -1) return memo[n][health];

        int newHealth = Math.min(MAX_HEALTH, health + K);

        memo[n][health] = knapsack(n - 1, newHealth);

        if (newHealth >= healths[n]) {
            memo[n][health] = Math.max(memo[n][health], knapsack(n - 1, newHealth - healths[n]) + scores[n]);
        }

        return memo[n][health];
    } // End of knapsack()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        scores = new int[N + 1];
        healths = new int[N + 1];
        memo = new int[N + 1][MAX_HEALTH + 1];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            healths[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
    } // End of input()
} // End of Main class
