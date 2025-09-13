package BOJ_1719;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1719_floyd {

    // https://www.acmicpc.net/problem/1719
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] path;
    private static int[][] dist;
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1719\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        floyd();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    sb.append('-');
                } else {
                    sb.append(path[i][j]);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void floyd() {

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];

                        path[i][j] = path[i][k];
                    }
                }
            }
        }

    } // End of floyd()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        path = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];

        // 테이블 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);

            path[a][b] = b;
            path[b][a] = a;
        }
    } // End of input()
} // End of Main class
