package BOJ_2617;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2617 {

    // https://www.acmicpc.net/problem/2617
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2617\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        /*
            무게가 중간인 구슬이 될 수 없는 구슬의 개수를 구하는 프로그램을 작성하시오.
         */

        floyd();
        int ans = 0;

        // 본인보다 무겁거나 가벼운 갯수가 반을 넘을 경우 + 1
        for (int i = 1; i <= N; i++) {
            int c1 = 0;
            int c2 = 0;

            for (int j = 0; j <= N; j++) {
                if (arr[i][j] == 1) {
                    c1++;
                } else if (arr[i][j] == 2) {
                    c2++;
                }
            }

            if (c1 >= (N / 2) + 1 || c2 >= (N / 2) + 1) {
                ans++;
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    } else if (arr[i][k] == 2 && arr[k][j] == 2) {
                        arr[i][j] = 2;
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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1; // a가 b보다 무거움
            arr[b][a] = 2; // b가 a보다 가벼움
        }
    } // End of input()
} // End of Main class
