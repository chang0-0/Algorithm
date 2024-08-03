package BOJ_1719;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1719_floyd {

    // https://www.acmicpc.net/problem/1719
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] arr, path;
    private static final int INF = 10_000_001;

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
                    sb.append('-').append(' ');
                } else {
                    sb.append(path[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;

                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        // 기존i,j의 거리보다
                        // i -> k -> j 거리가 더 짧을 경우, ij의 거리를 ik + kj로 갱신

                        path[i][j] = path[i][k];
                        // ij로 올 때 "제일 먼저" 이동하는 곳
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
        path = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                    path[i][j] = j;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
            arr[b][a] = c;
        }
    } // End of input()
} // End of Main class
