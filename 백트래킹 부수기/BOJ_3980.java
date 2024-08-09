package BOJ_3980;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3980 {

    // https://www.acmicpc.net/problem/3980
    // input
    private static BufferedReader br;

    // variables
    private static final int N = 11;
    private static int ans;
    private static int[] comb;
    private static boolean[] combVisited;
    private static int[][] arr = new int[N][N];
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3980\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            input();
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0);
        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static void DFS(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int num : comb) {
                sum += num;
            }

            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (combVisited[i]) continue;
            if (isVisited[depth][i]) continue;
            if (arr[depth][i] == 0) continue;

            combVisited[i] = true;
            isVisited[depth][i] = true;
            comb[depth] = arr[depth][i];
            DFS(depth + 1);
            isVisited[depth][i] = false;
            combVisited[i] = false;
        }
    } // End of DFS()

    private static void input() throws IOException {
        ans = 0;
        isVisited = new boolean[N][N];
        comb = new int[N];
        combVisited = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
