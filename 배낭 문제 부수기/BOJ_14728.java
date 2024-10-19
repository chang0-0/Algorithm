package BOJ_14728;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14728 {

    // https://www.acmicpc.net/problem/14728
    // input
    private static BufferedReader br;

    // variables
    private static int N, T;
    private static int[][] times, memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14728\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 남은 시간 동안 공부해서 얻을 수 있는 최대 점수를 구하는 프로그램을 만들어보자.
        topDown(N, T);
        sb.append(memo[N][T]);
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int s) {
        if (n == 0 || s <= 0) return 0;

        if (memo[n][s] != -1) return memo[n][s];

        // 공부하기
        if (s >= times[n - 1][0]) {
            memo[n][s] = Math.max(memo[n][s], topDown(n - 1, s - times[n - 1][0]) + times[n - 1][1]);
        }

        // 공부안하기
        memo[n][s] = Math.max(memo[n][s], topDown(n - 1, s));

        return memo[n][s];
    } // End of topDown()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        times = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        memo = new int[N + 1][T + 1];
        for (int[] t : memo) {
            Arrays.fill(t, -1);
        }
    } // End of input()
} // End of Main class
