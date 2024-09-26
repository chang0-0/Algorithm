package BOJ_1080;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1080 {

    // https://www.acmicpc.net/problem/1080
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] A, B;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1080\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip(i, j);
                    count++;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    sb.append(-1);
                    return sb.toString();
                }
            }
        }

        sb.append(count);
        return sb.toString();
    } // End of solve()

    private static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }

    } // End of flip()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = temp.charAt(j) - '0';
            }
        }
    } // End of input()
} // End of Main class
