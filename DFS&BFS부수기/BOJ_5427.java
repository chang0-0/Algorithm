package BOJ_5427;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5427 {

    // https://www.acmicpc.net/problem/5427
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static Coordinate start;
    private static ArrayDeque<Coordinate> que;
    private static boolean[][] isVisited;
    private static char[][] board = new char[1001][1001];

    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static class Coordinate {
        int x;
        int y;
        int time;
        char type;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int time, char type) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    ", type=" + type +
                    '}';
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5427\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        que.offer(new Coordinate(start.x, start.y, 0, 's'));
        int ret = BFS();
        if(ret == -1) {
            sb.append(IMPOSSIBLE);
        } else {
            sb.append(ret);
        }

        sb.append('\n');
        return sb.toString();
    } // End of solve()

    private static int BFS() {

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + cur.x;
                int nextY = dirY[i] + cur.y;

                if (cur.type == 's') {
                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                        return cur.time + 1;
                    }
                }

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;
                if (cur.type == 'f') {
                    que.offer(new Coordinate(nextX, nextY, cur.time, 'f'));
                    board[nextX][nextY] = '*';
                    isVisited[nextX][nextY] = true;
                } else {
                    if (board[nextX][nextY] != '*') {
                        que.offer(new Coordinate(nextX, nextY, cur.time + 1, 's'));
                        board[nextX][nextY] = '@';
                        board[cur.x][cur.y] = '.';
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
        }

        return -1;
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY] && board[nextX][nextY] != '#';
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        que = new ArrayDeque<>();
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = temp.charAt(j);

                if (board[i][j] == '@') {
                    start = new Coordinate(i, j);
                    board[i][j] = '.';
                    isVisited[i][j] = true;
                } else if (board[i][j] == '*') {
                    que.offer(new Coordinate(i, j, 0, 'f'));
                    isVisited[i][j] = true;
                }
            }
        }
    } // End of input()
} // End of Main class
