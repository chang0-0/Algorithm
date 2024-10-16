package BOJ_31714;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_31714 {

    // https://www.acmicpc.net/problem/31714
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, D;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31714\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int[] t : arr) {
            Arrays.sort(t);
        }

        boolean ret = true;
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[j - 1][i] >= arr[j][i]) {
                    ret = false;
                    break;
                }
            }
        }

        sb.append(ret ? "YES" : "NO");
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + (i * D);
            }
        }

    } // End of input()
} // End of Main class
