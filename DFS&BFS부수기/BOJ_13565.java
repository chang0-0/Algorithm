package BOJ_13565;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_13565 {

    // https://www.acmicpc.net/problem/13565
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] board;
    private static boolean[][] isVisited;

    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, -1, 0, 1};

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_13565\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (board[0][i] == 0 && !isVisited[0][i]) {
                boolean ret = BFS(0, i);
                if (ret) {
                    sb.append("YES");
                    return sb.toString();
                }
            }
        }

        sb.append("NO");
        return sb.toString();
    } // End of solve()

    private static boolean BFS(int x, int y) {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        que.offer(new Coordinate(x, y));
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (cur.x == N - 1 && (cur.y >= 0 && cur.y < M)) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + cur.x;
                int nextY = dirY[i] + cur.y;

                if (!isAbleCheck(nextX, nextY)) continue;
                isVisited[nextX][nextY] = true;
                que.offer(new Coordinate(nextX, nextY));
            }
        }

        return false;
    } // End of DFS()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY] && board[nextX][nextY] == 0;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
    } // End of input()
} // End of Main class
