package BOJ_18427;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18427_TopDown {

    // https://www.acmicpc.net/problem/18427
    // input
    private static BufferedReader br;

    // variables

    private static final int MOD = 10007;
    private static int N, M, H;
    private static int[][] arr, memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_18427\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 사용할 수 있는 블럭은 최대 M개지만 선택지는 최대 M + 1개가 된다.
        sb.append(topDown(N, H));
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int h) {
        if (h == 0) return 1;
        if (n == 0) return 0;

        if (memo[n][h] != -1) return memo[n][h];

        int ret = topDown(n - 1, h);
        for (int block : arr[n - 1]) {
            if (h >= block) {
                ret = (ret + topDown(n - 1, h - block)) % MOD;
            }
        }

        return memo[n][h] = ret;
    } // End of topDown()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        memo = new int[N + 1][H + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
    } // End of input()
} // End of Main class
