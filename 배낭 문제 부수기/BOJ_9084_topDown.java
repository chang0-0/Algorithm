package BOJ_9084;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9084_topDown {

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

        sb.append(topDown(N, M)).append('\n');

        for(int[] t : memo) System.out.println(Arrays.toString(t));
        System.out.println(memo[1][1000]);
        System.out.println(memo[2][1000]);

        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int m) {
        System.out.println("topDown(" + n + ", " + m + ")");
        // n = coin Index, m = amount
        // 탑 다운 큰 문제를 작은 부분 문제로 나누어서 해결한다.
        // 최종적으로 0원을 만드는 방법(즉, 더 이상 동전을 사용할 필요가 없는 경우)이 하나의 유효한 조합으로 간주된다.

        if (m == 0) return 1;
        if (n <= 0 || m < 0) return 0; // 사용할 수 있는 동전이 없거나, 금액을 만들 수 없는 경우

        if (memo[n][m] != -1) return memo[n][m];

        // 현재 선택된 동전을 사용하는 경우 + 사용하지 않는 경우
        memo[n][m] = topDown(n, m - coins[n - 1]) + topDown(n - 1, m);

        return memo[n][m];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        coins = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        memo = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
    } // End of input()
} // End of Main class
