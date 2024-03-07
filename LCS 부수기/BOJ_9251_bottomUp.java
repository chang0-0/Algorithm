package BOJ_9251;

import java.io.*;

public class BOJ_9251_bottomUp {

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

        sb.append(bottomUp());
        return sb.toString();
    } // End of solve()

    private static int bottomUp() {
        int nIdx = 1;
        int mIdx = 1;
        while (nIdx != N + 1) {
            if (mIdx == M + 1) {
                nIdx++;
                mIdx = 1;
            }

            if (nIdx == N + 1) break;
            if (memo[nIdx][mIdx] != 0) mIdx++;

            if (chArr1[nIdx - 1] == chArr2[mIdx - 1]) {
                // 길이 + 1은 일치 할때 밖에 할 수 없다.
                // memo배열 값을 증가시킬 수 있는 것은 일치 할 때 밖에 없음을 명심하자.
                memo[nIdx][mIdx] = memo[nIdx - 1][mIdx - 1] + 1;
            } else {
                memo[nIdx][mIdx] = Math.max(memo[nIdx - 1][mIdx], memo[nIdx][mIdx - 1]);
            }
            mIdx++;
        }

        return memo[N][M];
    } // End of bottomUp()

    private static void input() throws IOException {
        chArr1 = br.readLine().toCharArray();
        chArr2 = br.readLine().toCharArray();
        N = chArr1.length;
        M = chArr2.length;

        memo = new int[N + 1][M + 1];
    } // End of input()
} // End of Main class
