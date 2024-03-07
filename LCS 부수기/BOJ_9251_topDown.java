package BOJ_9251;

import java.io.*;
import java.util.Arrays;

public class BOJ_9251_topDown {

    // https://www.acmicpc.net/problem/9251
    // input
    private static BufferedReader br;

    // variables
    private static char[] chArr1, chArr2;
    private static int N, M;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9251\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        // 최장 공통 부분 수열을 찾기
        // 부분 수열 -> 연속되지 않은 값들
        // 부분 배열 -> 연속된 값들 헷갈리지 말 것

        sb.append(topDown(N, M));
        return sb.toString();
    } // End of solve()

    private static int topDown(int n, int m) {
        // base case
        if (n == 0 || m == 0) return 0;

        if (memo[n][m] != -1) return memo[n][m];

        // 2개 모두 같으면 공통된 부분을 찾아서 길이 + 1을 해준다.
        // 그리고 공통 적으로 같기 때문에 1씩 줄여주면 된다.
        if (chArr1[n - 1] == chArr2[m - 1]) {
            memo[n][m] = topDown(n - 1, m - 1) + 1;
        } else {
            // 다를 경우, 하나를 따로 감소시켜서 큰 값을 memo에 저장한다.
            memo[n][m] = Math.max(topDown(n - 1, m), topDown(n, m - 1));
        }

        return memo[n][m];
    } // End of topDown()

    private static void input() throws IOException {
        chArr1 = br.readLine().toCharArray();
        chArr2 = br.readLine().toCharArray();
        N = chArr1.length;
        M = chArr2.length;

        memo = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
    } // End of input()
} // End of Main class
