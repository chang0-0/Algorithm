package BOJ_2206;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2206 {

    // https://www.acmicpc.net/problem/2206
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] board;
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};

    private static class Coordinate {
        int x;
        int y;
        int count;
        boolean broken;

        private Coordinate(int x, int y, int count, boolean broken) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.broken = broken;
        }

        @Override
        public String toString() {
            return "Coordinate{" + x + ", " + y + ", " + count + ", " + broken + "}";
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2206\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ret = BFS();
        sb.append(ret == Integer.MAX_VALUE ? -1 : ret);
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        boolean[][][] isVisited = new boolean[N][M][2];
        int ans = Integer.MAX_VALUE;
        que.offer(new Coordinate(0, 0, 1, false));

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (isVisited[cur.x][cur.y][cur.broken ? 0 : 1]) continue;
            isVisited[cur.x][cur.y][cur.broken ? 0 : 1] = true;
            if (cur.x == N - 1 && cur.y == M - 1) {
                ans = Math.min(ans, cur.count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;

                if (!isAbleCheck(nX, nY)) continue;

                if (board[nX][nY] == 0) {
                    que.offer(new Coordinate(nX, nY, cur.count + 1, cur.broken));
                }

                if (board[nX][nY] == 1 && !cur.broken) {
                    que.offer(new Coordinate(nX, nY, cur.count + 1, true));
                }
            }
        }

        return ans;
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
    } // End of input()
} // End of Main class
