package BOJ_1956;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956 {

    // https://www.acmicpc.net/problem/1956
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE / 4;
    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1956\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        floyd();

        int ans = INF;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue; // 자신은 제외

                if (arr[i][j] != INF && arr[j][i] != INF) {
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }

        if (ans == INF) {
            sb.append(-1);
        } else {
            sb.append(ans);
        }

        return sb.toString();
    } // End of solve()

    private static void floyd() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

    } // End of floyd()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }
    } // End of input()
} // End of Main class
