package BOJ_22115;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22115_bottomUp {

    // https://www.acmicpc.net/problem/22115
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] arr, memo;
    private static final int MAX = 100_101;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_22115_topDown\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        memo[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= 0; j--) {
                if (j - arr[i] >= 0 && memo[j - arr[i]] != MAX) {
                    memo[j] = Math.min(memo[j], memo[j - arr[i]] + 1);
                }
            }
        }

        sb.append(memo[K] == MAX ? -1 : memo[K]);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        memo = new int[K + 1];
        Arrays.fill(memo, MAX);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
