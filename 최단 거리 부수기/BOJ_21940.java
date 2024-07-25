package BOJ_21940;

import java.io.*;
import java.util.*;

public class BOJ_21940 {

    // https://www.acmicpc.net/problem/21940
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K;
    private static int[][] arr;
    private static int[] friends;

    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_21940\\res.txt"));
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
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int result = 0;
            for (int f : friends) {
                result = Math.max(result, arr[f][i] + arr[i][f]);
            }

            if (ans > result) {
                list = new ArrayList<>();
                list.add(i);
                ans = result;
            } else if (ans == result) {
                list.add(i);
            }
        }

        Collections.sort(list);
        for (int idx : list) {
            sb.append(idx).append(' ');
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

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[a][b] = t;
        }

        K = Integer.parseInt(br.readLine());
        friends = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
