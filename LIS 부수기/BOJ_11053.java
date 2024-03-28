package BOJ_11053;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053 {

    // https://www.acmicpc.net/problem/11053
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11053\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 1;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, LIS(i));
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int LIS(int n) {
        if (memo[n] != -1) return memo[n];

        // 최소 길이는 자기 자신
        int max = 1;

        for (int i = n + 1; i < N; i++) {
            if (arr[i] > arr[n]) {
                int listLen = LIS(i) + 1;
                max = Math.max(max, listLen);
            }
        }

        memo[n] = max;
        return memo[n];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        memo = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = -1;
        }

    } // End of input()
} // End of Main class
