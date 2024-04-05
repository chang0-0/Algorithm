package BOJ_1946;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1946 {

    // https://www.acmicpc.net/problem/1946
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] scores;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1946\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 1;
        int standard = scores[1]; // 서류 1등을 기준으로

        for (int i = 2; i <= N; i++) {
            if (scores[i] < standard) {
                ans++;
                standard = scores[i];
            }
        }

        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        scores = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            scores[a] = b;
        }
    } // End of input()
} // End of Main class
