package BOJ_2206;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2206 {

    // https://www.acmicpc.net/problem/2206
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] map;
    private static final int[] dirX = {0, 0, -1, 1};
    private static final int[] dirY = {-1, 1, 0, 0};

    private static class Coordinate {
        int x;
        int y;
        int move;
        int breakCount;

        private Coordinate(int x, int y, int move, int breakCount) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.breakCount = breakCount;
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
        if (ret == -1) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }

        return sb.toString();
    } // End of solve()

    private static int BFS() {
        LinkedList<Coordinate> pQue = new LinkedList<>();
        boolean[][][] visited = new boolean[N + 1][M + 1][2];

        pQue.offer(new Coordinate(1, 1, 1, 0));
        visited[1][1][0] = true;

        while (!pQue.isEmpty()) {
            Coordinate current = pQue.poll();

            if (current.x == N && current.y == M) {
                return current.move;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dirX[i];
                int nextY = current.y + dirY[i];

                if (!isAbleCheck(nextX, nextY)) continue;

                if (map[nextX][nextY] == 1 && current.breakCount == 0 && !visited[nextX][nextY][1]) {
                    visited[nextX][nextY][1] = true;
                    pQue.offer(new Coordinate(nextX, nextY, current.move + 1, 1));

                }

                if (map[nextX][nextY] == 0 && !visited[nextX][nextY][current.breakCount]) {
                    visited[nextX][nextY][current.breakCount] = true;
                    pQue.offer(new Coordinate(nextX, nextY, current.move + 1, current.breakCount));
                }

            }
        }

        return -1;
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
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = temp.charAt(j - 1) - '0';
            }
        }
    } // End of input()
} // End of Main class
