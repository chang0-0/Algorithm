package BOJ_1535;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1535 {

    // https://www.acmicpc.net/problem/1535
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static final int MAX = 100;
    private static int[][] greetings, memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1535\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ret = topDown(N, MAX);
        // for (int[] t : memo) System.out.println(Arrays.toString(t));

        sb.append(ret);
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int m) {
        // System.out.println("topDown(" + n + ", " + m + ")");
        if (n <= 0 || m <= 0) return 0;
        else if (memo[n][m] != -1) return memo[n][m];

        if (m - greetings[n][0] > 0) {
            // 인사를 할 수 있는 경우
            // 인사를 한다, 인사를 하지 않고 넘어간다. 선택지 2개
            memo[n][m] = Math.max(topDown(n - 1, m - greetings[n][0]) + greetings[n][1], topDown(n - 1, m));
        } else {
            // 인사를 할 수 없는 경우
            memo[n][m] = topDown(n - 1, m);
        }

        return memo[n][m];
    } // End of topDown()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        greetings = new int[N + 1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            greetings[i][0] = Integer.parseInt(st.nextToken()); // 잃는 체력
            greetings[i][1] = Integer.parseInt(st2.nextToken()); // 얻는 기쁨
        }

        memo = new int[N + 1][MAX + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
    } // End of input()
} // End of Main class
