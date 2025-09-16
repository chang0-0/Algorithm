package BOJ_2665;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2665 {

    // https://www.acmicpc.net/problem/2665
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[][] board;
    private static final int INF = Integer.MAX_VALUE;
    private static final int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
    private static final int[] dirY = {0, 1, 0, -1};

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int dir;
        int count;

        private Coordinate(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }

        @Override
        public int compareTo(Coordinate o) {
            return count - o.count;
        }

        @Override
        public String toString() {
            return "Coordinate{" + x + ", " + y + ", " + dir + ", " + count + "}";
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2665\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<Coordinate> que = new PriorityQueue<>();
        int[][][] memo = new int[N][N][4];
        boolean[][][] isVisited = new boolean[N][N][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(memo[i][j], INF);
            }
        }

        for (int i = 0; i < 4; i++) {
            que.offer(new Coordinate(0, 0, i, 0));
            memo[0][0][i] = 0;
        }


        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (memo[cur.x][cur.y][cur.dir] < cur.count) continue;
            if (isVisited[cur.x][cur.y][cur.dir]) continue;
            isVisited[cur.x][cur.y][cur.dir] = true;


            for (int i = 0; i < 4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;

                if (!check(nX, nY)) continue;

                if (board[nX][nY] == 0) {
                    // 검은 방.
                    if (memo[nX][nY][i] > memo[cur.x][cur.y][cur.dir] + 1) {
                        memo[nX][nY][i] = memo[cur.x][cur.y][cur.dir] + 1;
                        que.offer(new Coordinate(nX, nY, i, memo[nX][nY][i]));
                    }
                } else {
                    // 흰방.
                    if (memo[nX][nY][i] > memo[cur.x][cur.y][cur.dir]) {
                        memo[nX][nY][i] = memo[cur.x][cur.y][cur.dir];
                        que.offer(new Coordinate(nX, nY, i, memo[nX][nY][i]));
                    }
                }
            }
        }

        int ret = INF;
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, memo[N - 1][N - 1][i]);
        }

        return ret;
    } // End of BFS()

    private static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    } // End of check()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = temp.charAt(j);
                board[i][j] = Character.getNumericValue(ch);
            }
        }

    } // End of input()
}  // End of Main class
