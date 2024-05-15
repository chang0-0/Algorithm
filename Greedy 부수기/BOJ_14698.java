package BOJ_14698;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14698 {

    // https://www.acmicpc.net/problem/14698
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static final int MOD = (int) Math.pow(10, 9) + 7;
    private static PriorityQueue<Long> pque;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14698\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        long ans = 1;
        while (pque.size() > 1) {
            long num1 = pque.poll();
            long num2 = pque.poll();
            long temp = (num1 * num2);

            ans *= temp % MOD;
            ans %= MOD;
            pque.offer(temp);
        }

        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        pque = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pque.offer(Long.parseLong(st.nextToken()));
        }
    } // End of input()
} // End of Main class
