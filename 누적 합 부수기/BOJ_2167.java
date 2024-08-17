package BOJ_2167;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2167 {

    // https://www.acmicpc.net/problem/2167
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] arr, prefixSums;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2167\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        calcPrefixSum();
        for (int[] t : prefixSums) {
            System.out.println(Arrays.toString(t));
        }


        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;
            sum = prefixSums[x][y] - prefixSums[x][j - 1] - prefixSums[i - 1][y] + prefixSums[i - 1][j - 1];
            sb.append(sum).append('\n');
        }


        return sb.toString();
    } // End of solve()

    private static void calcPrefixSum() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSums[i][j] = arr[i][j]
                        + prefixSums[i - 1][j] + prefixSums[i][j - 1] - prefixSums[i - 1][j - 1];
            }
        }
    } // End of calcPrefixSum()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        prefixSums = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
//                if (j == 1) {
//                    prefixSums[i][j] = prefixSums[i - 1][M] + arr[i][j];
//                    continue;
//                }
//                prefixSums[i][j] = prefixSums[i][j - 1] + arr[i][j];
            }
        }
    } // End of input()
} // End of Main class
