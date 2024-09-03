package BOJ_11581;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11581_floyd {

    // https://www.acmicpc.net/problem/11581
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11581\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        floyd();
        for (int i = 1; i < N; i++) {
            if (arr[1][i] == 1 && arr[i][i] == 1) {
                sb.append("CYCLE");
                return sb.toString();
            }
        }

        sb.append("NO CYCLE");
        return sb.toString();
    } // End of solve()

    private static void floyd() {

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

    } // End of floyd()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][Integer.parseInt(st.nextToken())] = 1;
            }
        }
    } // End of input()
} // End of Main class
