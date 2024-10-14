package BOJ_17391;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17391 {

    // https://www.acmicpc.net/problem/17391
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] board;
    private static final int[] dirX = {1, 0};
    private static final int[] dirY = {0, 1};

    private static class Coordinate {
        int x;
        int y;
        int count;

        private Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17391\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ret = BFS();

        sb.append(ret);
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        int[][] memo = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE / 2);
        }
        int ans = Integer.MAX_VALUE / 2;
        que.offer(new Coordinate(0, 0, 0));
        memo[0][0] = 0;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                ans = Math.min(ans, cur.count);
                continue;
            }

            for (int i = 1; i <= board[cur.x][cur.y]; i++) {
                for (int j = 0; j < 2; j++) {
                    int nX = cur.x + (dirX[j] * i);
                    int nY = cur.y + (dirY[j] * i);

                    if (!isAbleCheck(nX, nY)) continue;

                    if (memo[nX][nY] > memo[cur.x][cur.y] + 1) {
                        memo[nX][nY] = memo[cur.x][cur.y] + 1;
                        que.offer(new Coordinate(nX, nY, memo[nX][nY]));
                    }
                }
            }
        }

        return ans;
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    } // End of isAbleCheck

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
