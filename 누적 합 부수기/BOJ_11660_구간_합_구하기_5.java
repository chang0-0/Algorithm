package BOJ_11660;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11660_구간_합_구하기_5 {
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\Java Algorithm\\JavaAlgorithm\\src\\BOJ_11660\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append(
                    prefixSum(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            ).append('\n');
        }

        return sb.toString();
    } // End of solve

    private static int prefixSum(int x1, int y1, int x2, int y2) {
        return board[x2][y2] - board[x1 - 1][y2] - board[x2][y1 - 1] + board[x1 - 1][y1 - 1];
    } // End of prefixSum()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i + 1][j + 1] = Integer.parseInt(st.nextToken());
                // 대각선으로 교차 합
                board[i + 1][j + 1] = board[i + 1][j] + board[i][j + 1] - board[i][j] + board[i + 1][j + 1];
            }
        }
    } // End of input()
} // End of Main class
