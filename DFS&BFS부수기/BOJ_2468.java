package BOJ_2468;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2468 {

    // https://www.acmicpc.net/problem/2468
    // input
    private static BufferedReader br;

    // variables
    private static int N, maxHeight, minHeight;
    private static boolean[][] isVisited;
    private static int[][] board;
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2468\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 1;
        for (int i = minHeight; i < maxHeight; i++) {
            isVisited = new boolean[N][N];
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!isVisited[j][k] && board[j][k] > i) {
                        BFS(i, j, k);
                        count++;
                    }
                }
            }

            ans = Math.max(ans, count);
        }


        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void BFS(int height, int x, int y) {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        que.offer(new Coordinate(x, y));
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];

                if (!isAbleCheck(nX, nY, height)) continue;
                isVisited[nX][nY] = true;
                que.offer(new Coordinate(nX, nY));
            }
        }

    } // End of BFS()

    private static boolean isAbleCheck(int x, int y, int height) {
        return x >= 0 && x < N && y >= 0 && y < N && !isVisited[x][y] && board[x][y] > height;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        maxHeight = 0;
        minHeight = 101;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                minHeight = Math.min(minHeight, board[i][j]);
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }
    } // End of input()
} // End of Main class
