package BOJ_12865;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12865_bottom_up {

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

        bottomUp();
        sb.append(memo[N][K]);
        return sb.toString();
    } // End of solve()

    private static void bottomUp() {
        for (int n = 1; n <= N; n++) {
            for (int k = 0; k <= K; k++) {
                memo[n][k] = memo[n - 1][k];

                if (k >= arr[n][0]) {
                    memo[n][k] = Math.max(memo[n][k], memo[n - 1][k - arr[n][0]] + arr[n][1]);
                }
            }
        }
    } // End of bottomUp()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][2];
        memo = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
            arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }
    } // End of input()
} // End of Main class
