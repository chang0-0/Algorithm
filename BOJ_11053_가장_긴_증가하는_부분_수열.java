package BOJ_11053;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_가장_긴_증가하는_부분_수열 {

    // https://www.acmicpc.net/problem/11053
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] memo, arr;

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

        topDown(N);

        return sb.toString();
    } // End of solve()

    private static int topDown(int depth) {
        if (depth == 0) return 0;

        if (memo[depth] == -1) {
            return memo[depth];
        }

        return 0;
    } // End of topDown()

    private static void binarySearch() {

    } // End of binarySearch()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        memo = new int[N + 1];
        Arrays.fill(memo, -1);

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
