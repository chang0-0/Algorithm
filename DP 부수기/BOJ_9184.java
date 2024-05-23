package BOJ_9184;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9184 {

    // https://www.acmicpc.net/problem/9184
    // input
    private static BufferedReader br;

    // variables
    private static int A, B, C;
    private static int[][][] memo = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9184\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        for (; ; ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (A == -1 && B == -1 && C == -1) break;
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        sb.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(") = ");

        int ret = topDown(A, B, C);

        sb.append(ret).append('\n');
        return sb.toString();
    } // End of solve()

    private static int topDown(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) {
            return topDown(20, 20, 20);
        }

        if (memo[a][b][c] != -1) return memo[a][b][c];

        if (a < b && b < c) {
            memo[a][b][c] = topDown(a, b, c - 1) + topDown(a, b - 1, c - 1) - topDown(a, b - 1, c);
        } else {
            memo[a][b][c] = topDown(a - 1, b, c) + topDown(a - 1, b - 1, c) + topDown(a - 1, b, c - 1) - topDown(a - 1, b - 1, c - 1);
        }

        return memo[a][b][c];
    } // End of topDwon()
} // End of Main class
