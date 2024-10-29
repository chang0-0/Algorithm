package SWEA_4193;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4193 {

    // https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWKaG6_6AGQDFARV
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[][] board = new int[15][15];
    private static Coordinate start, end;
    private static final int[] dirX = {1, 0, -1, 0}; // 상 우 하 좌
    private static final int[] dirY = {0, 1, 0, -1};
    private static final int INF = Integer.MAX_VALUE / 2;

    private static class Coordinate {
        int x;
        int y;
        int time;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\SWEA_4193\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            bw.write("#" + i + " ");
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ret = BFS();
        sb.append(ret == INF ? -1 : ret).append('\n');
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        int[][] times = new int[N][N];
        for (int[] t : times) {
            Arrays.fill(t, Integer.MAX_VALUE / 2);
        }
        que.offer(new Coordinate(start.x, start.y, 0));
        times[start.x][start.y] = 0;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;

                if (!isAbleCheck(nX, nY)) continue;

                if (board[nX][nY] == 2) {
                    if ((cur.time + 1) % 3 == 0) {
                        if (times[nX][nY] > cur.time + 1) {
                            times[nX][nY] = cur.time + 1;
                            que.offer(new Coordinate(nX, nY, times[nX][nY]));
                        }
                    } else {
                        // 소용돌이 없어질 때까지 기다리기
                        que.offer(new Coordinate(cur.x, cur.y, cur.time + 1));
                    }
                } else if (board[nX][nY] == 0) {
                    if (times[nX][nY] > cur.time + 1) {
                        times[nX][nY] = cur.time + 1;
                        que.offer(new Coordinate(nX, nY, times[nX][nY]));
                    }
                }
            }
        }

        return times[end.x][end.y];
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && board[x][y] != 1;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Coordinate(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

        st = new StringTokenizer(br.readLine());
        end = new Coordinate(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );
    } // End of input()
} // End of Main class
