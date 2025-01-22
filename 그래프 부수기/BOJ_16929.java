package BOJ_16929;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16929 {

    // https://www.acmicpc.net/problem/16929
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[][] board;
    private static boolean[][] isVisited;
    private static final int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
    private static final int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16929\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isVisited[i][j]) continue;

                if (DFS(i, j, i, j, board[i][j])) {
                    sb.append("Yes");
                    return sb.toString();
                }
            }
        }


        sb.append("No");
        return sb.toString();
    } // End of solve()

    private static boolean DFS(int x, int y, int preX, int preY, char color) {
        if (isVisited[x][y]) return true;
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = dirX[i] + x;
            int nY = dirY[i] + y;

            if (!isAbleCheck(nX, nY, color)) continue;
            if (nX != preX || nY != preY) {
                if (DFS(nX, nY, x, y, color)) return true;
            }
        }

        return false;
    } // End of DFS()

    private static boolean isAbleCheck(int x, int y, char color) {
        return x >= 0 && x < N && y >= 0 && y < M && board[x][y] == color;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
    } // End of input()
} // End of Main class
