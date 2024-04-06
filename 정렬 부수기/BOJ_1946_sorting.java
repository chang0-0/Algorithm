package BOJ_1946;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946_sorting {

    // https://www.acmicpc.net/problem/1946
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[][] scores;

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

        // 서류 등수를 기준으로 정렬
        Arrays.sort(scores, (a, b) -> {
            return a[0] - b[0];
        });


        int ans = 1; // 1등 포함
        int interviewRank = scores[0][1];

        for (int i = 1; i < N; i++) {
            if (scores[i][1] < interviewRank) {
                ans++;
                interviewRank = scores[i][1];
            }
        }


        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        scores = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            scores[i][0] = a;
            scores[i][1] = b;
        }
    } // End of input()
} // End of Main class
