package BOJ_10159;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10159 {

    // https://www.acmicpc.net/problem/10159
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE / 4;
    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_10159\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        floyd(arr);

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == INF && arr[j][i] == INF) {
                    // 둘다 이동할 수 없는 경로일 경우, 비교할 수 없는 경우임
                    // i번 노드를 기준으로 j로 이동할 수 없고 j번 노드에서도 i로 이동할 수 없다.
                    count++;
                }
            }
            sb.append(count).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void floyd(int[][] arr) {

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    // 최단 경로 파악
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

    } // End of floyd()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // i가 j보다 무거운지 가벼운지를 구분한다.
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1; // a가 b보다 무거운 배열
        }

    } // End of input()
} // End of Main class
