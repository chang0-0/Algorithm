package BOJ_9625;

import java.io.*;

public class BOJ_9625 {

    // https://www.acmicpc.net/problem/9625
    // input
    private static BufferedReader br;

    // variables
    private static int K;
    private static Count[] memo;

    private static class Count {
        int a;
        int b;

        private Count(int a, int b) {
            this.a = a;
            this.b = b;
        }
    } // End of Count class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9625\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // A는 이전 B의 개수
        // B는 이전 A의 개수 + 이전 B의 개수
        memo[0] = new Count(1, 0);
        memo[1] = new Count(0, 1);

        if (K <= 1) {
            sb.append(memo[K].a).append(' ').append(memo[K].b);
            return sb.toString();
        }

        memo[2] = new Count(1, 1);
        for (int i = 3; i <= K; i++) {
            memo[i].a = memo[i - 1].b;
            memo[i].b = memo[i - 1].a + memo[i - 1].b;
        }

        sb.append(memo[K].a).append(' ').append(memo[K].b);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        memo = new Count[K + 1];
        for (int i = 0; i <= K; i++) {
            memo[i] = new Count(0, 0);
        }

    } // End of input()
} // End of Main class
