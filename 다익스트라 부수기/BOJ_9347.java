package BOJ_9347;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9347 {

    // https://www.acmicpc.net/problem/9347
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static final int MAX = 1001;
    private static final int[][] board = new int[MAX][MAX];
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int count;

        private Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Coordinate o) {
            return count - o.count;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9347\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] ret = BFS();
        sb.append(ret[0]).append(' ').append(ret[1]).append('\n');
        return sb.toString();
    } // End of solve()

    private static int[] BFS() {
        PriorityQueue<Coordinate> que = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][M];
        int[][] counts = new int[N][M];
        for (int[] t : counts) Arrays.fill(t, MAX);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    if (board[i][j] == 0) {
                        que.offer(new Coordinate(i, j, 0));
                        counts[i][j] = 0;
                    } else {
                        que.offer(new Coordinate(i, j, 1));
                        counts[i][j] = 1;
                    }
                    isVisited[i][j] = true;
                }
            }
        }


        int maxCount = 0;
        int count = 0;
        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (board[cur.x][cur.y] == 0) {
                if (cur.count > maxCount) {
                    count = 1;
                    maxCount = cur.count;
                } else if (cur.count == maxCount) {
                    count++;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;
                if (!isAbleCheck(nX, nY, isVisited)) continue;

                if (board[nX][nY] == 0) {
                    if (counts[nX][nY] > counts[cur.x][cur.y]) {
                        counts[nX][nY] = counts[cur.x][cur.y];
                        que.offer(new Coordinate(nX, nY, counts[nX][nY]));
                        isVisited[nX][nY] = true;
                    }
                } else {
                    if (counts[nX][nY] > counts[cur.x][cur.y] + 1) {
                        counts[nX][nY] = counts[cur.x][cur.y] + 1;
                        que.offer(new Coordinate(nX, nY, counts[nX][nY]));
                        isVisited[nX][nY] = true;
                    }
                }
            }
        }

        return new int[]{maxCount, count};
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y, boolean[][] isVisited) {
        return x >= 0 && x < N && y >= 0 && y < M && !isVisited[x][y];
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
