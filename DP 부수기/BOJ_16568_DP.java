package BOJ_16568;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16568_DP {

    // https://www.acmicpc.net/problem/16568
    // input
    private static BufferedReader br;

    // variables
    private static int N, A, B;
    private static final int INF = Integer.MAX_VALUE / 16;

    private static class Magic {
        int idx;
        int sec;

        private Magic(int idx, int sec) {
            this.idx = idx;
            this.sec = sec;
        }
    } // End of Magic

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16568\\res.txt"));
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
        int[] memo = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            memo[i] = memo[i - 1] + 1;
            if (i >= A) {
                memo[i] = Math.min(memo[i], memo[i - A] + 1);
            }

            if (i >= B) {
                memo[i] = Math.min(memo[i], memo[i - B] + 1);
            }
        }

        return memo[N];
    } // End of bottomUp()


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken()) + 1;
        B = Integer.parseInt(st.nextToken()) + 1;
    } // End of input()
} // End of Main class
