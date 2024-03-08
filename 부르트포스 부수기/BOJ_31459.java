package BOJ_31459;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_31459 {

    // https://www.acmicpc.net/problem/31459
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, x, y;
    private static boolean[][] able;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31459\\res.txt"));
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

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int nextX = i + x;
            for (int j = 0; j < M; j++) {
                int nextY = j + y;

                if (able[i][j]) continue;

                if (nextX >= N || nextY >= M) ans++;
                else if (!able[nextX][nextY]) {
                    able[nextX][nextY] = true;
                    ans++;
                }
            }
        }

        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        able = new boolean[N][M];

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
