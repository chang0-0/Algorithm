package BOJ_18290;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18290 {

    // https://www.acmicpc.net/problem/18290
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K, ans;
    private static int[][] arr;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_18290\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0, 0, 0, 0);
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int x, int y, int sum, int depth) {
        if (depth == K) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = (i == x ? y : 0); j < M; j++) {
                if (isAbleCheck(i, j)) {
                    isVisited[i][j] = true;
                    DFS(i, j + 1, sum + arr[i][j], depth + 1);
                    isVisited[i][j] = false;
                }

            }
        }
    } // End of DFS()

    private static boolean isAbleCheck(int x, int y) {
        if (isVisited[x][y]) return false;
        if (x - 1 >= 0 && isVisited[x - 1][y]) return false;
        if (y - 1 >= 0 && isVisited[x][y - 1]) return false;
        if (x + 1 < N && isVisited[x + 1][y]) return false;
        if (y + 1 < M && isVisited[x][y + 1]) return false;
        return true;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = Integer.MIN_VALUE;
        arr = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
