package BOJ_2579;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2579_계단_오르기 {

    // https://www.acmicpc.net/problem/2579
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] stairs;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2579\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DP(N, 0);
        System.out.println(Arrays.toString(memo));

        return sb.toString();
    } // End of solve()

    private static int DP(int n, int count) {
        System.out.println("DP(" + n + ", " + count + ")");

        if (n == 0) return 0;
        if (n < 0 || count >= 3) return -1;
        if (memo[n] != -1) return memo[n];

        int takeOne = -1;
        int takeTwo = -1;

        if (count < 2) {
            takeOne = DP(n - 1, count + 1) + stairs[n];
        }

        takeTwo = DP(n - 2, 1) + stairs[n];

        memo[n] = Math.max(takeOne, takeTwo);
        return memo[n];
    } // End of DP()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        memo = new int[N + 1];
        Arrays.fill(memo, -1);

        stairs = new int[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
