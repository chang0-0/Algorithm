package BOJ_28447;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_28447 {

    // https://www.acmicpc.net/problem/28447
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, ans, sum;
    private static int[][] elements;
    private static int[] comb;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_28447\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        if (K == 0) {
            sb.append(0);
            return sb.toString();
        }

        DFS(0, 0);
        sb.append(ans);

        return sb.toString();
    } // End of solve()

    private static void DFS(int idx, int depth) {
        if (depth == K) {
            int[] temp = new int[2];
            sum = 0;
            check(0, 0, temp);
            ans = Math.max(ans, sum);

            return;
        }

        for (int i = idx; i < N; i++) {
            comb[depth] = i;
            DFS(i + 1, depth + 1);
        }
    } // End of DFS()

    private static void check(int idx, int depth, int[] temp) {
        if (depth == 2) {
            sum += elements[temp[0]][temp[1]];
            return;
        }

        for (int i = idx; i < K; i++) {
            temp[depth] = comb[i];
            check(i + 1, depth + 1, temp);
        }
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = Integer.MIN_VALUE;
        elements = new int[N][N];
        comb = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                elements[i][j] = num;
            }
        }
    } // End of input()
} // End of Main class
