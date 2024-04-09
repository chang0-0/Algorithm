package BOJ_17391;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_17391 {

    // https://www.acmicpc.net/problem/17391
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] map;

    private static final int INF = Integer.MAX_VALUE;
    private static final int[] dirX = {1, 0}; // 하 우
    private static final int[] dirY = {0, 1}; // 하 우

    private static class Coordinate {
        int x;
        int y;
        int count;
        int dir;
        int total;

        private Coordinate(int x, int y, int count, int dir, int total) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
            this.total = total;
        }
    } // End of Coordinate


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
        if (ret == INF) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }

        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;

        int[][][] counts = new int[N + 1][M + 1][2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 2; k++) {
                    counts[i][j][k] = INF;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            counts[1][1][i] = 0;
            que.offer(new Coordinate(1, 1, map[1][1], i, counts[1][1][i]));
        }

        // 부스터는 모두 사용하지 않아도 된다.
        // 단 멈추면 기존의 부스터 개수는 초기화 된다.

        while (!que.isEmpty()) {
            Coordinate current = que.poll();

            if (counts[current.x][current.y][current.dir] < current.total) continue;
            if (current.x == N && current.y == M) {
                ans = Math.min(ans, current.total);
                continue;
            }

            int nextX = current.x;
            int nextY = current.y;
            for (int i = 0; i < current.count; i++) {
                nextX += dirX[current.dir];
                nextY += dirY[current.dir];

                if (!isAbleCheck(nextX, nextY)) continue;

                for (int j = 0; j < 2; j++) {
                    if (counts[nextX][nextY][j] > counts[current.x][current.y][j] + 1) {
                        counts[nextX][nextY][j] = counts[current.x][current.y][j] + 1;
                        que.offer(new Coordinate(nextX, nextY, map[nextX][nextY], j, counts[nextX][nextY][j]));
                    }
                }
            }
        }

        return ans;
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= M;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
